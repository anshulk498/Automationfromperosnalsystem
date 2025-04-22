package pom;import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.Webdriver_Utility;

public class CreateOrganisationPom {
	
	public CreateOrganisationPom(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath = "//img[@title='Create Organization...']")private WebElement createorganization;
	
	@FindBy(xpath = "//input[@name='accountname']")private WebElement inputorganization;
	
	@FindBy(xpath = "//div[@align='center']//input[@title='Save [Alt+S]']")private WebElement saveorganization;

	public WebElement getCreateorganization() {
		return createorganization;
	}

	public WebElement getInputorganization() {
		return inputorganization;
	}

	public WebElement getSaveorganization() {
		return saveorganization;
	}
	//bussiness logic
	
	public void createOrganization(WebDriver driver) {
		createorganization.click();
	}

	public void sendkeyOrganization(WebDriver driver,String text) {
		inputorganization.click();
		Webdriver_Utility wu=new Webdriver_Utility();
		wu.sendkeys(inputorganization, text);
	}
	 public void saveOrganization(WebDriver driver) {
		 saveorganization.click();
	 }
}
