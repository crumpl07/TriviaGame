package UserInterface;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HomePage {
	
	public void homePage(Stage stage)
	{
		Group group = new Group();
		
		playButton(group);
		triviaCreationButton(group, stage);
		highScoresButton(group, stage);
		settingsButton(group, stage);
		triviaGameLabel(group);
		
		Scene scene = new Scene(group, 700, 500);
		stage.setTitle("Home Page");
		stage.setScene(scene);
		stage.show();
	}
	
	public void playButton(Group group)
	{
		Button playButton = new Button();
		playButton.setTranslateX(20);
		playButton.setTranslateY(50);
		playButton.setPrefSize(200,50);
		playButton.setText("Play");
		
		group.getChildren().addAll(playButton);
	}
	
	public void triviaCreationButton(Group group, Stage stage)
	{
		Button triviaButton = new Button();
		triviaButton.setTranslateX(20);
		triviaButton.setTranslateY(110);
		triviaButton.setPrefSize(200,50);
		triviaButton.setText("Trivia Creation");
		
		TriviaCreatePage triviaPage = new TriviaCreatePage();
		
		triviaButton.setOnAction(e->{
			triviaPage.createTrivia(stage);
		});
		
		group.getChildren().addAll(triviaButton);
	}
	
	public void highScoresButton(Group group, Stage stage)
	{
		Button scoresButton = new Button();
		scoresButton.setTranslateX(20);
		scoresButton.setTranslateY(170);
		scoresButton.setPrefSize(200,50);
		scoresButton.setText("High Scores");
		
		HighScoresPage page = new HighScoresPage();
		
		scoresButton.setOnAction(e-> {
			page.ScoresPage(stage);
		});
		
		group.getChildren().addAll(scoresButton);
	}
	
	public void settingsButton(Group group, Stage stage)
	{
		Button settingsButton = new Button();
		settingsButton.setTranslateX(20);
		settingsButton.setTranslateY(230);
		settingsButton.setPrefSize(200,50);
		settingsButton.setText("Settings");
		
		SettingsPage settings = new SettingsPage();
		
		settingsButton.setOnAction(e-> {
			settings.settingsPage(stage);
		});
		
		group.getChildren().addAll(settingsButton);
	}
	
	public void triviaGameLabel(Group group)
	{
		Label triviaGame = new Label("Trivia Game");
		triviaGame.setTranslateX(350);
		triviaGame.setTranslateY(200);
		
		group.getChildren().addAll(triviaGame);
	}
}
