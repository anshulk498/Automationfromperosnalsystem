package pom;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationPom {
	
	public ValidationPom(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	@FindBy(xpath = "//span[@id= 'dtlview_Product Name']")private WebElement orgValidate;
	
	public WebElement getOrgValidate() {
		return orgValidate;
	}
	
	//bussines logic
	
	public String validateOrgName() {
		return orgValidate.getText();
	}
	
}
