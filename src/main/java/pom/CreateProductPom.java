package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.Webdriver_Utility;

public class CreateProductPom {
	
	public CreateProductPom(WebDriver driver) {
		PageFactory.initElements( driver,this);
		
	}
	
	@FindBy(xpath = "//a[.='Products']")private WebElement producttext;
	
	@FindBy(xpath = "//img[@alt='Create Product...']")private WebElement createproducttext;
	
	@FindBy(xpath="//input[@name='productname']")private WebElement inputcreateproducttext;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")private WebElement savetext;

	public WebElement getProducttext() {
		return producttext;
	}

	public WebElement getCreateproducttext() {
		return createproducttext;
	}

	public WebElement getInputcreateproducttext() {
		return inputcreateproducttext;
	}

	public WebElement getSavetext() {
		return savetext;
	}
	
	//BUSSINES LOGIC
	public void reateProductText(WebDriver driver) {
		producttext.click();
	}
	
	public void createProductText(WebDriver driver) {
		createproducttext.click();
	}
	
	public void inputSend(WebDriver driver,String text) {
		inputcreateproducttext.click();
		Webdriver_Utility wu=new Webdriver_Utility();
		wu.sendkeys(inputcreateproducttext, text);
	}
	
	public void saveProduct(WebDriver driver) {
		savetext.click();
		
	}

}
