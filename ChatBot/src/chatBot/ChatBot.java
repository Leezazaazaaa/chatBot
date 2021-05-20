package chatBot;

import java.io.*;
import java.util.*;

public class ChatBot extends WeatherData{	
	
	Controller con = new Controller(); 
	WeatherData data; 
	static chatBotValues cb = new chatBotValues();
	
	public ChatBot(String location) throws IOException {
		super(location);		
	}
	
	
	public WeatherData getData(WeatherData data) {
		return data;
	}
	
	
	//unecessary method (used for testing)
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
	
	//unecessary method (used for testing)
    public void displayMenu(boolean startup) {		//displays greeting
        if(startup) {											
//            System.out.println("Please enter a command.");		
        }
//        System.out.print("> ");									
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
    
    
    //unecessary method (used for testing)
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
        String tag = null, response;
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
    
    
    public void startChatBot(WeatherData data) throws IOException {		//Start chatBot
        String userInput, response;
        
        String filename = "responses.txt";   
        ChatBotWeather validation = new ChatBotWeather(data.getLocation());
        
        int lines = getLines(filename);
        String[] responsesArray = getResponsesArray(filename, lines);
        displayMenu(true);					//displays greeting
        
            userInput = cb.getUserInput();		//sets user's input as userInput                   
            	           
            response = getResponse(responsesArray, userInput);	//retrieves correct response to user's input
            
            response = validation.outputValidation(response, userInput);
            
//            System.out.println("Chatbot: " + response);	//outputs the full response
            
            cb.setBotOutput(response);                   

            if(!userInput.equals("bye")) {
                displayMenu(false);			//display will turn off when "bye" is said
            }   
    }
    

    public static String chatGUI(String input) {   //This method links the chatbot's inputs and outputs with the GUI's inputs and outputs
    	 
    	
    	
    	cb.setUserInput(input);		//sets input taken from GUI into chatbot
  	
    	String output = cb.getBotOutput();  	
    	
    	if(cb.getUserInput().contains("location") || cb.getInsertingLocation() == false) {	//checks whether the user is changing locations
    		if(cb.getUserInput().contains("location")) {
    		cb.setInsertingLocation(true);
    		}
    	System.out.println(cb.getInsertingLocation());
    	try {
			cb.runStartMethod();		//runs whole chatbot and gets correct output processed
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	}
    	else {											//if the user is changing locations
    		System.out.println(cb.getInsertingLocation());
    		cb.setInsertingLocation(false);
    		System.out.println(cb.getInsertingLocation());
    		cb.setBotOutput("Lovely Place");
    		cb.setLocation(input);		//location set as user's input
    		
    	}
    	System.out.println("User Input: " + cb.getUserInput());
    	System.out.println("Chatbot's Response: " + cb.getBotOutput());
    	System.out.println("Current Selected Location: " + cb.getLocation());
    	output = cb.getBotOutput();		//gets output after it has been validated
    	return output;   	
    }
     
	
}
