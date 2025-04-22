package generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom.HomePage;
import pom.LoginPage;


public class BaseClass  {
	public WebDriver driver;
	public static WebDriver Sdriver;//this is used for changing web driver when testscript get fail and invoke LISTNER method from genric utility
	//@BeforeSuite(groups = {"smokeTest","sanityTest"})
	@BeforeSuite
	public void BS() {
		System.out.println("database connection started");
	}
//@BeforeTest(groups = {"smokeTest","sanityTest"})
	@BeforeTest
	public void BT() {
		System.out.println("parallel execution started");
	}
	//@BeforeClass(groups = {"smokeTest","sanityTest"})
	//@Parameters("BROWSER")
	
	@BeforeClass
	public void BC() throws Throwable {
		System.out.println("launching browser");
		FileInputStream fis=new FileInputStream("src/test/resources/Propertyfile.properties");
		Properties pro=new Properties();
		pro.load(fis);
		
		String BROWSER = pro.getProperty("browser");
		String URL = pro.getProperty("url");
		Webdriver_Utility wu=new Webdriver_Utility();
		
		if(BROWSER.equalsIgnoreCase("CHROME")) {
			//WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			 wu.getImplicitWait(driver);
			 driver.manage().window().maximize();
		}
		else if(BROWSER.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
			 wu.getImplicitWait(driver);
			 driver.manage().window().maximize();	
			
		}else {
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
			 wu.getImplicitWait(driver);
			 driver.manage().window().maximize();
		}
		Sdriver=driver;
	}
	
	//@BeforeMethod(groups = {"smokeTest","sanityTest"})
	@BeforeMethod
	public void BM() throws Throwable {
		System.out.println("Login to app");
		FileInputStream fis=new FileInputStream("src/test/resources/Propertyfile.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		driver.get(URL);
		LoginPage loginPage=new LoginPage(driver);
		loginPage.LoginToApp(USERNAME, PASSWORD);
	}
	
	//@AfterMethod(groups = {"smokeTest","sanityTest"})
	@AfterMethod
	public void AM() {
		System.out.println("Logout to app");
		HomePage homepage=new HomePage(driver);
		homepage.signoutclick(driver);
	}
//	@AfterClass(groups = {"smokeTest","sanityTest"})
	@AfterClass
	public void AC() {
		System.out.println("closing browser");
	}
	//@AfterTest(groups = {"smokeTest","sanityTest"})
	@AfterTest
	public void AT() {
		System.out.println("parallel execution stopped");
	}
	//@AfterSuite(groups = {"smokeTest","sanityTest"})
	@AfterSuite
	public void AS() {
		System.out.println("database connected closed");
	}
}
