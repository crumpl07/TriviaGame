package UserInterface;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class TriviaSelection 
{
	public void selectTrivia(Stage stage)
	{
		Group group = new Group();
		
		backButton(group, stage);
		
		Scene scene = new Scene(group, 700, 500);
		stage.setResizable(false);

		stage.setTitle("Select Trivia");
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
}
