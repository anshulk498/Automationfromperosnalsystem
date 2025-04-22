package vtiger;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateOrganisationWithDataProvider {
	@Test(dataProvider = "getData")
	public void createOrganisation(String name,String phone,String email) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(name);
		driver.findElement(By.id("phone")).sendKeys(phone);
		driver.findElement(By.id("email1")).sendKeys(email);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		Actions act=new Actions(driver);
	  act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
	 driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	
	}

	@DataProvider
	public Object[][] getData() {
		Random ran=new Random();
		int ranum = ran.nextInt(1000);
		
		Object[][] obj=new Object[3][3];
		obj[0][0]="aaa"+ranum;
		obj[0][1]="123456";
		obj[0][2]="anshul@gmail.com";
		
		obj[1][0]="bbb"+ranum;
		obj[1][1]="12345678";
		obj[1][2]="anshul1@gmail.com";
		
		obj[2][0]="ccc"+ranum;
		obj[2][1]="1234567890";
		obj[2][2]="anshul2@gmail.com";
		return obj;
		
	}
	
	
}
