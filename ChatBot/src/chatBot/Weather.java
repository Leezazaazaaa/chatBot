package chatBot;

import java.text.SimpleDateFormat;
import org.json.JSONArray;
import org.json.JSONObject;

/*
 * This Class stores all essential information we want to be used by the bot. Info extracted from WeatherData
 * Immutable class!
 */

public class Weather {
	
	/*========================Attributes========================*/
	private String dateTime;
	private double temp_min;
	private double temp_max;
	private double temp_current;
	private double humidity;
	private double pressure;
	private String weather_desc;
	
	
	
	/*========================Constructors========================*/
	
	public Weather(JSONObject day){
		
		System.out.println("\n"+day.toString()+"\n");
		
		//setting the date and time
		if(day.has("dt"))setDate(day.getLong("dt"));//sets the dateStamp and converts to readable
		else setDate(System.currentTimeMillis()/1000);
		
		//set the description of the weather
		JSONArray desc = day.getJSONArray("weather");
		setDesc(desc.getJSONObject(0));
		
		//setting temperature ranges
		if(day.has("temp"))setTemps(day.getJSONObject("temp"));
		else setTemps(day.getJSONObject("main"));
		
		//setting the humidity
		if(day.has("humidity")) setHumidity(day);
		else setHumidity(day.getJSONObject("main"));
		
		//setting the pressure
		if(day.has("pressure")) setPressure(day);
		else setPressure(day.getJSONObject("main"));
		
		
	}
	
	
	/*========================Setters========================*/
	
	private void setDate(long dateStamp) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		this.dateTime = dateFormat.format(dateStamp*1000);
		
	}
	private void setDesc(JSONObject weather) {
		this.weather_desc=weather.get("description").toString();
	}
	private void setTemps(JSONObject temp) {
		if(temp.has("min")) {
			
			this.temp_min = Double.parseDouble(temp.get("min").toString());
			this.temp_max = Double.parseDouble(temp.get("max").toString());
			this.temp_current = Double.parseDouble(temp.get("day").toString());
		}else {
			
			this.temp_min = Double.parseDouble(temp.get("temp_min").toString());
			this.temp_max = Double.parseDouble(temp.get("temp_max").toString());
			this.temp_current = Double.parseDouble(temp.get("temp").toString());
		}
	}
	private void setHumidity(JSONObject hum) {
		this.humidity = hum.getDouble("humidity");
	}
	private void setPressure(JSONObject pres) {
		this.pressure = pres.getDouble("pressure");
	}

	/*========================Getters========================*/

	public String getDateTime() {
		return dateTime;
	}


	public double getTemp_min() {
		return temp_min;
	}


	public double getTemp_max() {
		return temp_max;
	}


	public double getTemp_current() {
		return temp_current;
	}


	public String getWeather_desc() {
		return weather_desc;
	}
	
	public double getHumidity() {
		return humidity;
	}


	public double getPressure() {
		return pressure;
	}

	@Override
	public String toString() {
		return "Weather [dateTime=" + dateTime + ", temp_min=" + temp_min + ", temp_max=" + temp_max + ", temp_current="
				+ temp_current + ", humidity=" + humidity + ", pressure=" + pressure + ", weather_desc=" + weather_desc
				+ "]";
	}


	public void display() {
		System.out.println(toString());
	}


}
