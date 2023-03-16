package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {
WebDriver driver;
	
	public SearchPage(WebDriver driver)
	{
		super(driver);
	}	
	     ////*[@id='content']/div[3]//img
		@FindBy(xpath="//*[@id='product-list']/div[*]/form/div/div/a/img")
		List<WebElement> searchProducts;
		
		@FindBy(xpath="//button[@id='button-search']")
		WebElement searchBtn;
				
		@FindBy(xpath="//input[@id='input-quantity']")
		WebElement txtquantity;
		
		@FindBy(xpath="//button[@id='button-cart']")
		WebElement btnaddToCart;
		
		@FindBy(xpath="//div[contains(text(),'Success: You have added')]")
		WebElement cnfMsg;
		
		public boolean isProductExist(String productName)
		{
			boolean flag=false;
			for(WebElement product:searchProducts)
			{	
				System.out.println("product.getAttribute(\"title\") => "+product.getAttribute("title"));
				if(product.getAttribute("title").equals(productName))
				{
				flag=true;
				break;
				}
			}
			
			return flag;
		
		}
		
		public void searchBtn() {
			searchBtn.click();
		}
		
		
		public void selectProduct(String productName)
		{
			for(WebElement product:searchProducts)
			{				
				if(product.getAttribute("title").equals(productName))
				{
					product.click();
				}
			}
		
		}
		
		public void setQuantity(String qty)
		{
			txtquantity.clear();
			txtquantity.sendKeys(qty);
		}
		
		public void addToCart()
		{
			btnaddToCart.click();
		}
		
		public boolean checkConfMsg()
		{
			try
			{
			return cnfMsg.isDisplayed();
			}
			catch(Exception e)
			{
				return false;
			}
		}
		
}
