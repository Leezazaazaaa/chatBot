package chatBot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
	private String location;
	private JSONObject coords;
	private Weather current;
	private List<Weather> eightDayForcast;
	
	
	/*========================Constructors========================*/
	
	WeatherData(String location) throws IOException{
		//URL gets the JSON from openweathermap
		this.location=location;
		
		URL oracle = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid="+APIKEY+"&units=metric");
		
		//in converts the url into a single JSON string
		BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
		
		String input = in.readLine();//JSON string
	
		setCurrent(input);
		
		setEightDayForcast(coords.get("lon").toString(),coords.get("lat").toString());
		
		
	}
	
	/*========================Setters========================*/
	
	private void setEightDayForcast(String lon, String lat) throws IOException{
		
		URL oracle = new URL("https://api.openweathermap.org/data/2.5/onecall?lat="+lat+"&lon="+lon+"&exclude=current,minutely,hourly&appid="+APIKEY+"&units=metric");
		
		//in converts the url into a single JSON string
		BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
		
		String input = in.readLine();//JSON string
		
		//create a JSON object from input string
		JSONObject local = new JSONObject(input);
				
		JSONArray days = local.getJSONArray("daily");
	
		eightDayForcast = new ArrayList<Weather>();
		
		for(int i = 0; i<days.length();i++) {
			eightDayForcast.add(new Weather(days.getJSONObject(i)));
		}

	}

	private void setCurrent(String input) throws IOException {
		
		
		//create a JSON object from input string
		JSONObject local = new JSONObject(input);
		
		//IMPORTANT: A JSONObject can have imbedded JSON objects
		
		this.coords = new JSONObject(local.get("coord").toString());
		
		this.current = new Weather(local);
		
		
	}
	
	/*========================Getters========================*/
	
	public Weather getCurrent() {
		return current;
	}
	public Weather[] getEightDayForcast() {
		return  eightDayForcast.toArray(new Weather[eightDayForcast.size()]);
	}
	public JSONObject getCoords() {//returns description, JSON Object
		return coords;
	}
	public String getLocation() {
		return location;
	}
	
	
	
	
	
	
	
	

}
