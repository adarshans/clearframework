package pompages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import genericlibrary.baseclass;

public class junitpage {
	
	@FindBy(xpath = "(//a[text()='munit testing '])[2]")
	private WebElement junit;
	
	public WebElement getJunit() {
		return junit;
	}

	public junitpage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	
	
	}

}
