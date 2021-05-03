package UserInterface;

import java.util.ArrayList;

import SQL.SQLCalls;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class TriviaCreatePage {
	
	ArrayList<Question> questions = new ArrayList<Question>();
	TextField category = new TextField();
	TextField title = new TextField();
	
	public void createTrivia(Stage stage)
	{
		Group group = new Group();
		
		Label triviaCategory = new Label("Trivia Category: ");
		triviaCategory.relocate(110, 10);
		triviaCategory.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
		category.relocate(235, 10);
		category.setPrefWidth(400);
		category.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 10));
		
		Label triviaTitle = new Label("Trivia Title: ");
		triviaTitle.relocate(110, 35);
		triviaTitle.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
		title.relocate(235, 35);
		title.setPrefWidth(400);
		title.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 10));
		
		ScrollPane sp = new ScrollPane();
		VBox vb = new VBox(); 
		Button addBt = new Button("+");
		addBt.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
		addBt.relocate(620, 250);
		
		sp.relocate(100, 60);
		sp.setContent(vb);
		sp.setPrefSize(510, 375);
		
		questions.add(new Question());
		vb.getChildren().add(questions.get(questions.size()-1)); 
		
		addBt.setOnAction(e->{
			
			questions.add(new Question());
			vb.getChildren().add(questions.get(questions.size()-1)); 
		});
		
		group.getChildren().addAll(sp, addBt, triviaCategory, category, title, triviaTitle);
		
		submitButton(group);
		backButton(group, stage);
		
		Scene scene = new Scene(group, 700, 500);
		stage.setResizable(false);
		scene.setFill(Color.LIGHTSTEELBLUE);

		stage.setTitle("Trivia Creation");
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
	
	public void submitButton(Group group)
	{
		Button submitButton = new Button();
		int key = 0;
		
		submitButton.setText("Create Quiz");
		submitButton.relocate(270, 450);
		submitButton.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
		SQLCalls sql = new SQLCalls();
		
		
		submitButton.setOnAction(e->{
			//All the relevant Strings are in the Array List "questions"
			
			for(int i = 0; i < questions.size(); i++)
			{
				sql.createQuiz(sql.getHighestID("quiz")+1, category.getText(), title.getText());
				sql.createQuestion (sql.getHighestID("quiz"),
									questions.get(i).answer1Tf.getText(),
									questions.get(i).answer2Tf.getText(),
									questions.get(i).answer3Tf.getText(),
									questions.get(i).corrAnswerTf.getText(),
									questions.get(i).questionTf.getText());
			}
			System.out.println("Added Questions");
		});
		
		group.getChildren().addAll(submitButton);
	}
	
	public class Question extends Pane
	{
		
		public TextField questionTf = new TextField();
		public TextField answer1Tf = new TextField();
		public TextField answer2Tf = new TextField();
		public TextField answer3Tf = new TextField();
		public TextField corrAnswerTf = new TextField();
		
		public Question()
		{	
			Label questionL = new Label("Question:");
			Label answer1L = new Label("Incorrect Answer 1:");
			Label answer2L = new Label("Incorrect Answer 2:");
			Label answer3L = new Label("Incorrect Answer 3:");
			Label corrAnswerL = new Label("Correct Answer:");
			
			questionL.relocate(10, 10);
			answer1L.relocate(10, 40);
			answer2L.relocate(10, 70);
			answer3L.relocate(10, 100);
			corrAnswerL.relocate(40, 130);
			
			questionL.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
			answer1L.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
			answer2L.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
			answer3L.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
			corrAnswerL.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
			
			questionTf.relocate(90, 10);
			answer1Tf.relocate(170, 40);
			answer2Tf.relocate(170, 70);
			answer3Tf.relocate(170, 100);
			corrAnswerTf.relocate(170, 130);
			
			questionTf.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 10));
			answer1Tf.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 10));
			answer2Tf.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 10));
			answer3Tf.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 10));
			corrAnswerTf.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 10));
			
			questionTf.setPrefWidth(380);
			answer1Tf.setPrefWidth(300);
			answer2Tf.setPrefWidth(300);
			answer3Tf.setPrefWidth(300);
			corrAnswerTf.setPrefWidth(300);
			
			this.setStyle("-fx-border-color: black; -fx-border-style: solid; -fx-padding: 10");
			
			this.getChildren().addAll(questionL, answer1L, answer2L, answer3L, corrAnswerL,
									questionTf, answer1Tf, answer2Tf, answer3Tf, corrAnswerTf);
		}
	}
}
