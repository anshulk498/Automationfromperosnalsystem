package pratice;

import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class sampleTestNG {
	@Test(invocationCount  = 3)
	public void createContact() {
		System.out.println("create contact");
	}
	@Test(priority =2)
	public void modify() {
		System.out.println("modify contatct");
	}
	@Test(priority =1)
	public void deleteConatct() {
		System.out.println("delete contect");
	}
}
