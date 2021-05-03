package UserInterface;

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
	
	public void homePage(Stage stage)
	{
		Group group = new Group();
		
		playButton(group, stage);
		triviaCreationButton(group, stage);
		highScoresButton(group, stage);
		settingsButton(group, stage);
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
	
	public void playButton(Group group, Stage stage)
	{
		Button playButton = new Button();
		playButton.relocate(20, 100);
		playButton.setPrefSize(200,50);
		playButton.setText("Play");
		playButton.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
		
		TriviaSelection triviaSelect = new TriviaSelection();
		
		playButton.setOnAction(e->{
			triviaSelect.selectTrivia(stage);
		});
		
		group.getChildren().addAll(playButton);
	}
	
	public void triviaCreationButton(Group group, Stage stage)
	{
		Button triviaButton = new Button();
		triviaButton.relocate(20, 160);
		triviaButton.setPrefSize(200,50);
		triviaButton.setText("Trivia Creation");
		triviaButton.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
		
		TriviaCreatePage triviaPage = new TriviaCreatePage();
		
		triviaButton.setOnAction(e->{
			triviaPage.createTrivia(stage);
		});
		
		group.getChildren().addAll(triviaButton);
	}
	
	public void highScoresButton(Group group, Stage stage)
	{
		Button scoresButton = new Button();
		scoresButton.relocate(20, 220);
		scoresButton.setPrefSize(200,50);
		scoresButton.setText("High Scores");
		scoresButton.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
		
		HighScoresPage page = new HighScoresPage();
		
		scoresButton.setOnAction(e-> {
			page.ScoresPage(stage);
		});
		
		group.getChildren().addAll(scoresButton);
	}
	
	public void settingsButton(Group group, Stage stage)
	{
		Button settingsButton = new Button();
		settingsButton.relocate(20, 280);
		settingsButton.setPrefSize(200,50);
		settingsButton.setText("Settings");
		settingsButton.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
		
		SettingsPage settings = new SettingsPage();
		
		settingsButton.setOnAction(e-> {
			settings.settingsPage(stage);
		});
		
		group.getChildren().addAll(settingsButton);
	}
	
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
	
	public void triviaGameLabel(Group group)
	{
		Label triviaGame = new Label("TRIVIA\nGAME");
		triviaGame.relocate(350, 30);
		triviaGame.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 50));
		triviaGame.setTextFill(Color.CORNFLOWERBLUE);
		triviaGame.setTextAlignment(TextAlignment.CENTER);
		
		group.getChildren().addAll(triviaGame);
	}
	
	public void image(Group group)
	{
		Image image = new Image("question_mark.png");
		ImageView imageView = new ImageView(image);
		imageView.setFitWidth(320);
		imageView.setFitHeight(320);
		imageView.relocate(300, 150);
		
		group.getChildren().addAll(imageView);
	}
}
