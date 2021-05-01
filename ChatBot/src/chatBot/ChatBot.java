package chatBot;

import java.io.*;
import java.util.*;



public class ChatBot  extends Weather{	

	public ChatBot(WeatherData data) {
		super(data);
		
	}
	
	public String[] Responses() {	//temporary method for how the user's input and ChatBot's responses are managed
		String[] responses = {"hello - Hi there! How are you?", //String array holds all inputs and outputs, separated by a semi-colon
						 	  "good - That's good to hear!",		
						 	  "what is your name? - My name is ChatBot",
						 	  "help - Enter input into the console and receive a response.",
						 	  "bye - Goodbye!",
						 	  "what is the weather? - it is (answer)",
						 	  "what should i wear? - You Should Wear (answer)"};
		return responses;	//returns the full String array
	}
	
    public static void displayMenu(boolean startup) {		//displays greeting
        if(startup) {											
            System.out.println("Please enter a command.");		
        }
        System.out.print("> ");									
    }
    
    public static int getLines(String filename) {		//gets the total amount of lines in filename		
        int lines = 0;
        
        try(BufferedReader br = new BufferedReader(			
                new FileReader(filename))) {
            while(br.readLine() != null) lines++;	//lines increases as it recognizes each line in text file
        } catch(IOException exc) {
            System.out.println("I/O Exception: " + exc);
        }
        
        return lines;
    }
    
    public static String getUserInput() {	//gets the user's input
        String userInput = null;
        
        try {
            BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
            
            userInput = br.readLine();						//the user input is stored inside of userInput
        } catch(IOException exc) {
            System.out.println("I/O Exception: " + exc);
        }
        
        return userInput;		//returns user's input
    }
    
    public static String[] getResponsesArray(String filename, int lines) {	//retrieves all responses from text file
        int lineCount = 0;
        
        String line;
        String[] responsesArray = new String[lines];	//new String array created with size of lines(amount of lines in text file)
        
        try(BufferedReader br = new BufferedReader(
                new FileReader(filename))) {
            
            do {
                line = br.readLine();	//stores each line into String line
                
                if(line != null) {		//checks if that line is not empty
                    responsesArray[lineCount] = line;	//adds that line into array
                    lineCount++;				
                }
            } while(line != null);
        } catch(FileNotFoundException exc) {
            System.out.println("FileNotFoundException: " + exc);
        } catch(IOException exc) {
            System.out.println("I/O Exception: " + exc);
        }
        
        return responsesArray;	//returns new array with all responses
    }
    
    public static String getResponse(String[] responses, String userInput) {	//Gets chatbot's responses given the user-defined input command
        String tag, response;
        String[] array;
        
        for(String responseLine: responses) {
            if(responseLine != null) {	
                array = responseLine.split(" - ");		//User's input and chatBot's output is separated by semi-colon
                tag = array[0];									
                response = array[1];					
                
                if(tag.compareToIgnoreCase(userInput) == 0) {	//finds valid response
                    return response;							//returns response		
                }
            }
        }
        
        return "No response...";							//else returns No Response...		
    }
    
    public void startChatBot() {		//Start chatBot
        String userInput, response, temp, currentWeather;
        String filename = "responses.txt";     
        
        int lines = getLines(filename);
        String[] responsesArray = getResponsesArray(filename, lines);
        displayMenu(true);					//displays greeting
        
        do {
            userInput = getUserInput();		//sets user's input as userInput
            
            response = getResponse(responsesArray, userInput);	//retrieves correct response to user's input
            
            if(userInput.contains("weather")) {			//checks if user is asking for weather
            	if(getActualTemp() >= 15) {				//checks the temperature(not necessary, but will be useful later)
            		currentWeather = String.valueOf(getActualTemp());	//sets the data into a String
            		temp = response.replace("(answer)", currentWeather);	//changes (answer) to correct piece of data
            		response = temp;	
            	}
            }
            
            System.out.println("Chatbot: " + response);	//outputs the full response

            if(!userInput.equals("bye")) {
                displayMenu(false);			//display will turn off when "bye" is said
            }
        } while(!userInput.equals("bye"));	//loop will only run until the user says "bye"
    }
    
    
    
    
    
	
}
