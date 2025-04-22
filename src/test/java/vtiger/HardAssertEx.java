package vtiger;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertEx {
	@Test
	public void m1() {
		System.out.println("step 1");
		System.out.println("step 2");
		String actData="QSPIDER";
		String expData="qspider";
		Assert.assertEquals(actData, expData);
		System.out.println("step 3");
		
	}

}
