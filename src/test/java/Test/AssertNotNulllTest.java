package Test;

import org.testng.Assert;

public class AssertNotNulllTest {

	public static void main(String[] args) {
		/*AssertNotNull() is a method that verifies whether the object is null or not.
		If an object is not null, then assertion passes the test case and test case is marked as "passed", and
		if an object is null,
		then assertion aborts the test case and test case is marked as "failed".*/
		
		Assert.assertNotNull(10);  
		System.out.println("C Language");  

		
		Assert.assertNotNull(null);  
        System.out.println("C Language");  
	}

}
