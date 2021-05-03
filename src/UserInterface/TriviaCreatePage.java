package UserInterface;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class TriviaCreatePage {
	
	TextField category = new TextField();
	TextField question = new TextField();
	TextField question1 = new TextField();
	TextField question2 = new TextField();
	TextField question3 = new TextField();
	
	public void createTrivia(Stage stage)
	{
		Group group = new Group();
		
		triviaLabels(group);
		textBoxes(group);
		submitButton(group);
		backButton(group, stage);
		
		Scene scene = new Scene(group, 700, 500);
		stage.setResizable(false);

		stage.setTitle("Trivia Creation");
		stage.setScene(scene);
		stage.show();
	}
	
	public void triviaLabels(Group group)
	{
		Label triviaCategory = new Label("Trivia Category: ");
		triviaCategory.setTranslateX(20);
		triviaCategory.setTranslateY(20);
		
		Label question1 = new Label("Question 1: ");
		Label question2 = new Label("Question 2: ");
		Label question3 = new Label("Question 3: ");
		Label question4 = new Label("Question 4: ");
		
		question1.setTranslateX(20);
		question1.setTranslateY(100);
		question2.setTranslateX(20);
		question2.setTranslateY(130);
		question3.setTranslateX(20);
		question3.setTranslateY(160);
		question4.setTranslateX(20);
		question4.setTranslateY(190);
 		
		group.getChildren().addAll(triviaCategory, question1, question2, question3, question4);
	}
	
	public void textBoxes(Group group)
	{
		category.setTranslateX(120);
		category.setTranslateY(17);
		
		question.setTranslateX(100);
		question.setTranslateY(98);
		
		question1.setTranslateX(100);
		question1.setTranslateY(128);
		
		question2.setTranslateX(100);
		question2.setTranslateY(158);
		
		question3.setTranslateX(100);
		question3.setTranslateY(188);
		
		group.getChildren().addAll(category, question, question1, question2, question3);
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
	
	public void submitButton(Group group)
	{
		Button submitButton = new Button();
		
		submitButton.setText("Submit");
		submitButton.setTranslateX(120);
		submitButton.setTranslateY(220);
		
		group.getChildren().addAll(submitButton);
	}
}
