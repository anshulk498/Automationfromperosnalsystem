package pratice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class InsertDataToPropertyFile {
	
	public static void main(String[] args) throws Throwable {
		Properties pro=new Properties();
		pro.setProperty("browser", "chrome");
		pro.setProperty("url", "google.com");
		pro.setProperty("username", "admin");
		pro.setProperty("password", "admin");
		
		FileOutputStream fout = new FileOutputStream("./src/test/resources/commondata.properties.txt");
		pro.store(fout, "common data");
		fout.close();
	}

}
