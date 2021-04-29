package chatBot;

import java.io.*;
import java.util.*;

public class ChatBot {

    public static void displayMenu(boolean startup) {		
        if(startup) {											
            System.out.println("Please enter a command.");		
        }
        System.out.print("> ");									
    }
    
    public static int getLines(String filename) {				
        int lines = 0;
        
        try(BufferedReader br = new BufferedReader(			
                new FileReader(filename))) {
            while(br.readLine() != null) lines++;
        } catch(IOException exc) {
            System.out.println("I/O Exception: " + exc);
        }
        
        return lines;
    }
    
    public static String getUserInput() {
        String userInput = null;
        
        try {
            BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
            
            userInput = br.readLine();						//the user input is stored inside of userInput
        } catch(IOException exc) {
            System.out.println("I/O Exception: " + exc);
        }
        
        return userInput;
    }
    
    public static String[] getResponsesArray(String filename, int lines) {
        int lineCount = 0;
        
        String line;
        String[] responsesArray = new String[lines];
        
        try(BufferedReader br = new BufferedReader(
                new FileReader(filename))) {
            
            do {
                line = br.readLine();
                
                if(line != null) {
                    responsesArray[lineCount] = line;
                    lineCount++;
                }
            } while(line != null);
        } catch(FileNotFoundException exc) {
            System.out.println("FileNotFoundException: " + exc);
        } catch(IOException exc) {
            System.out.println("I/O Exception: " + exc);
        }
        
        return responsesArray;
    }
	
}
