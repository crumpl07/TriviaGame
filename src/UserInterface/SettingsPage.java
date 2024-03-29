package UserInterface;

import java.util.ArrayList;

import SQL.SQLCalls;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SettingsPage {
	
	//Creates the settings page
	public void settingsPage(Stage stage, String user)
	{
		Group group = new Group();
		
		volumeBar(group);
		confirmButton(group);
		backButton(group, stage, user);
		
		Scene scene = new Scene(group, 700, 500);
		stage.setResizable(false);

		stage.setTitle("Settings");
		stage.setScene(scene);
		stage.show();
	}
	
	//Takes the user back to the home page
	public void backButton(Group group, Stage stage, String user)
	{
		Button button = new Button();
		button.setText("Back");
		button.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
		button.relocate(10, 10);
		HomePage homepage = new HomePage();
		
		button.setOnAction(e-> {
				homepage.homePage(stage, user);
		});
		
		group.getChildren().add(button);
	}
	
	//Creates the settings volume bar
	public void volumeBar(Group group)
	{
		Slider volumeBar = new Slider();
		volumeBar.relocate(250, 100);
		volumeBar.setMin(0);
		volumeBar.setMax(100);
		volumeBar.setValue(50);
		
		group.getChildren().add(volumeBar);
	}
	
	//creates the confirm button
	public void confirmButton(Group group)
	{
		Button confirm = new Button();
		confirm.relocate(270, 300);
		confirm.setText("Confirm Settings");
		confirm.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
		
		group.getChildren().add(confirm);
	}
	

}
