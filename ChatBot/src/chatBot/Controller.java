package chatBot;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller{
	
	@FXML
	private Label botReply;
	@FXML
	private TextField userText;
	@FXML
	private Button sendBtn;
	
	String location;
	String response;
	
	public void sendMessage(ActionEvent event) throws IOException {		//gets input from user when button is clicked
		String input = userText.getText();
		execute(input);													//executes method for retrieving response
	}
	
	public void printOutput(String input) {								//prints response
		botReply.setText(input);
	}
	
	public void execute(String input) {									//Retrieves output based on input
		response = ChatBot.chatGUI(input);								//runs method in ChatBot class to get response
		printOutput(response);											//prints output 
	}

	
	
	
	
	
}
