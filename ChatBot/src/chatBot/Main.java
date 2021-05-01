package chatBot;

import java.io.IOException;


public class Main {
	

	public static void main(String[] args) throws IOException{
		
		//Example of how to use the Weather class
		
		WeatherData d = new WeatherData("Brisbane,AU");//step1: Create a WeatherData object by sending a location
		
		d.display();//You can display its contents like so
		
		Weather info = new Weather(d);//Step 2: create a Weather Object from the WeatherData Object
		
		// you now have access to all the info you want.
		System.out.println("\ncurrent temp: "+info.getActualTemp()+"C");
		System.out.println("\nWeather Conditions: "+info.getDescription());
		
		ChatBot chat = new ChatBot(d);
		chat.setResponses();
		chat.startChatBot();
		
		/*
		 * TODO: More JUNIT testing, hard because data is always changing 
		 * 
		 * */
		
		
		
	}

}
