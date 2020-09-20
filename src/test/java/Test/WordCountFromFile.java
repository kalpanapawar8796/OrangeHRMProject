package Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

class WordCountFromFile{

     public static void main(String args[]) throws IOException{

        File file = new File("C:\\input.txt"); 
       
        FileInputStream fileStream = new FileInputStream(file); 
       
        InputStreamReader input = new InputStreamReader(fileStream); 
       
        BufferedReader reader = new BufferedReader(input); 
    
        int countWord = 0; 
    
        String line;

        while((line = reader.readLine()) != null) 
        { 

          String[] wordList = line.split("\\s+"); 
          
          countWord += wordList.length;

          wordList = line.split("[0-9]+");
         
          countWord += wordList.length; 
        }

      System.out.println(countWord);
     }

}
