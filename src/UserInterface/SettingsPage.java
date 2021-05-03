package UserInterface;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SettingsPage {
	
	public void settingsPage(Stage stage)
	{
		Group group = new Group();
		
		volumeBar(group);
		confirmButton(group);
		backButton(group, stage);
		
		Scene scene = new Scene(group, 700, 500);
		stage.setResizable(false);

		stage.setTitle("Settings");
		stage.setScene(scene);
		stage.show();
	}
	
	public void backButton(Group group, Stage stage)
	{
		Button button = new Button();
		button.setText("Back");
		button.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
		button.relocate(10, 10);
		HomePage homepage = new HomePage();
		
		button.setOnAction(e-> {
				homepage.homePage(stage);
		});
		
		group.getChildren().add(button);
	}
	
	public void volumeBar(Group group)
	{
		Slider volumeBar = new Slider();
		volumeBar.relocate(250, 100);
		volumeBar.setMin(0);
		volumeBar.setMax(100);
		volumeBar.setValue(50);
		
		group.getChildren().add(volumeBar);
	}
	
	public void confirmButton(Group group)
	{
		Button confirm = new Button();
		confirm.relocate(270, 300);
		confirm.setText("Confirm Settings");
		confirm.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
		
		group.getChildren().add(confirm);
	}
}
