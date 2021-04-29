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
	
}
