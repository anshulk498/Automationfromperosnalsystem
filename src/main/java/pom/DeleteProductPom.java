package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.Webdriver_Utility;

public class DeleteProductPom {
     public DeleteProductPom(WebDriver driver) {
    	 PageFactory.initElements( driver,this);
     }
     

		@FindBy(xpath = "//input[@title='Delete [Alt+D]']")private WebElement deleteproductext;
		
		 public WebElement getDeleteproductext() {
				return deleteproductext; 
				}	 
				
      public void deleteProduct(WebDriver driver) {
    	  deleteproductext.click();
    	  Webdriver_Utility wu=new Webdriver_Utility();
    	  wu.AcceptAlert(driver);
      }
     

}