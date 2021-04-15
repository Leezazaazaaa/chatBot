package chatBot;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class WeatherTest {
	
	//testing the actual temperature 
	@Test
	void testGetActualTemp() throws IOException {
		String location = "Brisbane,AU";
		WeatherData data = new WeatherData(location);
		Weather test = new Weather(data);
		
		double expected = 17.91; //the expected value might not be same all the time as the weather keeps changing
		double actual = test.getActualTemp();
		assertEquals (expected, actual, 0.1); //equating the value with the epsilon of 0.1
	}
	
	//testing the minimum temperature
	@Test
	void testGetMinTemp() throws IOException {
		String location = "Brisbane,AU";
		WeatherData data = new WeatherData(location);
		Weather test = new Weather(data);
		
		double expected = 16.67; //the expected value might not be same all the time as the weather keeps changing
		double actual = test.getMinTemp();
		assertEquals (expected, actual, 0.1);  //equating the value with the epsilon of 0.1
	}

}
