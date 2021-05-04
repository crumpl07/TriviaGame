package UserInterface;

import java.util.ArrayList;

import SQL.SQLCalls;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class HighScoresPage {
	
	ArrayList<String> hello = new ArrayList<String>();
	
	public void ScoresPage(Stage stage)
	{
		Group group = new Group();
		
		backButton(group, stage);
		Scores();
		highScoreLabels(group);

		
		Scene scene = new Scene(group, 700, 500);
	    scene.setFill(Color.AQUA);
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
		int x = 320, y = 40;
		int counter =1;
		int count =1;
		for(String i: hello)
		{
			Label label = new Label(i);
			if((counter%2) == 1)
			{
				label.relocate(x-25, y-2);
			}
			else if((counter%2) == 0)
			{
				label.relocate(x+20,y-25);
			}
			label.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
			group.getChildren().addAll(label);
			y+=20;
			counter++;
		}
		y=40;
		counter = 1;
		for(String i: hello)
		{
			if((count%2) == 1)
			{
				Label number = new Label(counter + ".)");
				number.relocate(x-70,y);
				number.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
				group.getChildren().add(number);
				counter++;
			}
			count++;
			y+=20;
		}
	}
	
	public void Scores()
	{
		SQLCalls sql = new SQLCalls();
		
		hello = sql.getHighestScores();
		for(String x: hello)
		{
			System.out.println(x);
		}
	}
	
}
