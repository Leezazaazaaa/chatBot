package chatBot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

/*
 *This class May not be necessary in the long run, for now it separates all the url 
 *processing from the actual Weather information we want to use.
 *So to set a Weather class a WeatherData class must be first instantiated. 
 *
 */

public class WeatherData {
	
	/*========================Attributes========================*/
	
	private final String APIKEY = "e3d8cd2bc42e09a996101d712189ec71";
	private String input;
	private JSONObject local;
	private String[] names;
	private String main;
	private Weather weather;
	private String description;
	
	/*========================Constructors========================*/
	
	WeatherData(String location) throws IOException{
		
		//URL gets the JSON from openweathermap
		
		URL oracle = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid="+APIKEY+"&units=metric");
		
		//in converts the url into a single JSON string
		BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
		
		this.input = in.readLine();//JSON string
		
		
		//create a JSON object from input string
		this.local = new JSONObject(input);
		
		
		//gets and sets all variable keys from JSON object
		this.names = JSONObject.getNames(local);
		
		this.main=local.get("main").toString();
		
		description = local.get("weather").toString().replaceAll("[\\[\\]]", ""); //for some reason the weather attribute is an array of length 1
																				//this trims down the the array into a simple string that can be turned into a json object
		
		setWeather();
		
	}
	
	
	/*========================Getters========================*/
	
	public String getInput() {//gets raw JSON string from url
		return input;
	}
	public String[] getNames() {//returns string array of all the keys in the JSON string
		return names;
	}
	public JSONObject getLocal() {//returns the JSONObject created from input
		return local;
	}
	public String getMain() {//returns the main data from the JSON Object
		return this.main;
	}
	public Weather getWeather() {//returns weather object storing all wanted data
		
		return this.weather;
	}
	public String getDescription() {//returns description JSON string
		return description;
	}
	
	
	/*========================Setters========================*/
	
	private void setWeather() { //weather data is set based on only 2 attributes from the JSON file. The main and description
		//much more can be added.
		this.weather = new Weather(new JSONObject(local.get("main").toString()), new JSONObject(description));
	}
	
	
	/*========================Attributes========================*/
	
	public void display() {//simple display method to see the contents of the JSON object
		for(String string: names) {
			System.out.println(string+" :"+local.get(string));
		}
	}

	
	
	
	
	
	
	
	
	

}
