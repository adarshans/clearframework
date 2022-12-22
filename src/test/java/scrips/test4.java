
package scrips;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.hc.client5.http.async.methods.AbstractBinResponseConsumer;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.mysql.cj.Query;

import genericlibrary.baseclass;
import pompages.junitpage;
import pompages.skillloginpage;
import pompages.skilrarydemopage;

public class test4 extends baseclass {
	@Test
	public void tc5() throws FileNotFoundException, IOException, SQLException {
		Test=reports.createTest("tc2");
		skillloginpage sl=new skillloginpage(driver);
		skilrarydemopage da = sl.demoapp(driver);
		utilities.switchtabs(driver);
		utilities.dropDown(da.getSelectdd(),fu.getpropertyfile("select"));
		junitpage j=new junitpage(driver);
		
		String query = "Select * from course";
		String data = fu.executequery(query,1,"INR 19.00");
		

	}
	}
