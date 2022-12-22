package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class corejavapage {
	
	@FindBy(xpath = "//a[contains(text(),' Core Java For Selenium ')]")
	private WebElement corjavaforselenium;
	 public corejavapage(WebDriver driver) {
		 PageFactory.initElements(driver,this);
	 }

	public WebElement getCorjavaforselenium() {
		return corjavaforselenium;
	}
	
	public corejavaforselepage javaforsel(WebDriver driver) {
		corjavaforselenium.click();
		return new corejavaforselepage(driver);
		
	}

}
