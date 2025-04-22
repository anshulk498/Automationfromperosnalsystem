package vtiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic_utility.BaseClass;
import generic_utility.Excel_Utility;
import generic_utility.Java_Utility;
import generic_utility.Webdriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.CreateNewCampaign;
import pom.HomePage;
import pom.LoginPage;

public class CreateCampaignTest extends BaseClass {
	@Test
	//@Test(retryAnalyzer =generic_utility.RetryAnalyzer.class )
	public void createCampaign() throws Throwable {
//		FileInputStream fis=new FileInputStream("src/test/resources/Propertyfile.properties");
//		Properties pro=new Properties();
//		pro.load(fis);
//	 	WebDriver driver=null;
//		String BROWSER = pro.getProperty("browser");
//	    String URL = pro.getProperty("url");
//		String USERNAME = pro.getProperty("username");
//		String PASSWORD = pro.getProperty("password");
//		Webdriver_Utility wu=new Webdriver_Utility();
//		
//		if(BROWSER.equalsIgnoreCase("CHROME")) {
//			//WebDriverManager.chromedriver().setup();
//			 driver=new ChromeDriver();
//			 wu.getImplicitWait(driver);
//			 driver.manage().window().maximize();
//		}
//		else if(BROWSER.equalsIgnoreCase("edge")){
//			WebDriverManager.edgedriver().setup();
//			 driver=new EdgeDriver();
		
//			 wu.getImplicitWait(driver);
//			 driver.manage().window().maximize();	
//			
//		}else {
//			WebDriverManager.firefoxdriver().setup();
//			 driver=new FirefoxDriver();
//			 wu.getImplicitWait(driver);
//			 driver.manage().window().maximize();
//		}
//		Random ran=new Random();
//		int rannum = ran.nextInt(1000);
		
		Java_Utility ju=new Java_Utility();
		int rannum = ju.getRandomNum();
		
//		FileInputStream fis1=new FileInputStream("src/test/resources/exceldata.xlsx");
//		Workbook book=WorkbookFactory.create(fis1);
//		Sheet sheet = book.getSheet("Campaigns");
//		Row row = sheet.getRow(0);
//		Cell cell = row.getCell(0);
//		String data = cell.getStringCellValue()+rannum;
		Excel_Utility eu=new Excel_Utility();
		String data = eu.getExcelData("Campaigns", 0, 0)+rannum;
	//	driver.get(URL);
//		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
//		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		
//		wu.sendkeys( driver.findElement(By.xpath("//input[@name='user_name']")), USERNAME);
//		wu.sendkeys( driver.findElement(By.xpath("//input[@name='user_password']")), PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		//pom class
//		LoginPage loginPage=new LoginPage(driver);
//		loginPage.LoginToApp(USERNAME, PASSWORD);
		
//		driver.findElement(By.xpath("//a[.='More']")).click();
		//wu.movetoelement(driver,driver.findElement(By.xpath("//a[.='More']")));
		HomePage homepage=new HomePage(driver);
		homepage.moreLink(driver);

		Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[.='Campaigns']")).click();
		homepage.CampaignText(driver);
		//driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		CreateNewCampaign cc=new CreateNewCampaign(driver);
		cc.createCampaign(driver);
		//driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(data);
		cc.sendkeyTextfield(driver, data);
	//	driver.findElement(By.xpath("//div[@align='center']//input[@title='Save [Alt+S]']")).click();
		cc.saveCampaign();
	//	Assert.assertEquals(false, true);
//		String actualData = driver.findElement(By.cssSelector("//span.dvHeaderText]")).getText();
//		if(actualData.contains(data)) {
//			System.out.println("pass");
//		}else {
//			System.out.println("fail");
//		}
//		Thread.sleep(5000);
		
		//act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
//		wu.movetoelement(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
//		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
//		homepage.signoutclick(driver);
		
	}
//	@Test
//	public void m1() {
//		System.out.println("another");
//	}
}
