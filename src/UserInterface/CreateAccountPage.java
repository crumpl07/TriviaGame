package UserInterface;

import SQL.SQLCalls;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class CreateAccountPage {
	
	TextField password = new TextField();
	TextField username = new TextField();
	TextField reEnterField = new TextField();
	
	public void accountPage(Stage stage)
	{
		Group group = new Group();
		
		usernameBox(group);
		passwordBox(group);
		reEnterBox(group);
		createAccount(group, stage);
		backButton(group, stage);
		
		Scene scene = new Scene(group, 700, 500);
		stage.setResizable(false);

		stage.setTitle("Create Account");
		stage.setScene(scene);
		stage.show();
	}
	
	public void usernameBox(Group group)
	{
		Label username = new Label("Username:");
	
		username.relocate(190, 170);
		username.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
		

		this.username.relocate(300, 173);
		this.username.setFont(Font.font(15));
		
		group.getChildren().addAll(username, this.username);
	}
	
	public void passwordBox(Group group)
	{
		Label passwordLabel = new Label("Password:");
		
		passwordLabel.relocate(197, 218);
		passwordLabel.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
		
		password.relocate(300, 220);
		password.setFont(Font.font(15));
		
		group.getChildren().addAll(passwordLabel, password);
	}
	
	public void reEnterBox(Group group)
	{
		Label reEnterLabel = new Label("Re-enter Password:");
		
		reEnterLabel.relocate(101, 266);
		reEnterLabel.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
		

		reEnterField.relocate(300, 267);
		reEnterField.setFont(Font.font(15));
		
		group.getChildren().addAll(reEnterLabel, reEnterField);
	}
	
	public void createAccount(Group group, Stage stage)
	{
		Button button = new Button();
		button.setText("Create Account");
		button.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 12));
		button.setPrefSize(110, 50);
		button.relocate(330, 340);
		
		button.setOnAction(e-> {
			if(password.getText().equals(reEnterField.getText()))
			{
				try {
					createUser(password.getText(), username.getText(), stage);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		group.getChildren().add(button);
	}
	
	public void backButton(Group group, Stage stage)
	{
		Button button = new Button();
		button.setText("Back");
		button.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
		button.relocate(10, 10);
		LoginPage page = new LoginPage();
		
		button.setOnAction(e-> {
				page.start(stage);
		});
		
		group.getChildren().add(button);
	}
	
	public void createUser(String password, String username, Stage stage) throws Exception
	{
		SQLCalls sql = new SQLCalls();
		LoginPage page = new LoginPage();
		
		sql.createAcount(username, password);
		page.start(stage);
	}
	
}
