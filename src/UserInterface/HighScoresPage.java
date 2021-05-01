package UserInterface;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HighScoresPage {
	
	public void ScoresPage(Stage stage)
	{
		Group group = new Group();
		
		back(group,stage);
		
		Scene scene = new Scene(group, 700, 500);
		stage.setTitle("Scores");
		stage.setScene(scene);
		stage.show();
	}
	
	public void back(Group group, Stage stage)
	{
		SettingsPage back = new SettingsPage();
		back.backButton(group, stage);
	}
	
	public void getBestScores()
	{
		//return a list of the top 10 highest scores
	}
	
}
