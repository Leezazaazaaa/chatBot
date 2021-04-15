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
	
	//testing the maximum temperature
	@Test
	void testGetMaxTemp() throws IOException {
		String location = "Brisbane,AU";
		WeatherData data = new WeatherData(location);
		Weather test = new Weather(data);
		
		double expected = 18.89; //the expected value might not be same all the time as the weather keeps changing
		double actual = test.getMaxTemp();
		assertEquals (expected, actual, 0.1); //equating the value with the epsilon of 0.1
	}
	
	//testing the humidity
	@Test
	void testGetHumidity() throws IOException {
		String location = "Brisbane,AU";
		WeatherData data = new WeatherData(location); 
		Weather test = new Weather(data);
		
		double expected = 88.0; //the expected value might not be same all the time as the weather keeps changing
		double actual = test.getHumidity();
		assertEquals (expected, actual, 0.1); //equating the value with the epsilon of 0.1
	}
	
	//testing the pressure
	@Test
	void testGetPressure() throws IOException {
		String location = "Brisbane,AU";
		WeatherData data = new WeatherData(location);
		Weather test = new Weather(data);
		
		double expected = 1015.0;  //the expected value might not be same all the time as the weather keeps changing
		double actual = test.getPressure();
		assertEquals (expected, actual, 0.1); //equating the value with the epsilon of 0.1
	}
	
	//testing the feels like temperature
	@Test
	void testGetFeelsLike() throws IOException {
		String location = "Brisbane,AU";
		WeatherData data = new WeatherData(location);
		Weather test = new Weather(data);
		
		double expected = 18.0;  //the expected value might not be same all the time as the weather keeps changing
		double actual = test.getFeelsLike();
		assertEquals (expected, actual, 0.1); //equating the value with the epsilon of 0.1
	}


}
