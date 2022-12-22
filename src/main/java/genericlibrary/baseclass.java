package genericlibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


import io.github.bonigarcia.wdm.WebDriverManager;

public class baseclass  {
	public ExtentHtmlReporter htmlreport;
	public static  ExtentReports reports;
	public  WebDriver driver;
	public static ExtentTest Test;
	public driverutilities utilities=new driverutilities();
	public fileutilities fu=new fileutilities();
	public static Connection con;
	
	
	@BeforeSuite
	public void configBS() throws SQLException {
		System.out.println("database started");
		con=fu.getdataDB();
		
		 htmlreport=new ExtentHtmlReporter(Autoconstant.reportsfile);
		htmlreport.config().setDocumentTitle("skillraryreport");
		htmlreport.config().setTheme(Theme.DARK);
		 reports=new ExtentReports();
		reports.attachReporter(htmlreport);
		
	}
@BeforeMethod

public void openapp() throws FileNotFoundException, IOException {
	
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(fu.getpropertyfile("url"));
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	
}
@AfterMethod
public void closeapp(ITestResult res) throws IOException {
	int result = res.getStatus();
	if(result==ITestResult.FAILURE) {
		Test.log(Status.FAIL,res.getName()+"testcase failed");
		Test.log(Status.FAIL, res.getThrowable()+"test case failed exeption");
	}
	else if(result==ITestResult.SUCCESS) {
		Test.log(Status.PASS,res.getName()+ "testcase passed");
	}
	else if(result==ITestResult.SKIP) {
		Test.log(Status.SKIP,res.getName()+ "testcase skipped");	
		
	}
	String name = res.getName();
	if(result==2) {
		photo p=new photo();
		p.getscreenshot(driver, name);
	}
	driver.close();
	
}
@AfterSuite
public void configAS() throws SQLException {
	htmlreport.flush();
	reports.flush();
	fu.closeDB();
	System.out.println("database closed");
}
}
