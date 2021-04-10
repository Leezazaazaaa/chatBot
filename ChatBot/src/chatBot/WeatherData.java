package chatBot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONObject;

public class WeatherData {
	
	private final String APIKEY = "e3d8cd2bc42e09a996101d712189ec71";
	private String input;
	private JSONObject local;
	private String[] names;
	private String main;
	private Weather weather;
	
	
	
	WeatherData(String location) throws IOException{
		
		URL oracle = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid="+APIKEY+"&units=metric");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
		
		this.input = in.readLine();
		
		this.local = new JSONObject(input);
		
		this.names = JSONObject.getNames(local);
		
		setWeather(local.getString("main"));
		
	}
	
	public String[] getNames() {//returns string array of all the keys in the JSON string
		return names;
	}
	
	private void setWeather(String main) {
		
		JSONObject mainWeather = new JSONObject(main);
		
		this.weather = new Weather(mainWeather);
		
	}
	public Weather getWeather() {
		
		return this.weather;
	}
	
	
	
	
	
	
	
	
	

}
