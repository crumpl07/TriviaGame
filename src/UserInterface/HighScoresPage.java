package UserInterface;

import java.util.ArrayList;
import java.util.Collections;

import SQL.SQLCalls;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class HighScoresPage {
	
	ArrayList<String> hello = new ArrayList<String>();
	
	public void ScoresPage(Stage stage)
	{
		Group group = new Group();
		Label highscoreL = new Label("PEOPLE THAT do not KNOW MANY THINGS\n"
				+ "(i.e. we didn't have time to figure out how to\norder by highscores (;~;) )");
		highscoreL.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
		highscoreL.relocate(150, 50);
		highscoreL.setTextAlignment(TextAlignment.CENTER);
		
		backButton(group, stage);
		Scores();
		highScoreLabels(group);
		group.getChildren().add(highscoreL);
		
		Scene scene = new Scene(group, 700, 500);
	    scene.setFill(Color.PALEGOLDENROD);
		stage.setResizable(false);

		stage.setTitle("Scores");
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
	
	public void highScoreLabels(Group group)
	{
		int x = 320, y = 180;
		int counter =1;
		int count =1;
		for(String i: hello)
		{
			Label label = new Label(i);
			label.relocate(x-25, y-2);
			label.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
			group.getChildren().addAll(label);
			y+=40;
			counter++;
		}
	}
	
	public void Scores()
	{
		SQLCalls sql = new SQLCalls();
		
		sql.reorderByScore();
		hello = sql.getHighestScores();
		
		for(String x: hello)
		{
			System.out.println(x);
		}
	}
	
}
