package UserInterface;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
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
		Button back = new Button();
		back.setTranslateX(0);
		back.setTranslateY(0);
		back.setText("Back");
		
		HomePage page = new HomePage();
		
		back.setOnAction(e-> {
			page.homePage(stage);
		});
		
		group.getChildren().addAll(back);
	}
	
	public void confirmButton(Group group)
	{
		Button confirm = new Button();
		confirm.setTranslateX(100);
		confirm.setTranslateY(100);
		confirm.setText("Confirm Settings");
		
		group.getChildren().add(confirm);
	}
	
	public void volumeBar(Group group)
	{
		Slider volumeBar = new Slider();
		volumeBar.setTranslateX(20);
		volumeBar.setTranslateY(20);
		volumeBar.setMin(0);
		volumeBar.setMax(100);
		volumeBar.setValue(50);
		
		group.getChildren().add(volumeBar);
	}
}
