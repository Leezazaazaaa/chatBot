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
	
	
	
	public void sendMessage(ActionEvent event) throws IOException {
		String input = userText.getText();
		execute(input);
	}
	
	public void printOutput(String input) {
		botReply.setText(input);
	}
	
	public void execute(String input) {
		response = ChatBot.chatGUI(input);
		printOutput(response);
	}
	

	

}
