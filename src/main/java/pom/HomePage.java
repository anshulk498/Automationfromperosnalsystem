package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.Webdriver_Utility;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath = "//a[.='More']")private WebElement moretext;
	
	@FindBy(xpath = "//a[.='Campaigns']")private WebElement campaigntext;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")private WebElement signoutimagetext;
	
	@FindBy(xpath = "//a[.='Sign Out']")private WebElement submitbtntext;
	
	@FindBy(xpath = "//a[.='Products']")private WebElement producttext;
	
	@FindBy(xpath = "//table[@class='hdrTabBg']//a[.='Organizations']")private WebElement createorganisationtext;
	
	
	
	public WebElement getCreateorganisationtext() {
		return createorganisationtext;
	}
	public WebElement getMoreText() {
		return moretext;
		
	}
	public WebElement getCampaignText() {
		return campaigntext ;
		
	}
	public WebElement getSignoutimagetext() {
		return signoutimagetext;
	}
	public WebElement getSubmitbtntext() {
		return submitbtntext;
	}
	 public WebElement getSubmittext() {
		return producttext;
		 
	 }
	
	
	
	//bussiness logic
	public void moreLink(WebDriver driver) {
		moretext.click();
		
	}
	
	public void CampaignText(WebDriver driver) {
		campaigntext.click();
	}
	
	public void signoutclick(WebDriver driver) {
		Webdriver_Utility wu=new Webdriver_Utility();
		wu.movetoelement(driver, signoutimagetext);
		submitbtntext.click();
	}
	
	public void productText(WebDriver driver) {
		producttext.click();
		
	}
	
	public void createOrganisation(WebDriver driver) {
		createorganisationtext.click();
	}

}
