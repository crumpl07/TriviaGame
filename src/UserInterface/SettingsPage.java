package UserInterface;

import javax.swing.GroupLayout.Alignment;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class SettingsPage {
	
	public void settingsPage(Stage stage)
	{
		Group group = new Group();
		Label funText = new Label("THE FUN BAR!!!!!\nADJUST IT AND SEE WHAT HAPPENS. :D");
		
		volumeBar(group);
		confirmButton(group, stage);
		backButton(group, stage);
		
		funText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 30));
		funText.setTextAlignment(TextAlignment.CENTER);
		funText.relocate(20, 80);
		
		group.getChildren().add(funText);
		Scene scene = new Scene(group, 700, 500);
		stage.setResizable(false);
		scene.setFill(Color.THISTLE);
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
		volumeBar.relocate(110, 210);
		volumeBar.setMin(0);
		volumeBar.setMax(100);
		volumeBar.setValue(50);
		volumeBar.setPrefSize(500, 40);
		
		group.getChildren().add(volumeBar);
	}
	
	public void confirmButton(Group group, Stage stage)
	{
		Button confirm = new Button();
		confirm.relocate(150, 300);
		confirm.setText("Confirm Settings");
		confirm.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 30));
		confirm.setPrefSize(400, 30);
		HomePage homepage = new HomePage();
		
		confirm.setOnAction(e->{
			homepage.homePage(stage);
		});
		
		group.getChildren().add(confirm);
	}
	

}
