package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class skillloginpage {
	@FindBy(xpath = "//a[@class='close_cookies']")
	private WebElement acepppopup;
	
	public WebElement getAcepppopup() {
		return acepppopup;
	}

	@FindBy(xpath = "//a[text()=' GEARS ']")
	private WebElement gers;
	
	@FindBy(name = "q")
	private WebElement name;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitbtn;
	
	
	public WebElement getName() {
		return name;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}

	@FindBy(xpath = "(//a[text()=' SkillRary Demo APP'])[2]")
    private WebElement skildemo;
	
	@FindBy(xpath = "//a[text()=' Contact Us ']")
	private WebElement contactus;
	
	public skillloginpage (WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getGers() {
		return gers;
	}

	public WebElement getSkildemo() {
		return skildemo;
	}
	public contactuspage contus(WebDriver driver) {
		contactus.click();
		return new contactuspage(driver);
		
		
	}
	public skilrarydemopage demoapp(WebDriver driver) {
		gers.click();
		skildemo.click();
		
		return new skilrarydemopage(driver);
		
	}

	public WebElement getContactus() {
		return contactus;
	}
	public corejavapage surchcorejava(WebDriver driver, String name1) {
		name.sendKeys(name1);
		submitbtn.click();
		return new corejavapage(driver);
	}
}
