package chatBot;

import org.json.JSONObject;

public class Weather {
	
	private double actualTemp;
	private double minTemp;
	private double maxTemp;
	private int humidity;
	private int pressure;
	private double feelsLike;
	
	public Weather(JSONObject main){
		
		actualTemp= main.getDouble("temp");
		minTemp = main.getDouble("temp_min");
		maxTemp = main.getDouble("temp_max");
		humidity = main.getInt("humidity");
		pressure = main.getInt("pressure");
		feelsLike = main.getDouble("feels_like");
		
	}
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


}
