package chatBot;
import java.io.IOException;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

public class Voice {
	 public static void main(String[] args) throws IOException {
		 Configuration configuration = new Configuration();
		 
		 configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		 configuration.setDictionaryPath("/Users/leeza/git/chatbot2.0/ChatBot/src/VoiceCommands/4537.dic");
		 configuration.setLanguageModelPath("/Users/leeza/git/chatbot2.0/ChatBot/src/VoiceCommands/4537.lm");
		 
		 LiveSpeechRecognizer recognize = new LiveSpeechRecognizer(configuration);
		 
		 recognize.startRecognition(true);
		 
		 SpeechResult speechResult;
		 
		 while((speechResult = recognize.getResult()) != null){
			 String command = speechResult.getHypothesis();
			 String work = null;
			 System.out.println("Input Command is: " + command);
		 
			 if(command.equalsIgnoreCase("Open Safari")){
				 work = "open -a Safari http://www.apple.com";
				 
			 }else if(command.equalsIgnoreCase("Close Safari")) {
				 work = "killall Safari";
			 }
			 
			 if(work != null) {
				Runtime.getRuntime().exec(work);
			 }
		 }
	 }
}
