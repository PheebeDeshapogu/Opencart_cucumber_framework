package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	 //Constructor
	  public  HomePage(WebDriver driver){
		  super(driver);
	   }
	   
	   //WebElement
	   @FindBy(xpath="//span[normalize-space()='My Account']")
	   WebElement lnkMyaccount;
	   
	   
	    @FindBy(xpath="//a[normalize-space()='Register']")
	    WebElement lnkRegister;
	    
	    @FindBy(xpath ="//a[normalize-space()='Login']")
	    WebElement lnkLogin;
	    
	    @FindBy(xpath="//input[@placeholder='Search']")  //For Search Product Test
		WebElement txtSearchbox;
	    
	    @FindBy(xpath="//div[@id='search']//button[@type='button']") //For Search Product Test
		WebElement btnSearch;
		
	    
	    
	    //Action Methods
	    public void clickMyAccount() {
	    	lnkMyaccount.click();
	    }
	    
	    public void clickRegister() {
	    	lnkRegister.click();
	    }
	    
	    public void clickLogin() {
	    	lnkLogin.click();
	    }
	    
	    public void enterProductName(String pName)   //For Search Product Test
		{
			txtSearchbox.sendKeys(pName);
		}
	    
	    public void clickSearch()  //For Search Product Test
		{
			btnSearch.click();
		}
		
		
	}


