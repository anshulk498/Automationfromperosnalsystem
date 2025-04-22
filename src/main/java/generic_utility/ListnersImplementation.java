package generic_utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class ListnersImplementation implements ITestListener {

	public void onTestFailure(ITestResult result) {

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
	
	

}
