package Test;

import org.testng.Assert;

public class AssertNullTest {

	public static void main(String[] args) {
		/*AssertNull() is a method that verifies whether the object is null or not. 
		If an object is null, then assertion passes the test case, and the test case is marked as "passed", and
		if an object is not null, 
		then assertion aborts the test case and the test case is marked as "failed". */

		Assert.assertNull(null);  
		System.out.println("Hello...This is javaTpoint");  
		
		
		Assert.assertNull(10);  
	    System.out.println("Hello World");  
	}

}
