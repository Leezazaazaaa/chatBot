package weatherBot;

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
	
	public Weather(WeatherData data){
		
		description = data.getDescription().getString("description");//gets only the description of weather conditions from JSONObject conditions
		actualTemp= data.getMain().getDouble("temp");
		minTemp = data.getMain().getDouble("temp_min");
		maxTemp = data.getMain().getDouble("temp_max");
		humidity = data.getMain().getInt("humidity");
		pressure = data.getMain().getInt("pressure");
		feelsLike = data.getMain().getDouble("feels_like");
		
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
