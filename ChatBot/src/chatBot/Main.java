package chatBot;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application{
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
			primaryStage.setTitle("Chatting App");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException{
		launch(args);
		
		
		
		//Example of how to use the Weather class
		
		WeatherData d = new WeatherData("Dublin,IE");//step1: Create a WeatherData object by sending a location
	
		double lon=d.getCoords().getDouble("lon");
		double lat=d.getCoords().getDouble("lat");
		
		Weather day1 = d.getEightDayForcast()[0];
		
		
		System.out.println("time of execution: "+d.getCurrent().getDateTime()+"\nLongitude: "+lon+"\tLatitude: "+lat);
		Weather today = d.getCurrent();
		today.display();
		Weather[] forecast = d.getEightDayForcast();
		
		for(int i=0;i<forecast.length;i++) {
			forecast[i].display();
		}
		
		
	
	}
	

	

}
