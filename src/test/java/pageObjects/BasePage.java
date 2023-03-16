package pageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	WebDriver driver;//variable
	
	//Constructor
	BasePage(WebDriver driver){
		this.driver = driver;//Initiate
		PageFactory.initElements(driver, this);//To initialize the webElements
	}

}



