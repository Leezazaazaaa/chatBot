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

}
