package chatBot;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

class WeatherDataTest {

 //testing each string array of all the keys in the JSON string
	@Test
	void testGetCoords() throws IOException {
		String location = "Brisbane,AU";
		WeatherData test = new WeatherData(location);
		
		double lon = 153.0281;
		double lat = -27.4679;
		JSONObject actual = test.getCoords();
		
		assertEquals(lon, actual.getDouble("lon"));//testing longitude
		assertEquals(lat, actual.getDouble("lat"));//testing latitude
		
		
	}
	
	
	
	
	
		
}
