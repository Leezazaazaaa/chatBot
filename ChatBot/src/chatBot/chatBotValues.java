package chatBot;

import java.io.IOException;

public class chatBotValues {	//stores values from GUI
	
	private String userInput;	//user input
	private String botOutput;	//chatbot output
	private String location = "Dublin,IE";	//location	
	private boolean insertingLocation = false;
	private int counter;

	public chatBotValues() {
		super();
		this.userInput = userInput;
		this.botOutput = botOutput;
		this.location = location;
		counter = 0;
	}
	

	public void increment ( ) {
		counter++;
	}
	
	public void reset ( ) {
		counter = 0;
	}
	
	public int value ( ) {
		return counter;
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
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public boolean getInsertingLocation() {
		return insertingLocation;
	}

	public void setInsertingLocation(boolean insertingLocation) {
		this.insertingLocation = insertingLocation;
	}

	public void runStartMethod() throws IOException{	//runs method for gathering correct response
		WeatherData d = new WeatherData(getLocation());
		
		ChatBot chat = new ChatBot(getLocation());
		
		chat.startChatBot(d);
	}
		
	
}
