package chatBot;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class WeatherDataTest {


	@Test
	void testGetNames() throws IOException {
		String apiKey = "e3d8cd2bc42e09a996101d712189ec71";
		String location = "Brisbane,AU";
		WeatherData test = new WeatherData(location,apiKey);
		
		String expected="visibility";
		String actual = test.getNames()[0];
		
		assertEquals(expected, actual);
		
		
	}

}
