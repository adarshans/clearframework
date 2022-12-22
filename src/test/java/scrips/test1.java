package scrips;

import org.testng.annotations.Test;

import genericlibrary.baseclass;
import pompages.addtocartpage;
import pompages.skillloginpage;
import pompages.skilrarydemopage;

public class test1 extends baseclass {
@Test
 
public void tc1() {
	Test=reports.createTest("tc1");
	skillloginpage lp=new skillloginpage(driver);
	skilrarydemopage sd = lp.demoapp(driver);
	utilities.switchtabs(driver);
	utilities.mouseHover(driver,sd.getCors());
	addtocartpage car = sd.cart(driver);
	utilities.doubleclick(driver, car.getPlus());
	car.getAddbtn().click();
	utilities.alertpopup(driver);
}

}
