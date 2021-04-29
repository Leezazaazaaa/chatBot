package chatBot;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

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

}
