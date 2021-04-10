package chatBot;

import java.io.IOException;

import org.json.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		WeatherData d = new WeatherData("Brisbane,AU");
		
		d.display();
		Weather info = d.getWeather();
		
		System.out.println("current temp: "+info.getActualTemp()+"C");
		System.out.println("Weather Conditions: "+info.getDescription());
		
		
		
	}

}
