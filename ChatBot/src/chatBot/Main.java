package chatBot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

import org.json.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		String apiKey = "e3d8cd2bc42e09a996101d712189ec71";
		String location = "Brisbane,AU";
	
		URL oracle = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid="+apiKey+"&units=metric");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
		
		String input = in.readLine();
		
		JSONObject brisbane = new JSONObject(input);
		
		String[] names = JSONObject.getNames(brisbane);
		
		List<String> nameList = new ArrayList<String>();
		
		
		
		//JSONPointer pointer = new JSONPointer(names[0]);
		
		
		
		for(String string: names) {
			System.out.println(string+" : "+brisbane.get(string));
		}
		
	}

}
