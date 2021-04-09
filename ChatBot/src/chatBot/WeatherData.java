package chatBot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONObject;

public class WeatherData {
	
	private String input;
	private JSONObject local;
	
	
	
	WeatherData(String location, String apiKey) throws IOException{
		
		URL oracle = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid="+apiKey+"&units=metric");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
		
		this.input = in.readLine();
		
		this.local = new JSONObject(input);
		
	}
	
	public String[] getNames() {//returns string array of all the keys in the JSON string
		return JSONObject.getNames(local);
	}
	
	
	
	
	
	

}
