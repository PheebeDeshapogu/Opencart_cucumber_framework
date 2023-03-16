package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	public MyAccountPage(WebDriver driver){
		super(driver);
	}

	@FindBy(xpath="//h2[normalize-space()='My Account']")//My Account Page Heading
	WebElement msgHeading;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnkLogout;
	
	//ActionMethods
	public boolean isMyAccountPageExists() 
		{
			try {
				return(msgHeading.isDisplayed());
			} catch(Exception e ) {
				return(false);
			}
		}
		public void clickLogout() throws InterruptedException {
			 JavascriptExecutor js = (JavascriptExecutor)driver;
			 js.executeScript("arguments[0].scrollIntoView(true); ",lnkLogout );
			 Thread.sleep(10000);
			lnkLogout.click();
		}
}
