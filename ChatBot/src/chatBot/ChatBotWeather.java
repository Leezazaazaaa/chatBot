package chatBot;

public class ChatBotWeather extends ChatBot{

	public ChatBotWeather(WeatherData data) {
		super(data);
	}
	
	public String outputValidation(String response, String userInput) {	//Validation of data retrieved from WeatherAPI
		String currentWeather, temp;
		if(userInput.contains("weather")) {
    		currentWeather = String.valueOf(getDescription() );	//sets the data into a String
    		temp = response.replace("(answer)", currentWeather);	//changes (answer) to correct piece of data
    		response = temp;
		}
		else if(userInput.contains("temperature")) {
    		currentWeather = String.valueOf(getActualTemp() );	//sets the data into a String
    		temp = response.replace("(answer)", currentWeather);	//changes (answer) to correct piece of data
    		response = temp;
		}
		else if(userInput.contains("humidity")){
    		currentWeather = String.valueOf(getHumidity() );	//sets the data into a String
    		temp = response.replace("(answer)", currentWeather);	//changes (answer) to correct piece of data
    		response = temp;
		}
		else if(userInput.contains("pressure")){
    		currentWeather = String.valueOf(getPressure() );	//sets the data into a String
    		temp = response.replace("(answer)", currentWeather);	//changes (answer) to correct piece of data
    		response = temp;
		}
		if(userInput.contains("wear")) {
			response = clothingSuggestion(response);
		}
		return response;
	}
	
	public String clothingSuggestion(String response) {
		String cold = "bottoms and a jacket";
		String mild = "bottoms and a hoodie";
		String warm = "bottoms and a top";
		String hot = "shorts and a top";
		int currentWeather = (int) getActualTemp();
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
