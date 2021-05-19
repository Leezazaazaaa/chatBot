package chatBot;
import java.io.IOException;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

public class Voice {
	 public static void main(String[] args) throws IOException {
		 Configuration configuration = new Configuration();
		 
		 configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us"); //reference the data jar filebrary
		 configuration.setDictionaryPath("/Users/leeza/git/chatbot2.0/ChatBot/src/VoiceCommands/4537.dic");
		 configuration.setLanguageModelPath("/Users/leeza/git/chatbot2.0/ChatBot/src/VoiceCommands/4537.lm");
		 
		 LiveSpeechRecognizer recognize = new LiveSpeechRecognizer(configuration);
		 
		 recognize.startRecognition(true);
		 
		 SpeechResult speechResult;
		 
		 while((speechResult = recognize.getResult()) != null){
			 String command = speechResult.getHypothesis();
			 String work = null;
			 System.out.println("Input Command is: " + command);
		 
			 if(command.equalsIgnoreCase("Hi")){
				 work = "open -a Safari http://www.apple.com";
				 
			 }else if(command.equalsIgnoreCase("Weather")) {
				 WeatherData d = new WeatherData("Brisbane,AU");//step1: Create a WeatherData object by sending a location
					
				//	d.display();//You can display its contents like so
					
					Weather info = new Weather(d);//Step 2: create a Weather Object from the WeatherData Object
					
					// you now have access to all the info you want.
					System.out.println("\ncurrent temp: "+info.getActualTemp()+"C");
					System.out.println("\nWeather Conditions: "+info.getDescription());
						
			 }else if(command.equalsIgnoreCase("How are you ")) {
				 
			 }
			 
			 if(work != null) {
				Runtime.getRuntime().exec(work);
			 }
		 }
	 }
}
