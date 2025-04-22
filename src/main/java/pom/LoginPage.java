package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//create constructor intilization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
//declartion
	@FindBy(name="user_name")private WebElement usernametext;
	
	@FindBy(name="user_password")private WebElement userpasswordtext;
	
	@FindBy(id="submitButton")private WebElement submitbtn;
	//utilization
	public WebElement getUsernametext() {
		return usernametext;
	}

	public WebElement getUserpasswordtext() {
		return userpasswordtext;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	//bussiness logic
	public void LoginToApp(String username,String password) {
		usernametext.sendKeys(username);
		userpasswordtext.sendKeys(password);
		submitbtn.click();
	}
	
}
