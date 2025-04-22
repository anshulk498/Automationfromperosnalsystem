package vtiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import org.testng.annotations.Test;

import generic_utility.BaseClass;
import generic_utility.Excel_Utility;
import generic_utility.Java_Utility;
import generic_utility.Property_Utility;
import generic_utility.Webdriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.CreateNewCampaign;
import pom.CreateProductPom;
import pom.HomePage;
import pom.LoginPage;

public class CreateCampaignWithProductTest extends BaseClass {
	@Test
	public void createCampaignwithproduct() throws Throwable {
		
//	FileInputStream fis=new FileInputStream("src/test/resources/Propertyfile.properties");
//	Properties pro=new Properties();
//	pro.load(fis);
//	WebDriver driver=null;
//	String BROWSER = pro.getProperty("browser");
//	String URL = pro.getProperty("url");
//	String USERNAME = pro.getProperty("username");
//	String PASSWORD = pro.getProperty("password");
	
	Webdriver_Utility wu=new Webdriver_Utility();
	Java_Utility ju=new Java_Utility();
	Excel_Utility eu=new Excel_Utility();
	Property_Utility pu=new Property_Utility();
	
//	if(BROWSER.equalsIgnoreCase("CHROME")) {
//		
//		 driver=new ChromeDriver();
//		 wu.getImplicitWait(driver);
//		 wu.getMaximize(driver);
////		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
////		 driver.manage().window().maximize();
//	}
//	else if(BROWSER.equalsIgnoreCase("edge")){
//		WebDriverManager.edgedriver().setup();
//		 driver=new EdgeDriver();
////		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
////		 driver.manage().window().maximize();	
//		 wu.getImplicitWait(driver);
//		 wu.getMaximize(driver);
//		
//	}else {
//		WebDriverManager.firefoxdriver().setup();
//		 driver=new FirefoxDriver();
////		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
////		 driver.manage().window().maximize();
//		 wu.getImplicitWait(driver);
//		 wu.getMaximize(driver);
//	}
//	driver.get(URL);
	
	int rannum = ju.getRandomNum();
	
//	FileInputStream fis1=new FileInputStream("src/test/resources/exceldata.xlsx");
//	Workbook book=WorkbookFactory.create(fis1);
//	Sheet sheet = book.getSheet("Product");
//	Row row = sheet.getRow(0);
//	Cell cell = row.getCell(0);
//	String productData = cell.getStringCellValue()+rannum;
	String productData = eu.getExcelData("product", 0, 0)+rannum;
	System.out.println(productData);
	
	//driver.get(URL);
//	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
//	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
//	driver.findElement(By.id("submitButton")).click();
//	LoginPage lp=new LoginPage(driver);
//	lp.LoginToApp(USERNAME, PASSWORD);
	
	//driver.findElement(By.xpath("//a[.='Products']")).click();
	HomePage hp=new HomePage(driver);
	hp.productText(driver);
	
//	driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	CreateProductPom cp=new CreateProductPom(driver);
	cp.createProductText(driver);
	//driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(productData);
	cp.inputSend(driver, productData);
	//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	cp.saveProduct(driver);
	Thread.sleep(2000);
	//String actualData = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
	
	
	
//	FileInputStream fis2=new FileInputStream("src/test/resources/exceldata.xlsx");
//	Workbook book2=WorkbookFactory.create(fis2);
//	
//	Sheet sheet2 = book.getSheet("Campaigns");
//	Row row2 = sheet2.getRow(0);
//	Cell cell2 = row2.getCell(0);
//	String campdata = cell2.getStringCellValue()+rannum;
	String campdata = eu.getExcelData("Campaigns", 0, 0)+rannum;
	System.out.println(campdata);
	//driver.findElement(By.xpath("//a[.='More']")).click();
	hp.moreLink(driver);
//	Actions act=new Actions(driver);
//	act.moveToElement(driver.findElement(By.id("more"))).perform();

	//driver.findElement(By.xpath("//a[.='Campaigns']")).click();
	hp.CampaignText(driver);
	
	//driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
	CreateNewCampaign cc=new CreateNewCampaign(driver);
	cc.createCampaign(driver);
	
	//driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(campdata);
	cc.sendkeyTextfield(driver, campdata);
	
	System.out.println(campdata);
	
	driver.findElement(By.xpath("//img[@alt='Select']")).click();
	wu.swtichWindow(driver, "Products&action");
//	Set<String> allId = driver.getWindowHandles();
//	Iterator<String> it = allId.iterator();
//	while(it.hasNext()) {
//		String id = it.next();
//		driver.switchTo().window(id);
//		String title = driver.getTitle();
//		
//		if(title.contains("Products&action"))
//			break;
//		
//	}
	
driver.findElement(By.id("search_txt")).sendKeys(productData);
driver.findElement(By.xpath("//input[@name='search']")).click();
//dynamic x path
driver.findElement(By.xpath("//a[.='"+productData+"']")).click();

//Set<String> allId1 = driver.getWindowHandles();
//Iterator<String> it1 = allId1.iterator();
//while(it1.hasNext()) {
//	String id1 = it1.next();
//	driver.switchTo().window(id1);
//	String title = driver.getTitle();
//	
//	if(title.contains("Campaigns&action"))
//		break;
//	
//}
wu.swtichWindow(driver, "Campaigns&action");

driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
String act1 = driver.findElement(By.id("dtlview_Campaign Name")).getText();
if(act1.contains(campdata)) {
	System.out.println("camp data pass");
}else {
	System.out.println("camp fail");
}

String actpro = driver.findElement(By.id("dtlview_Product")).getText();
if(actpro.contains(productData)) {
	System.out.println("product pass"); 
}else {
	System.out.println("fail");
}
Thread.sleep(5000);

//act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
//wu.movetoelement(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
//driver.findElement(By.xpath("//a[.='Sign Out']")).click();
//hp.signoutclick(driver);
}
}
