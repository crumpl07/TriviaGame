package UserInterface;
import java.util.ArrayList;

import SQL.Questions;
import SQL.SQLCalls;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class TriviaPlay {
	
	ArrayList<Questions> questions;
	
	public void triviaPlayPage(Stage stage, String title)
	{
		SQLCalls sql = new SQLCalls();
		int id = 0;
		questions = sql.getQuestions(id);
		
		Group group = new Group();
		
		Label titles = new Label(title);
		
		Label question = new Label();
		Label answer1 = new Label();
		Label answer2 = new Label();
		Label answer3 = new Label();
		Label answer4 = new Label();
		
		RadioButton answer1rb = new RadioButton();
		RadioButton answer2rb = new RadioButton();
		RadioButton answer3rb = new RadioButton();
		RadioButton answer4rb = new RadioButton();
		
		Button nextb = new Button("Next");
		
		titles.relocate(200,10);
		question.relocate(200,10);
		answer1.relocate(200,10);
		answer2.relocate(200,10);
		answer3.relocate(200,10);
		answer4.relocate(200,10);
		
		answer1rb.relocate(200,10);
		answer2rb.relocate(200,10);
		answer3rb.relocate(200,10);
		answer4rb.relocate(200,10);
		nextb.relocate(200, 10);
		
		
		group.getChildren().addAll(question, answer1, answer2, answer3, answer4, answer1rb, answer2rb,
				answer3rb, answer4rb, nextb);
		
		Scene scene = new Scene(group, 700, 500);
		stage.setResizable(false);
		
		stage.setTitle("Play");
		stage.setScene(scene);
		stage.show();
	}
}
