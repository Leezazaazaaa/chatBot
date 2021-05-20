package chatBot;

import java.io.IOException;

public class chatBotValues {
	
	private String userInput;
	private String botOutput;

	public chatBotValues() {
		super();
		this.userInput = userInput;
		this.botOutput = botOutput;
	}

	public String getUserInput() {
		return userInput;
	}

	public void setUserInput(String userInput) {
		this.userInput = userInput;
	}
	
	public String getBotOutput() {
		return botOutput;
	}

	public void setBotOutput(String botOutput) {
		this.botOutput = botOutput;
	}

	public void runStartMethod() throws IOException{
		WeatherData d = new WeatherData("Dublin,IE");
		
		ChatBot chat = new ChatBot("Dublin,IE");
		
		chat.startChatBot(d);
	}
		
	
}
