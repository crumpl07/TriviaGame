package UserInterface;
import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

import SQL.Questions;
import SQL.SQLCalls;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class TriviaPlay {
	
	ArrayList<Questions> questions;
	int index = 0;
	int score = 0;
	
	public void triviaPlayPage(Stage stage, String title)
	{
		SQLCalls sql = new SQLCalls();

		int id = 0;
		try {
			id = sql.getQuizID(title);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		questions = sql.getQuestions(id);
		
		Group group = new Group();
		
		Label titles = new Label(title);
		
		Label question = new Label(questions.get(index).question);
		Label answer1 = new Label(questions.get(index).incorrectAnswer1);
		Label answer2 = new Label(questions.get(index).incorrectAnswer2);
		Label answer3 = new Label(questions.get(index).incorrectAnswer3);
		Label correctAnswer = new Label(questions.get(index).answer);
		
		ToggleGroup tg = new ToggleGroup();
		
		Button back = new Button();
		
		RadioButton answer1rb = new RadioButton();
		answer1rb.setToggleGroup(tg);
		RadioButton answer2rb = new RadioButton();
		answer2rb.setToggleGroup(tg);
		RadioButton answer3rb = new RadioButton();
		answer3rb.setToggleGroup(tg);
		RadioButton correctAnswerrb = new RadioButton();
		correctAnswerrb.setToggleGroup(tg);
		
		Button nextb = new Button("Next");
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < 4; i++)
			list.add(30*i);
		
		nextb.setOnAction(e->{
			if(answer1rb.isSelected() || answer2rb.isSelected() || 
					answer3rb.isSelected() || correctAnswerrb.isSelected())
			{
				System.out.println(answer1rb.isSelected()+","+ answer2rb.isSelected() +","+ 
					answer3rb.isSelected() +","+ correctAnswerrb.isSelected());
				if(answer3rb.isSelected())
				{
					score++;
					System.out.println("Hello there");
				}
				index++;
				Collections.shuffle(list);
				answer1.relocate(350,200+list.get(0));
				answer2.relocate(350,200+list.get(1));
				answer3.relocate(350,200+list.get(2));
				correctAnswer.relocate(350,200+list.get(3));
				
				answer1rb.relocate(300,200+list.get(0));
				answer2rb.relocate(300,200+list.get(1));
				answer3rb.relocate(300,200+list.get(2));
				correctAnswerrb.relocate(300,200+list.get(3));
				
				question.setText(questions.get(index).question);
				answer1.setText(questions.get(index).incorrectAnswer1);
				answer2.setText(questions.get(index).incorrectAnswer2);
				answer3.setText(questions.get(index).incorrectAnswer3);
				correctAnswer.setText(questions.get(index).answer);
				answer1rb.setSelected(false);
				answer2rb.setSelected(false);
				answer3rb.setSelected(false);
				correctAnswerrb.setSelected(false);
				
				if(index == questions.size() - 1)
				{
					nextb.setText("Submit");
					nextb.setOnAction(a->{
						
						if(answer3rb.isSelected())
						{
							score++;
						}
						Alert alert = new Alert(Alert.AlertType.INFORMATION);
						alert.setTitle("Submitted Quiz");
						alert.setContentText("Your score is " + score);
						alert.show();
						
					});
				}
			}
		});
		
		Collections.shuffle(list);
		
		titles.relocate(350,100);
		question.relocate(350,120);
		answer1.relocate(350,200+list.get(0));
		answer2.relocate(350,200+list.get(1));
		answer3.relocate(350,200+list.get(2));
		correctAnswer.relocate(350,200+list.get(3));
		
		answer1rb.relocate(300,200+list.get(0));
		answer2rb.relocate(300,200+list.get(1));
		answer3rb.relocate(300,200+list.get(2));
		correctAnswerrb.relocate(300,200+list.get(3));
		nextb.relocate(400, 400);
		
		
		group.getChildren().addAll(titles, question, answer1, answer2, answer3, correctAnswer, answer1rb, answer2rb,
				answer3rb, correctAnswerrb, nextb);
		
		Scene scene = new Scene(group, 700, 500);
		stage.setResizable(false);
		
		stage.setTitle("Play");
		stage.setScene(scene);
		stage.show();
	}
}
