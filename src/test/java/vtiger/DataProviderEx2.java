package vtiger;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic_utility.Excel_Utility;

public class DataProviderEx2 {
	@Test(dataProvider ="getdata" )
	public void bookTicket(String src,String dest) {
		System.out.println("book ticket from"+src+"to"+dest);
		
	}
@DataProvider
	public Object[][] getdata() throws Throwable{
		Excel_Utility eu=new Excel_Utility();
		Object[][] value=eu.readMultipleData("DataProvider");
		return value;
		
		
		
	}
}
