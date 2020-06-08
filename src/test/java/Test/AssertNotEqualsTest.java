package Test;

import org.testng.Assert;

public class AssertNotEqualsTest {

	public static void main(String[] args) {
		/*It is opposite to the function of AssertNotEquals() method. 
		AssertNotEquals() is a method used to compare the actual and expected results.
		If both the actual and expected results are not the same, then the assertion pass with no exception and
		the test case is marked as "passed". If both the actual and expected results are same, 
		then the assertion fails with an exception and the test case is marked as "failed". 
*/
		 	Assert.assertNotEquals("Hello", "How are you");  
	        System.out.println("Hello...This is javaTpoint");  	
	
	        Assert.assertNotEquals("Hello", "Hello");  
	        System.out.println("both the above strings are same .. it will through an exception");  
	}

}
