package vtiger;

import org.testng.annotations.Test;

public class SoftAssert {
	@Test
    public void m1() {
    	System.out.println("step 1");
    	System.out.println("step 2");
    	System.out.println("step 3");
    	org.testng.asserts.SoftAssert sa=new org.testng.asserts.SoftAssert();
    	sa.assertEquals(false, true);
    	System.out.println("step 4");
    	System.out.println("step 5");
    	sa.assertAll();
    }
@Test
	public void m2() {
		String actData="anshul";
		String expData="Anshul";
		org.testng.asserts.SoftAssert sa=new org.testng.asserts.SoftAssert();
		sa.assertEquals(actData, expData);
	}
	
}
