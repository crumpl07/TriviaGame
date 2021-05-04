package UserInterface;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TriviaSelection 
{
	public void selectTrivia(Stage stage)
	{
		Group group = new Group();
		
		backButton(group, stage);
		
		Button quiz = new Quiz("poodles");
		group.getChildren().add(quiz);
		
		Scene scene = new Scene(group, 700, 500);
		stage.setResizable(false);
		scene.setFill(Color.BLANCHEDALMOND);
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
	
	public class Quiz extends Button
	{
		
		public Quiz(String title)
		{
			super(title);
			this.setStyle("-fx-background-color: lightblue");
			this.setPrefSize(400, 65);
			this.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 30));
			this.relocate(10, 10);
			this.setOnAction(e->{
				
			});
			
			this.setOnMouseEntered(e->{
				this.setStyle("-fx-background-color: skyblue");
			});
			
			this.setOnMouseExited(e->{
				this.setStyle("-fx-background-color: lightblue");
			});
		}
	}
}
















