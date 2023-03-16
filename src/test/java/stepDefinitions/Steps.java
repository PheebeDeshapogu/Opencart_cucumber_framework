package stepDefinitions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataReader;

public class Steps {
	 Logger logger;// declaring the variable for logging
     ResourceBundle rb;//for reading properties file
	 WebDriver driver;
	 HomePage hp;
	LoginPage lp;
	MyAccountPage macc;
	String br;//to store browser name
	List<HashMap<String, String>> datamap;
	
	@Before
	public void setup() {
		rb = ResourceBundle.getBundle("config");// Load config.properties file
		
		logger = LogManager.getLogger(this.getClass());
		// this.getClass-captures the current test case which is executing;
		
		//Reading config.properties(for browser)
			 br = rb.getString("browser");											
			
			
	}
	@After
	public void tearDown(Scenario scenario) {
		System.out.println("Scenario status====>" +scenario.getStatus());
		if (scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
		}
		driver.quit();
		}
	
	@Given("User Launch browser")
	public void user_launch_browser() {
		
		ChromeOptions options = new ChromeOptions();//Both these statements are for removing "chrome is controlled by automated software"
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.addArguments("--remote-allow-origins=*");// Both these statements
		
		Map<String, Object> prefs = new HashMap<String, Object>();//these statements are only to remove the pop up to Save and Never
		prefs.put("credentials_enable_service", false);//these statements are only to remove the pop up to Save and Never
		prefs.put("profile.password_manager_enabled", false);//these statements are only to remove the pop up to Save and Never
		options.setExperimentalOption("prefs", prefs);//these statements are only to remove the pop up to Save and Never
		
		if (br.equals("chrome")) {
			driver = new ChromeDriver(options);
		} else if (br.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Given("opens URL {string}")
	public void opens_url(String url) {
	   driver.get(url); 
	   driver.manage().window().maximize();
	}

	@When("User navigate to My Account menu")
	public void user_navigate_to_my_account_menu() {
		   hp = new HomePage(driver);
	       hp.clickMyAccount();
	       logger.info("Clicked on My Account");
	}

	@When("click on Login")
	public void click_on_login() {
		hp.clickLogin();
		logger.info("Clicked on Login");
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String pwd) {
	   lp = new LoginPage(driver);
	   lp.setEmailAddress(email);
	   logger.info("Provided Email");
	   lp.setPassword(pwd);
	   logger.info("Provided Password");
	}

	@When("Click on Login button")
	public void click_on_login_button() {
	    lp.clickLoginBtn();
	}

	@Then("User navigates to MyAccount Page")
	public void user_navigates_to_my_account_page() {
	    macc = new MyAccountPage(driver);
	    boolean targetpage = macc.isMyAccountPageExists();
	    if(targetpage) {
	    	logger.info("Provided Password");
	    } else {
	    	logger.info("Login Failed");
	    	Assert.assertTrue(false);
	    }
	}
	//*******   Data Driven test method    **************
    @Then("check User navigates to My Account Page by passing Email and Password with excel row {string}")
    public void check_user_navigates_to_my_account_page_by_passing_email_and_password_with_excel_data(String rows)
    {
        datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\OC1PTEST.xlsx", "Sheet1");
//C:\Dev\Projects\eclipsews\Opencart_cucumber_framework\testData\OC1PTEST.xlsx
        int index=Integer.parseInt(rows)-1;
        String email= datamap.get(index).get("username");
        
        System.out.println(email );
        
       
        String pwd= datamap.get(index).get("password");
        
        System.out.println(pwd);
        
       
        String exp_res= datamap.get(index).get("res");
        
        System.out.println(exp_res );

        lp=new LoginPage(driver);
        lp.setEmailAddress(email);
        lp.setPassword(pwd);

        lp.clickLoginBtn();
        
		 
        try
        {
            boolean targetpage=macc.isMyAccountPageExists();

            if(exp_res.equals("Valid"))
            {
                if(targetpage==true)
                {
                    MyAccountPage myaccpage=new MyAccountPage(driver);
                    myaccpage.clickLogout();
                    Assert.assertTrue(true);
                }
                else
                {
                    Assert.assertTrue(false);
                }
            }

            if(exp_res.equals("Invalid"))
            {
                if(targetpage==true)
                {
                    macc.clickLogout();
                    Assert.assertTrue(false);
                    //even with Invalid data if it reaches Target page then its an error
                }
                else
                {
                    Assert.assertTrue(true);
                }
            }


        }
        catch(Exception e)
        {

            Assert.assertTrue(false);
        }
        driver.close();
    }

    //*******   Account Registration Methods    **************

   



}
