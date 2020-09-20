package Test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {
/*
 find palindrome
 1. Sublevelcar output : level
 2. Never odd or even - neveroddoreven
	observation -  need to find out palin string from sentence which has space or without 
	1. monitor sentense - does it has space or not
	if has then ?
			then remove spaces . 
			convert string in to lower case
			traverse string reversally
			compare rev string with original string
			
	else what
		convert strong into lower case
		find letter occurrences into string
		if no occurrences no palindrom
		if yes convert into substring
		get 1st n last index of occ letter n create sub string
		trverse substring reversally 
		compare rev sting with sub string
	
	*/
   

	public static String findPalindrome(String Palin) {

        
        String testPalin = Palin.toLowerCase();
        String reverseString = "";
        StringTokenizer str = new StringTokenizer(testPalin,".?! ");
        int w=str.countTokens(); 
        String word[]=new String[w];
        for(int i=0;i<w;i++)
        {
            word[i]=str.nextToken();
        }
        int count=0;
        String noSpaceStr = Palin.replaceAll("\\s", ""); 
        String testPalin1 = noSpaceStr.toLowerCase();
        int length = testPalin1.length();
        System.out.print("OUTPUT : ");
           

             for(int j = length-1; j>=0; j--){
                   reverseString = reverseString + testPalin1.charAt(j);
             }
                System.out.println("Rev : "+reverseString);   
                System.out.println("word : "+ testPalin1);
            if(reverseString.equals(testPalin1)){

                
                System.out.println(reverseString); ;
            }
            else{
              System.out.println("No palimdrome found"); 
            }
        
       
        return reverseString;
    }
}



public class Palimdrome {
    public static void main(String[] args) throws IOException {
     /*   BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    */    //String Palin = bufferedReader.readLine();

        String result = Result.findPalindrome("never odd or even");

    /*    bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    */}
}
