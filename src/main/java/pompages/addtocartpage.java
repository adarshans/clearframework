package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addtocartpage {
	@FindBy(id = "add")
	private WebElement plus;
	
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	private WebElement addbtn;
	
	public addtocartpage (WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getPlus() {
		return plus;
	}

	public WebElement getAddbtn() {
		return addbtn;
	}

}
