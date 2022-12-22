package scrips;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericlibrary.baseclass;
import pompages.corejavaforselepage;
import pompages.corejavapage;
import pompages.skillloginpage;

public class test3 extends baseclass {
	@Test
	public void tc2() throws FileNotFoundException, IOException {
	Test=reports.createTest("tc2");
	skillloginpage sl=new skillloginpage(driver);
	
	 corejavapage cjp = sl.surchcorejava(driver, fu.getpropertyfile("crsname"));
	 corejavaforselepage coreforsel = cjp.javaforsel(driver);
	 sl.getAcepppopup().click();
	 utilities.switchtoframe(driver);
	 coreforsel.playandpause();
	 utilities.switchback(driver);
	 coreforsel.wishlst();
	 Assert.assertEquals(driver.getTitle(),fu.getpropertyfile("title"));
	// Reporter.log(driver.getTitle(),true);
	}
}
