package chatBot;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application{
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException{
		launch(args);
		
		//Example of how to use the Weather class
		
		WeatherData d = new WeatherData("Brisbane,AU");//step1: Create a WeatherData object by sending a location
		
		d.display();//You can display its contents like so
		
		Weather info = new Weather(d);//Step 2: create a Weather Object from the WeatherData Object
		
		// you now have access to all the info you want.
		System.out.println("\ncurrent temp: "+info.getActualTemp()+"C");
		System.out.println("\nWeather Conditions: "+info.getDescription());
		
		ChatBot chat = new ChatBot(d);
		chat.startChatBot(d);
		
		/*
		 * TODO: More JUNIT testing, hard because data is always changing 
		 * 
		 */
		
		
	}

}
