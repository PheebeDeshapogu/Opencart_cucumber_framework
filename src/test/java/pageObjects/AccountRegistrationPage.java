package pageObjects;



	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	//import org.testng.Assert;

	public class AccountRegistrationPage  extends BasePage{
		
		//Constructor
	   public AccountRegistrationPage(WebDriver driver) {
		   super(driver);
	   }
	   
	   
	   //WebElements
	   @FindBy(xpath="//input[@id='input-firstname']")
	   WebElement txtfirstname;
	   
	   @FindBy(xpath="//input[@id='input-lastname']")
	   WebElement txtlastname;
	   
	   @FindBy(xpath="//input[@id='input-email']")
	   WebElement txtemail;
	   
	   @FindBy(xpath="//input[@id='input-password']")
	   WebElement txtpassword;
	   
	   @FindBy(xpath="//input[@name='agree']")
	   WebElement chkdPolicy;
	   
	   @FindBy(xpath="//button[normalize-space()='Continue']")
	   WebElement btnContinue;
	   
	   @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	   WebElement msgconfirmation;
	   
	   @FindBy(xpath="//h2[normalize-space()='My Account']")
	   WebElement msgHeading;


	   
	   //Action Methods
	   public void setFirstName(String fname) {
		   txtfirstname.sendKeys(fname);
	   }
	   public void setlastname(String lname) {
		   txtlastname.sendKeys(lname);
	   }
	   public void setemail(String email) {
		   txtemail.sendKeys(email);
	   }
	   public void setPassword(String pwd) {
		   txtpassword.sendKeys(pwd);
	   }
	   public void setPrivacyPolicy() throws InterruptedException {
		   JavascriptExecutor js = (JavascriptExecutor)driver;
		   js.executeScript("arguments[0].scrollIntoView(true); ", chkdPolicy);
		   Thread.sleep(2000);
		   chkdPolicy.click();
	   }
	   public void continueBtn() throws InterruptedException {
		   JavascriptExecutor js = (JavascriptExecutor)driver;
		   js.executeScript("arguments[0].click();", btnContinue);
		   Thread.sleep(5000);
		   btnContinue.click();
//		   js.executeScript("arguments[0].click();", btnContinue);
		  // btnContinue.click();
	   }
	   public boolean isMyAccountHeaderExists() 
		{
			try {
				return(msgHeading.isDisplayed());
			} catch(Exception e ) {
				return(false);
			}
		}
		   

	}


