package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class contactuspage {
	 
	@FindBy(name = "name")
	private WebElement name1;
	
	@FindBy(name = "sender")
	private WebElement sender1;
	
	@FindBy(name = "subject")
	private WebElement subject1;
	
	@FindBy(name="message")
	private WebElement message1;
	
	@FindBy(xpath = "//button[text()='Send us mail']")
	private WebElement submit1;
	
	public contactuspage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void contactusdetail(String key, String key1, String key2, String key3) {
		name1.sendKeys(key);
		sender1.sendKeys(key1);
		subject1.sendKeys(key2);
		message1.sendKeys(key3);
		submit1.click();
	}
	

}
