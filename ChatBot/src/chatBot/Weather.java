package chatBot;

import org.json.*;

/*
 * This Class stores all essential information we want to be used by the bot. Info extracted from WeatherData
 * Immutable class!
 */

public class Weather {
	
	/*========================Attributes========================*/
	
	private double actualTemp;
	private double minTemp;
	private double maxTemp;
	private int humidity;
	private int pressure;
	private double feelsLike;
	private String description; //extra piece of data, describes day. e.g cloudy, sunny, raining, etc
	
	
	/*========================Constructors========================*/
	
	public Weather(JSONObject main, JSONObject conditions){
		
		description = conditions.getString("description");//gets only the description of weather conditions from JSONObject conditions
		actualTemp= main.getDouble("temp");
		minTemp = main.getDouble("temp_min");
		maxTemp = main.getDouble("temp_max");
		humidity = main.getInt("humidity");
		pressure = main.getInt("pressure");
		feelsLike = main.getDouble("feels_like");
		
	}

	
	/*========================Getters========================*/
	
	public double getActualTemp() {
		return actualTemp;
	}

	public double getMinTemp() {
		return minTemp;
	}

	public double getMaxTemp() {
		return maxTemp;
	}

	public int getHumidity() {
		return humidity;
	}

	public int getPressure() {
		return pressure;
	}

	public double getFeelsLike() {
		return feelsLike;
	}
	public String getDescription() {
		return description;
	}


}
