package UserInterface;

import java.util.ArrayList;

import SQL.SQLCalls;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class HomePage {
	
	//Home page of the game
	public void homePage(Stage stage, String user)
	{
		Group group = new Group();
		
		playButton(group, stage, user);
		triviaCreationButton(group, stage, user);
		highScoresButton(group, stage, user);
		settingsButton(group, stage, user);
		logOutButton(group, stage);
		image(group);
		triviaGameLabel(group);
		
		Scene scene = new Scene(group, 700, 500);
		scene.setFill(Color.LIGHTPINK);
		stage.setResizable(false);
		
		stage.setTitle("Home Page");
		stage.setScene(scene);
		stage.show();
	}
	
	//Play button to play the game
	public void playButton(Group group, Stage stage, String user)
	{
		Button playButton = new Button();
		playButton.relocate(20, 100);
		playButton.setPrefSize(200,50);
		playButton.setText("Play");
		playButton.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
		
		TriviaSelection triviaSelect = new TriviaSelection();
		
		playButton.setOnAction(e->{
			triviaSelect.selectTrivia(stage, user);
		});
		
		group.getChildren().addAll(playButton);
	}
	
	//Takes the user to the creation page
	public void triviaCreationButton(Group group, Stage stage, String user)
	{
		Button triviaButton = new Button();
		triviaButton.relocate(20, 160);
		triviaButton.setPrefSize(200,50);
		triviaButton.setText("Trivia Creation");
		triviaButton.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
		
		TriviaCreatePage triviaPage = new TriviaCreatePage();
		
		triviaButton.setOnAction(e->{
			triviaPage.createTrivia(stage, user);
		});
		
		group.getChildren().addAll(triviaButton);
	}
	
	//Takes the users to high scores page
	public void highScoresButton(Group group, Stage stage, String user)
	{
		Button scoresButton = new Button();
		scoresButton.relocate(20, 220);
		scoresButton.setPrefSize(200,50);
		scoresButton.setText("High Scores");
		scoresButton.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
		
		HighScoresPage page = new HighScoresPage();
		
		scoresButton.setOnAction(e-> {
			
		
			page.ScoresPage(stage, user);
		});
		
		group.getChildren().addAll(scoresButton);
	}
	
	//Takes the user to the settings page
	public void settingsButton(Group group, Stage stage, String user)
	{
		Button settingsButton = new Button();
		settingsButton.relocate(20, 280);
		settingsButton.setPrefSize(200,50);
		settingsButton.setText("Settings");
		settingsButton.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
		
		SettingsPage settings = new SettingsPage();
		
		settingsButton.setOnAction(e-> {
			settings.settingsPage(stage, user);
		});
		
		group.getChildren().addAll(settingsButton);
	}
	
	//takes the user to back to the login page
	public void logOutButton(Group group, Stage stage)
	{
		Button logOutButton = new Button();
		logOutButton.relocate(20, 340);
		logOutButton.setPrefSize(200,50);
		logOutButton.setText("Log Out");
		logOutButton.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
		
		LoginPage page = new LoginPage();
		logOutButton.setOnAction(e-> {
			page.start(stage);
		});
		
		group.getChildren().addAll(logOutButton);
	}
	
	//Creates the label for the game
	public void triviaGameLabel(Group group)
	{
		Label triviaGame = new Label("TRIVIA\nGAME");
		triviaGame.relocate(350, 30);
		triviaGame.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 50));
		triviaGame.setTextFill(Color.CORNFLOWERBLUE);
		triviaGame.setTextAlignment(TextAlignment.CENTER);
		
		group.getChildren().addAll(triviaGame);
	}
	
	//Creates the question mark
	public void image(Group group)
	{
		Image image = new Image("question_mark.png");
		ImageView imageView = new ImageView(image);
		imageView.setFitWidth(320);
		imageView.setFitHeight(320);
		imageView.relocate(300, 150);
		
		group.getChildren().addAll(imageView);
	}
	
	//Gets best scores 
	public void getBestScores()
	{
		//return a list of the top 10 highest scores
		ArrayList<Integer> scores = new ArrayList<Integer>();
		SQLCalls sql = new SQLCalls();
		
	}
}
