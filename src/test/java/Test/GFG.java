package Test;

import java.util.ArrayList;
import java.util.List;

class GFG {

	// Driver code
		public static void main(String[] args) {
			

			List<Integer> boxesInPiles = new ArrayList<Integer>(); 
			boxesInPiles.add(5); 
			boxesInPiles.add(4); 
			boxesInPiles.add(4);
			boxesInPiles.add(3); 
			boxesInPiles.add(2); 
			
		
			
			/*System.out.println();
			hello();
			*/
			System.out.println(pilesOfBoxes(boxesInPiles));
		}
		
	/*	public static void hello(){
			System.out.println("hello");
		}*/
	// Function to find the number of
	// boxes to be removed
		public static long pilesOfBoxes(List<Integer> boxesInPiles){
			int count = 0;
	        int n = boxesInPiles.size();
	        // Store height of previous pile
	        int prev = boxesInPiles.get(0);

	        // Start traversing the array
	        for (int i = 1; i < n; i++) {
	            // if height of current pile is greater
	            // than previous pile
	            if (boxesInPiles.get(i) > prev) {
	                // Increment count by difference
	                // of two heights
	                count += (boxesInPiles.get(i) - prev);

	                // Update current height
	                boxesInPiles.add(i, prev);
	              //  System.out.println("value of arr[i] : "+boxesInPiles.get(i));
	                // Update prev for next iteration
	                prev = boxesInPiles.get(i);
	                
	              //  System.out.println("value of prev : "+prev);
	            } else {
	                // Update prev for next iteration
	                prev = boxesInPiles.get(i);
	            }
	        }
	        
	        return count;
	    }

	
}