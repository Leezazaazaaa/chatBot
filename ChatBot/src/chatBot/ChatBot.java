package chatBot;

import java.io.*;
import java.util.*;



public class ChatBot  extends Weather{	

	public ChatBot(WeatherData data) {
		super(data);
		
	}

	public void createFile() {		
	    try {
	    	File file = new File("responses.txt");
	        if (file.createNewFile()) {
	          System.out.println("File created: " + file.getName());
	        } else {
	          System.out.println("File already exists.");
	        }
	      } catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }		
	}
	
	public String[] Responses() {
		String[] responses = {"hello - Hi there! How are you?", 
						 	  "good - That's good to hear!",
						 	  "what is your name? - My name is ChatBot",
						 	  "help - Enter input into the console and receive a response.",
						 	  "bye - Goodbye!",
						 	  "what is the weather? - it is (answer)",
						 	  "what should i wear? - You Should Wear (answer)"};
		return responses;
	}
	
	public void setResponses() {
		String[] responses = Responses();
		
		
	    try {
	        FileWriter myWriter = new FileWriter("responses.txt");
	        for(int i = 0; i < responses.length; i++) {
	        myWriter.write(responses[i] + "\n");
	        }
	        myWriter.close();
	        System.out.println("Successfully wrote to the file.");
	      } catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
		
	}
	
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
    
    public static String getResponse(String[] responses, String userInput) {
        String tag, response;
        String[] array;
        
        for(String responseLine: responses) {
            if(responseLine != null) {
                array = responseLine.split(" - ");				
                tag = array[0];									
                response = array[1];					
                
                if(tag.compareToIgnoreCase(userInput) == 0) {	
                    return response;							
                }
            }
        }
        
        return "No response...";								
    }
    
    public void startChatBot() {
        String userInput, response, temp, currentWeather;
        String filename = "responses.txt";     
        
        int lines = getLines(filename);
        String[] responsesArray = getResponsesArray(filename, lines);
        displayMenu(true);
        
        do {
            userInput = getUserInput();
            
            response = getResponse(responsesArray, userInput);
            
            if(userInput.contains("weather")) {
            	if(getActualTemp() >= 15) {
            		currentWeather = String.valueOf(getActualTemp());
            		temp = response.replace("(answer)", currentWeather);
            		response = temp;
            	}
            }
            
            System.out.println("Chatbot: " + response);

            if(!userInput.equals("bye")) {
                displayMenu(false);			//display will turn off when "bye" is said
            }
        } while(!userInput.equals("bye"));	//loop will only run until the user says "bye"
    }
    
    
    
    
    
	
}
