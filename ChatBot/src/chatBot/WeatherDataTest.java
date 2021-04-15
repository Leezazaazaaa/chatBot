package chatBot;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class WeatherDataTest {

 //testing each string array of all the keys in the JSON string
	@Test
	void testGetNames0() throws IOException {
		String location = "Brisbane,AU";
		WeatherData test = new WeatherData(location);
		
		String expected="visibility";
		String actual = test.getNames()[0];
		
		assertEquals(expected, actual);
		
		
	}
	
	@Test
	void testGetNames1() throws IOException {
		String location = "Brisbane,AU";
		WeatherData test = new WeatherData(location);
		
		String expected="timezone";
		String actual = test.getNames()[1];
		
		assertEquals(expected, actual);
		
		
	}
	
	@Test
	void testGetNames2() throws IOException {
		String location = "Brisbane,AU";
		WeatherData test = new WeatherData(location);
		
		String expected="main";
		String actual = test.getNames()[2];
		
		assertEquals(expected, actual);
		
		
	}
	
	@Test
	void testGetNames3() throws IOException {
		String location = "Brisbane,AU";
		WeatherData test = new WeatherData(location);
		
		String expected="clouds";
		String actual = test.getNames()[3];
		
		assertEquals(expected, actual);
		
		
	}
	
	@Test
	void testGetNames4() throws IOException {
		String location = "Brisbane,AU";
		WeatherData test = new WeatherData(location);
		
		String expected="sys";
		String actual = test.getNames()[4];
		
		assertEquals(expected, actual);
		
		
	}
	
	@Test
	void testGetNames5() throws IOException {
		String location = "Brisbane,AU";
		WeatherData test = new WeatherData(location);
		
		String expected="dt";
		String actual = test.getNames()[5];
		
		assertEquals(expected, actual);
		
	
	}
	
	@Test
	void testGetNames6() throws IOException {
		String location = "Brisbane,AU";
		WeatherData test = new WeatherData(location);
		
		String expected="coord";
		String actual = test.getNames()[6];
		
		assertEquals(expected, actual);
		
		
	}
	
	@Test
	void testGetNames7() throws IOException {
		String location = "Brisbane,AU";
		WeatherData test = new WeatherData(location);
		
		String expected="weather";
		String actual = test.getNames()[7];
		
		assertEquals(expected, actual);
		
		
	}
	
	@Test
	void testGetNames8() throws IOException {
		String location = "Brisbane,AU";
		WeatherData test = new WeatherData(location);
		
		String expected="name";
		String actual = test.getNames()[8];
		
		assertEquals(expected, actual);
		
		
	}
	
	@Test
	void testGetNames9() throws IOException {
		String location = "Brisbane,AU";
		WeatherData test = new WeatherData(location);
		
		String expected="cod";
		String actual = test.getNames()[9];
		
		assertEquals(expected, actual);
		
		
	}
	
	@Test
	void testGetNames10() throws IOException {
		String location = "Brisbane,AU";
		WeatherData test = new WeatherData(location);
		
		String expected="id";
		String actual = test.getNames()[10];
		
		assertEquals(expected, actual);
		
		
	}
	
	@Test
	void testGetNames11() throws IOException {
		String location = "Brisbane,AU";
		WeatherData test = new WeatherData(location);
		
		String expected="base";
		String actual = test.getNames()[11];
		
		assertEquals(expected, actual);
		
		
	}
	
	@Test
	void testGetNames12() throws IOException {
		String location = "Brisbane,AU";
		WeatherData test = new WeatherData(location);
		
		String expected="wind";
		String actual = test.getNames()[12];
		
		assertEquals(expected, actual);
		
		
	}
}
