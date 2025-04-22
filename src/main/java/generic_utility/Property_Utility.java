package generic_utility;

import java.io.FileInputStream;
import java.util.Properties;

public class Property_Utility {
	public String getKeyValue(String key) throws Throwable {
		FileInputStream fis=new FileInputStream("./src/test/resources/Propertyfile.properties");
		Properties pro=new Properties();
		pro.load(fis); 
		String value = pro.getProperty(getKeyValue(key));
		 return value;
		}

}
