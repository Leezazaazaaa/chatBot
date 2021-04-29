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
	
}
