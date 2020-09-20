package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class TestPalimdrome {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter String : ");
		String string = br.readLine();
		findPalimdrome(string);
	}

	public static void findPalimdrome(String str) {

		System.out.println(str);
		// Find is there space in sentence/string
		StringTokenizer stringToken = new StringTokenizer(str, ".?! ");
		int wordCount = stringToken.countTokens();
		String word[] = new String[wordCount];

		if (wordCount > 1) {
			System.out.println("greater than 1");
			// Remove space and create single word
			String noSpaceStr = str.replaceAll("\\s", "");
			String lowercaseStr = noSpaceStr.toLowerCase();
			Palimdrome(lowercaseStr);

		} else {
			System.out.println("No any space..Its single word");
			String lowercaseStr = str.toLowerCase();
			getOccuringChar(lowercaseStr);
		}

	}

	static void getOccuringChar(String str) {
		// Create an array of size 256 i.e. ASCII_SIZE
		int count[] = new int[256];

		int len = str.length();

		String substr[] = new String[len];
		int getStartIndex = 0, getLastIndex = 0;

		// Initialize count array index
		for (int i = 0; i < len; i++) {
			count[str.charAt(i)]++;
		}
		// Create an array of given String size
		char ch[] = new char[str.length()];
		for (int i = 0; i < len; i++) {
			ch[i] = str.charAt(i);

			int find = 0;
			for (int j = 0; j <= i; j++) {

				// If any matches found
				if (str.charAt(i) == ch[j]) {
					find++;
					//System.out.println("Letter : " + str.charAt(i));
					getStartIndex = str.indexOf(str.charAt(i));
					getLastIndex = str.lastIndexOf(str.charAt(i));
					//System.out.println(getStartIndex + "|||" + getLastIndex);

					if (getStartIndex != getLastIndex) {
						
						substr[i] = str.substring(getStartIndex, getLastIndex+1);
					}
				}
			}

		/*	if (find == 1)
				System.out.println("Number of Occurrence of " + str.charAt(i) + " is:     " + count[str.charAt(i)]);
*/
		}

		Set<String> temp = new LinkedHashSet<String>( Arrays.asList( substr ) );
		
		String[] result = temp.toArray( new String[temp.size()] );
		
		for(int i1=0;i1<result.length;i1++)
        {
			System.out.println(result[i1]);
			if(result[i1]!=null){
				
				Palimdrome(result[i1]);
			}
        }		
		
	}

	public static void Palimdrome(String str) {
		String reverseString = "";
		int length = str.length();
		for (int i = length - 1; i >= 0; i--) {
			reverseString = reverseString + str.charAt(i);
		}
		if (reverseString.equals(str)) {
			System.out.println("Output: " + reverseString);
		} else {
			System.out.println("No Palimdrome");
		}
	}

}
