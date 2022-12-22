package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class corejavaforselepage {
	
	
	@FindBy(xpath = "//button[@aria-label='Play']//*[name()='svg']//*[name()='path' and contains(@class,'fill')]")
     private WebElement play;
	
      @FindBy(xpath = "//button[@aria-label='Pause']//*[name()='svg']")
       private WebElement pause;
      
      @FindBy(xpath = "//span[text()='Add To Wishlist']" )
      private WebElement wishlist;
		
      public corejavaforselepage(WebDriver driver) {
    	  PageFactory.initElements( driver,this);
      }
      
	

     public void playandpause() {
	   
	    play.click();
	    pause.click();
}
    
	
	public void wishlst() {
    	 wishlist.click();
     }
}


