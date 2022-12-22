package scrips;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import genericlibrary.demo;
import pompages.contactuspage;
import pompages.skillloginpage;
import pompages.skilrarydemopage;

public class test2 extends demo {
	
	
		@Test(dataProvider = "readdatafromexel")
		public void  tc5(String key, String key1, String key2, String key3) {
			Test=reports.createTest("tc5");
			skillloginpage sl=new skillloginpage(driver);
			contactuspage cus = sl.contus(driver);
			cus.contactusdetail(key, key1, key2, key3);
			
			
		}
		
	}


