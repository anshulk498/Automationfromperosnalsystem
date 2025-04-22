package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.Webdriver_Utility;

public class CreateNewCampaign {
	
	//intialization
	public CreateNewCampaign(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	//declaration
	@FindBy(xpath = "//img[@title='Create Campaign...']")private WebElement createcampaigntext;
	
	@FindBy(xpath = "//input[@name='campaignname']")private WebElement inputcreatecampaigntext;
	
	@FindBy(xpath = "//div[@align='center']//input[@title='Save [Alt+S]']")private WebElement savecampaigntext;

	public WebElement getCreatecampaigntext() {
		return createcampaigntext;
	}

	public WebElement getInputcreatecampaigntext() {
		return inputcreatecampaigntext;
	}

	public WebElement getSavecampaigntext() {
		return savecampaigntext;
	}
	
	//bussiness logic
	public void createCampaign(WebDriver driver) {
		createcampaigntext.click();
	}
	
	public void sendkeyTextfield(WebDriver driver,String text) {
		
		inputcreatecampaigntext.click();
		inputcreatecampaigntext.clear();
		Webdriver_Utility wu=new Webdriver_Utility();
		wu.sendkeys(inputcreatecampaigntext, text);
		
	}
	
	public void saveCampaign() {
		savecampaigntext.click();
	}

}
