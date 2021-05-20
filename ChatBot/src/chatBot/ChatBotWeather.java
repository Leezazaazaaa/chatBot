package chatBot;

import java.io.IOException;

public class ChatBotWeather extends ChatBot{	
	
	private boolean pendingLocation;

	public ChatBotWeather(String location) throws IOException {
		super(location);
	}
	
	public String outputValidation(String response, String userInput) {	//Validation of data retrieved from WeatherAPI	
		String currentWeather, temp;
		if(userInput.contains("weather")) {
    		currentWeather = String.valueOf(this.getCurrent().getWeather_desc() );	//sets the data into a String //*
    		temp = response.replace("(answer)", currentWeather);	//changes (answer) to correct piece of data
    		response = temp;
		}
		else if(userInput.contains("temperature")) {
    		currentWeather = String.valueOf(this.getCurrent().getTemp_current() );	//sets the data into a String //*
    		temp = response.replace("(answer)", currentWeather);	//changes (answer) to correct piece of data
    		response = temp;
		}
		else if(userInput.contains("humidity")){
    		currentWeather = String.valueOf(this.getCurrent().getHumidity());	//sets the data into a String //*
    		temp = response.replace("(answer)", currentWeather);	//changes (answer) to correct piece of data
    		response = temp;
		}
		else if(userInput.contains("pressure")){
    		currentWeather = String.valueOf(this.getCurrent().getPressure());	//sets the data into a String //*
    		temp = response.replace("(answer)", currentWeather);	//changes (answer) to correct piece of data
    		response = temp;
		}
		if(userInput.contains("wear")) {
			response = clothingSuggestion(response);
		}
		if(userInput.contains("location")) {
			pendingLocation = true;
		}
		if(pendingLocation == true) {
			//sets current location
		}
		return response;
	}
	
	public String clothingSuggestion(String response) {		//This method suggests clothes to wear
		String cold = "bottoms and a jacket";
		String mild = "bottoms and a hoodie";
		String warm = "bottoms and a top";
		String hot = "shorts and a top";
		int currentWeather = (int) this.getCurrent().getTemp_current();//*	//suggests by checking current temperature
		String temp;
		
		if(currentWeather < 6) {			
			temp = response.replace("(answer)", cold);	
			response = temp;
		}
		else if(currentWeather < 12) {
			temp = response.replace("(answer)", mild);	
			response = temp;
		}
		else if(currentWeather < 18) {
			temp = response.replace("(answer)", warm);	
			response = temp;
		}
		else if(currentWeather >= 18) {
			temp = response.replace("(answer)", hot);	
			response = temp;
		}
		return response;
	}
	
}
