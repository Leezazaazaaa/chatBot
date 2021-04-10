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
	private JSONObject main;
	private JSONObject description;
	
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
		
		//IMPORTANT: A JSONObject can have imbedded JSON objects
		
		this.main= new JSONObject(local.get("main").toString()); //the main for example is a JSON object inside of a JSONObject
		
		description = new JSONObject(local.get("weather").toString().replaceAll("[\\[\\]]", ""));
		/*the weather actually is an Array of length 1 so 
		I turned it into a JSONObject by removing the "[]"*/
		
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
	public JSONObject getMain() {//returns the main, JSON Object
		return this.main;
	}
	public JSONObject getDescription() {//returns description, JSON Object
		return description;
	}
	
	
	/*========================Setters========================*/
	
	
	/*========================Attributes========================*/
	
	public void display() {//simple display method to see the contents of the JSON object
		for(String string: names) {
			System.out.println(string+" :"+local.get(string));
		}
	}

	
	
	
	
	
	
	
	
	

}
