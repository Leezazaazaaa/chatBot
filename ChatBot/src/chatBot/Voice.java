package chatBot;
import java.io.IOException;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

public class Voice {
	 public static void main(String[] args) throws IOException {
		 Configuration configuration = new Configuration();
		 
		 configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us"); //reference the data jar file
		 configuration.setDictionaryPath("/Users/leeza/git/chatbot2.0/ChatBot/src/VoiceCommands/4537.dic"); //path for dictionary
		 configuration.setLanguageModelPath("/Users/leeza/git/chatbot2.0/ChatBot/src/VoiceCommands/4537.lm"); //path for pronounciation 
		 
		 LiveSpeechRecognizer recognize = new LiveSpeechRecognizer(configuration); //recognizes the voice imported from library
		  
		 recognize.startRecognition(true);
		 
		 SpeechResult speechResult;
		 
		 while((speechResult = recognize.getResult()) != null){ //loops when the voice is recognized
			 String command = speechResult.getHypothesis();
			 System.out.println("Input Command is: " + command);
		 
			 if(command.equalsIgnoreCase("Hi") && command.contains("Hi")){ //voice command is Hi
				 TextSound tts = new TextSound("kevin16");
				 String message = "Hello";
				 tts.speak(message);
				 
			 }else if(command.equalsIgnoreCase("Weather") || command.contains("Weather")) { //when the voice command is weather it will forecast thee weather
				 WeatherData d = new WeatherData("Brisbane,AU");//step1: Create a WeatherData object by sending a location
					Weather info = new Weather(d);//Step 2: create a Weather Object from the WeatherData Object
					// you now have access to all the info you want.
					System.out.println("\ncurrent temp: "+info.getActualTemp()+"C"); //prints out the weather condition 
					System.out.println("\nWeather Conditions: "+info.getDescription());
					TextSound tts = new TextSound("kevin16");
					String message = "Current Temperature is " + info.getActualTemp() + "degree celcius and the weather condition is " + info.getDescription(); //weather information
					tts.speak(message);
					
			 }else if(command.equalsIgnoreCase("How are you ")) { //voice command is how are you
				 TextSound tts = new TextSound("kevin16");
				 String message = "I am good, thank you";
				 tts.speak(message);
			 }
		 }
	 }
}
