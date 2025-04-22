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
import org.openqa.selenium.Alert;
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
import pom.CreateProductPom;
import pom.DeleteProductPom;
import pom.HomePage;
import pom.LoginPage;

public class DeleteProductTest extends BaseClass {
	@Test
	public void deleteProduct() throws Throwable {
//		FileInputStream fis=new FileInputStream("src/test/resources/Propertyfile.properties");
//		Properties pro=new Properties();
//		pro.load(fis);
//		WebDriver driver=null;
//		String BROWSER = pro.getProperty("browser");
//		String URL = pro.getProperty("url");
//		String USERNAME = pro.getProperty("username");
//		String PASSWORD = pro.getProperty("password");
		
		Webdriver_Utility wu=new Webdriver_Utility();
		Java_Utility ju=new Java_Utility();
		Excel_Utility eu=new Excel_Utility();
		Property_Utility pu=new Property_Utility();
		
//		if(BROWSER.equalsIgnoreCase("CHROME")) {
//			//WebDriverManager.chromedriver().setup();
//			 driver=new ChromeDriver();
//			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//			 driver.manage().window().maximize();
//		}
//		else if(BROWSER.equalsIgnoreCase("edge")){
//			WebDriverManager.edgedriver().setup();
//			 driver=new EdgeDriver();
//			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//			 driver.manage().window().maximize();	
//			
//		}else {
//			WebDriverManager.firefoxdriver().setup();
//			 driver=new FirefoxDriver();
//			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//			 driver.manage().window().maximize();
//		}
////		Random ran=new Random();
//		int rannum = ran.nextInt(1000);
		int rannum = ju.getRandomNum();
//		FileInputStream fis1=new FileInputStream("src/test/resources/exceldata.xlsx");
//		Workbook book=WorkbookFactory.create(fis1);
//		Sheet sheet = book.getSheet("Product");
//		Row row = sheet.getRow(0);
//		Cell cell = row.getCell(0);
//		String data = cell.getStringCellValue();
		String data = eu.getExcelData("Product", 0, 0)+rannum;
	//	driver.get(URL);
//		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
//		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
//		LoginPage lp=new LoginPage(driver);
//		lp.LoginToApp(USERNAME, PASSWORD);
		//driver.findElement(By.xpath("//a[.='Products']")).click();
		HomePage hp=new HomePage(driver);
		hp.productText(driver);
		//driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		CreateProductPom cp=new CreateProductPom(driver);
		cp.createProductText(driver);
		//driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(data);
		cp.inputSend(driver, data);
		
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		cp.saveProduct(driver);
		Thread.sleep(2000);
		String actualData = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		
		if(data.contains(actualData)) {
			System.out.println("pass");
		}
		//driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
		DeleteProductPom dp=new DeleteProductPom(driver);
		dp.deleteProduct(driver);
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
//		wu.AcceptAlert(driver);
//		Thread.sleep(5000);
//		Actions act=new Actions(driver);
//		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
//		wu.movetoelement(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
//		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	//	hp.signoutclick(driver);
	}

}
