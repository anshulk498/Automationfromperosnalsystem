package generic_utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Webdriver_Utility {
	/**
	 * this method is used to implict wait
	 * @param driver
	 * @param driver
	 */
		public void getImplicitWait(WebDriver driver) {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
		
		/**
		 * this method is used to maximizewindow
		 * @param driver
		 * @param maximize window
		 */
	public void getMaximize(WebDriver driver) {			
			driver.manage().window().maximize();
		}


	/**
	 * this method is used to getwindows
	 * @param driver
	 * @param PartialWindow
	 */

	   public void swtichWindow(WebDriver driver,String PartialWindow) {
		   Set<String> window = driver.getWindowHandles();
	       Iterator<String> allId = window.iterator();

	   
	       while(allId.hasNext()) {
	       	
	       	String windows = allId.next();
	       	driver.switchTo().window(windows);
	       	String title = driver.getTitle();
	       	
	       	if(title.contains(PartialWindow)) {
	       		break;
	       		
	       		
	       		
	       	}
	       }
	   }
	   /**
		 * this method is used to movetoelement
		 * @param driver
		 * @param actions
		 */
	   
	       public void movetoelement(WebDriver driver,WebElement target) {
	       Actions act=new Actions(driver);
	       act.moveToElement(target).perform();
	   }
	       
	       /**
			 * this method is used to rightclick pop-up
			 * @param driver
			 * @param actions
			 */ 
	       
	       public void contextclick(WebDriver driver,WebElement target) {
	    	   Actions act=new Actions(driver);
	    	   act.contextClick(target);
	       }
	       
	       /**
			 * this method is used to drag&drop element
			 * @param driver
			 * @param actions
			 */ 
	       
	       public void dragdropelement(WebDriver driver,WebElement src,WebElement target) {
	    	   Actions act=new Actions(driver);
	    	   act.dragAndDrop(src, target).perform();
	    	   
	    	   
	       }
	       /**
			 * this method is used to doubleclick pop-up
			 * @param driver
			 * @param actions
			 */
	       public void doubleclick(WebDriver driver,WebElement target) {
	    	   Actions act=new Actions(driver);
	    	   act.doubleClick(target);
	       }
	       /**
			 * this method is used to acceptconfirmation pop-up
			 * @param driver
			 * @param alert
			 */ 
         public void AcceptAlert(WebDriver driver) {
        	  driver.switchTo().alert().accept();
        	 
         }
         /**
			 * this method is used to dismissconfirmation pop-up
			 * @param driver
			 * @param alert
			 */ 
      public void dismissalert(WebDriver driver) {
     	  driver.switchTo().alert().dismiss();
     	  
     	 
      }
      /**
		 * this method is used to sendkeys in textfield
		 * @param driver
		 * @param alert
		 */ 
       public void sendkeys(WebElement target,String text) {
      target.click();
      target.clear();
      target.sendKeys(text);
       }

       /**
		 * this method is used to dropdown
		 * @param driver
		 * @param select
		 */ 
       public void selectbyvisibletext(WebDriver driver,WebElement element,String text) {
        Select sel=new Select(element);
        sel.selectByVisibleText(text);
       }
}
