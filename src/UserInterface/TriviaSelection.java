package UserInterface;

import java.util.ArrayList;

import SQL.SQLCalls;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class TriviaSelection 
{
	public void selectTrivia(Stage stage)
	{
		Group group = new Group();
		
		SQLCalls sql = new SQLCalls();
		backButton(group, stage);
		
		ScrollPane sp = new ScrollPane();
		VBox vb = new VBox(); 
		Button addBt = new Button("+");
	
		ArrayList<String> quizNames = sql.getQuizzes();
		
		for(int i = 0; i < quizNames.size(); i++)
		{
			vb.getChildren().add(new Quiz(stage, quizNames.get(i)));
		}
		
		sp.relocate(100, 60);
		sp.setContent(vb);
		sp.setPrefSize(450, 375);
		
		group.getChildren().add(sp);
		
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
	
	public class Quiz extends Button
	{
		public Quiz(Stage stage, String title)
		{
			super(title);
			
			this.setStyle("-fx-background-color: lightblue");
			this.setPrefSize(400, 75);
			this.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
				
			this.setOnAction(e->{
				TriviaPlay page = new TriviaPlay();
				page.triviaPlayPage(stage, title);
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
