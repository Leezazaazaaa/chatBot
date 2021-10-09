package chatBot;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
	
	@FXML
	private Label botReply;
	@FXML
	private TextField userText;
	@FXML
	private Button sendBtn;
	
	public void sendMessage(ActionEvent event) {
		System.out.println(userText.getText());
		
		botReply.setText("How are you");
	}
	
	
	

}
