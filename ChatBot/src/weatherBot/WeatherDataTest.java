package weatherBot;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.json.JSONObject;
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
	//testing object from input url
	@Test
	void testGetInput() throws IOException {
		String location = "Brisbane,AU";
		WeatherData test = new WeatherData(location);
		
		String expected="{\"coord\":{\"lon\":153.0281,\"lat\":-27.4679},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"base\":\"stations\",\"main\":{\"temp\":20.99,\"feels_like\":21.18,\"temp_min\":20,\"temp_max\":22.22,\"pressure\":1016,\"humidity\":78},\"visibility\":10000,\"wind\":{\"speed\":3.6,\"deg\":360},\"clouds\":{\"all\":0},\"dt\":1618481760,\"sys\":{\"type\":1,\"id\":9485,\"country\":\"AU\",\"sunrise\":1618430660,\"sunset\":1618471873},\"timezone\":36000,\"id\":2174003,\"name\":\"Brisbane\",\"cod\":200}";
		String actual = test.getInput();
		
		assertEquals(expected, actual); //the expected values keeps on updating because the weather changes continuously 		
	}
	
	//testing json object created from input
	@Test
	void testGetLocal() throws IOException {
		String location = "Brisbane,AU";
		WeatherData test = new WeatherData(location);
		
		String expected="{\"visibility\":10000,\"timezone\":36000,\"main\":{\"temp\":18.92,\"temp_min\":16.67,\"humidity\":77,\"pressure\":1016,\"feels_like\":18.88,\"temp_max\":20},\"clouds\":{\"all\":0},\"sys\":{\"country\":\"AU\",\"sunrise\":1618430660,\"sunset\":1618471873,\"id\":9485,\"type\":1},\"dt\":1618493703,\"coord\":{\"lon\":153.0281,\"lat\":-27.4679},\"weather\":[{\"icon\":\"01n\",\"description\":\"clear sky\",\"main\":\"Clear\",\"id\":800}],\"name\":\"Brisbane\",\"cod\":200,\"id\":2174003,\"base\":\"stations\",\"wind\":{\"deg\":310,\"speed\":2.57}}";
		JSONObject actual = test.getLocal();
		
		assertEquals(expected, actual); //the expected values keeps on updating because the weather changes continuously  		
	}
	
	//testing the main, which is a JSON object inside of a JSONObject
	@Test
	void testGetMain() throws IOException {
		String location = "Brisbane,AU";
		WeatherData test = new WeatherData(location);
		
		String expected="{\"temp\":19.03,\"temp_min\":17.78,\"humidity\":82,\"pressure\":1016,\"feels_like\":19.13,\"temp_max\":20}";
		JSONObject actual = test.getMain();
		
		assertEquals(expected, actual); //the expected values keeps on updating because the weather changes continuously 
	}
	
	//testing the description of JSON object 
	@Test
	void testGetDescription() throws IOException {
		String location = "Brisbane,AU";
		WeatherData test = new WeatherData(location);
		
		String expected="{\"icon\":\"01n\",\"description\":\"clear sky\",\"main\":\"Clear\",\"id\":800}";
		JSONObject actual = test.getDescription();
		String actual2 = actual.toString();
		
		assertEquals(expected, actual2); 
	}
	
	
		
}
