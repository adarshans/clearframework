package genericlibrary;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hpsf.Date;
import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.detDSA;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class photo {
	
	public String getscreenshot(WebDriver driver, String name) throws IOException {
		Date d=new Date();
		String date = d.toString().replaceAll(":","-");
		TakesScreenshot tS=(TakesScreenshot) driver;
		File src = tS.getScreenshotAs(OutputType.FILE);
        File dest=new File(Autoconstant.photopath+name+date+".png");
        FileUtils.copyFile(src, dest);
		return date;
	}
	
}
