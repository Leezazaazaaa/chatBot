package chatBot;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class WeatherDataTest {


	@Test
	void testGetNames() throws IOException {
		String location = "Brisbane,AU";
		WeatherData test = new WeatherData(location);
		
		String expected="visibility";
		String actual = test.getNames()[0];
		
		assertEquals(expected, actual);
		
		
	}
	@Test
	void testSetNames() {
		
		
	}

}
