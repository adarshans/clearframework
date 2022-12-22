package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class skilrarydemopage {
	
	@FindBy(xpath="//select[@class='chosen-select']")
	private WebElement selectdd;

	public WebElement getSelectdd() {
		return selectdd;
	}

	public WebElement getCors() {
		return cors;
	}

	public WebElement getSeltraing() {
		return seltraing;
	}

	@FindBy(id="course")
	private WebElement cors;
	
	@FindBy(xpath = "(//a[text()='Selenium Training'])[1]")
	private WebElement seltraing;
	
	public skilrarydemopage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	
	
	public addtocartpage cart(WebDriver driver) {
		seltraing.click();
		return new addtocartpage(driver);
	}
}
