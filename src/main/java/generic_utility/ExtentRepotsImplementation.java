package generic_utility;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentRepotsImplementation implements ITestListener{
	
		WebDriver driver;
		ExtentReports report;
		ExtentTest test;
	

	public void onTestStart(ITestResult result) {
		//step 3:create test method during the test exceuation start
		report.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		//step:4 log the test 
		test.log(Status.PASS, result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
	//step 5
		String testData = result.getMethod().getMethodName();
		//EventFiringDecorator edriver = new EventFiringDecorator();
		TakesScreenshot ts=(TakesScreenshot)BaseClass.Sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		System.out.println(src);
		LocalDateTime localdatetime = LocalDateTime.now();//this is for taking multiple ss
		localdatetime.toString().replace(" ", "-").replace(":","/");
		File dest = new File("./ScreenShot12/"+testData+".png");
		System.out.println(dest);
		try {
			FileUtils.copyFile(src,dest);
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problem is saving screenshot"+e.getMessage());
		}	
		
		
	}

	public void onTestSkipped(ITestResult result) {
		//step:4 log the skip method 
		test.log(Status.SKIP, result.getMethod().getMethodName());
	}

	public void onStart(ITestContext context) {
		//step 1:-extent report configuration
		Date d=new Date();
		System.out.println(d);
		d.toString().replace(":", "-").replace(" ", "*");
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(new File("ExtentReports.html"));
		htmlReport.config().setDocumentTitle("Vtiger extentreport");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("AUTOMATION TEST");
		
		//STEP 2:ATTACH the physical report and do the system testing configuration

		ExtentReports report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("os", "window 11");
		report.setSystemInfo("Environement", "Automation Testing");
		report.setSystemInfo("url", "http://localhost:8888");
		report.setSystemInfo("ReporterName", "Anshul");
	}

	public void onFinish(ITestContext context) {
	report.flush();
	}
	
	
}
