package vtiger;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1 {
	@Test(dataProvider ="dataProviderExcute" )
	public void bookTicket(String src,String dest) {
		System.out.println("book ticket from"+src+"to"+dest);
		
	}
@DataProvider
	public Object[][] dataProviderExcute(){
		Object[][] obj=new Object[2][2];
		
		obj[0][0]="banglore";
		obj[0][1]="goa";
		
		obj[1][0]="banglore";
		obj[1][1]="mysore";
		return obj;
		
		
		
	}
}
