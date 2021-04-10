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
		
		//URL gets the JSON from openweathermap
		
		URL oracle = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid="+APIKEY+"&units=metric");
		
		//in converts the url into a single JSON string
		BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
		
		this.input = in.readLine();
		
		
		//create a JSON object from input string
		this.local = new JSONObject(input);
		
		
		//gets and sets all variable keys from JSON object
		this.names = JSONObject.getNames(local);
		
		setWeather(local.get("main").toString());
		
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
	public JSONObject getLocal() {
		return local;
	}
	
	
	public void display() {
		for(String string: names) {
			System.out.println(string+" :"+local.get(string));
		}
	}
	
	
	
	
	
	
	
	
	

}
