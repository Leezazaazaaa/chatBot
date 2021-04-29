package chatBot;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.junit.jupiter.api.Test;

class ChatBotTest {

	@Test
	void testResponses1() throws IOException { 
		String location = "Brisbane,AU";
		WeatherData data = new WeatherData(location);
		ChatBot test = new ChatBot(data);
		
		String expected = "hello - Hi there! How are you?";
		String actual = test.Responses()[0];
		assertEquals(expected, actual);
			
	}
	
	@Test
	void testResponses2() throws IOException {
		String location = "Brisbane,AU";
		WeatherData data = new WeatherData(location);
		ChatBot test = new ChatBot(data);
		
		String expected = "good - That's good to hear!";
		String actual = test.Responses()[1];
		assertEquals(expected, actual);
			
	}
	
	@Test
	void testResponses3() throws IOException { //checking the text command "what is your name? - My name is ChatBot" from response method
		String location = "Brisbane,AU";
		WeatherData data = new WeatherData(location);
		ChatBot test = new ChatBot(data);
		
		String expected = "what is your name? - My name is ChatBot";
		String actual = test.Responses()[2];
		assertEquals(expected, actual);
			
	}
	
	@Test
	void testResponses4() throws IOException {
		String location = "Brisbane,AU";
		WeatherData data = new WeatherData(location);
		ChatBot test = new ChatBot(data);
		
		String expected = "help - Enter input into the console and receive a response.";
		String actual = test.Responses()[3];
		assertEquals(expected, actual);
			
	}
	
	@Test
	void testResponses5() throws IOException {
		String location = "Brisbane,AU";
		WeatherData data = new WeatherData(location);
		ChatBot test = new ChatBot(data);
		
		String expected = "bye - Goodbye!";
		String actual = test.Responses()[4];
		assertEquals(expected, actual);
			
	}
	
	@Test
	void testResponses6() throws IOException {
		String location = "Brisbane,AU";
		WeatherData data = new WeatherData(location);
		ChatBot test = new ChatBot(data);
		
		String expected = "what is the weather? - it is (answer)";
		String actual = test.Responses()[5];
		assertEquals(expected, actual);
			
	}
	
	@Test
	void testResponses7() throws IOException {
		String location = "Brisbane,AU";
		WeatherData data = new WeatherData(location);
		ChatBot test = new ChatBot(data);
		
		String expected = "what should i wear? - You Should Wear (answer)";
		String actual = test.Responses()[6];
		assertEquals(expected, actual);
			
	}
	
	@Test
	void testGetLines() throws IOException {
		String location = "Brisbane,AU";
		WeatherData data = new WeatherData(location);
		ChatBot test = new ChatBot(data);
		
		int expected = 0; //expected value is 0 because initially there is no lines created
		int actual = ChatBot.getLines(location);
		assertEquals(expected, actual);
			
	}
	
	
	

}
