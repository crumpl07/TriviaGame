package UserInterface;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateAccountPage {
	
	public void accountPage(Stage stage)
	{
		Group group = new Group();
		
		usernameBox(group);
		passwordBox(group);
		createAccount(group);
		backButton(group, stage);
		
		Scene scene = new Scene(group, 700, 500);
		stage.setTitle("Create Account");
		stage.setScene(scene);
		stage.show();
	}
	
	public void usernameBox(Group group)
	{
		Label username = new Label("Username:");
		username.setTranslateX(240);
		username.setTranslateY(175);
		
		TextField textField = new TextField ();
		textField.setTranslateX(300);
		textField.setTranslateY(170);
		
		group.getChildren().addAll(username, textField);
	}
	
	public void passwordBox(Group group)
	{
		Label password = new Label("Password:");
		password.setTranslateX(240);
		password.setTranslateY(205);
		
		TextField textField = new TextField();
		textField.setTranslateX(300);
		textField.setTranslateY(200);
		
		group.getChildren().addAll(password, textField);
	}
	
	public void createAccount(Group group)
	{
		Button button = new Button();
		button.setText("Create Account");
		button.setPrefSize(100, 50);
		button.setTranslateX(300);
		button.setTranslateY(250);
		
		button.setOnAction(e-> {
			System.out.println("Start Playing");
		});
		
		group.getChildren().add(button);
	}
	
	public void backButton(Group group, Stage stage)
	{
		Button button = new Button();
		button.setText("Back");
		LoginPage page = new LoginPage();
		
		button.setOnAction(e-> {
				page.start(stage);
		});
		
		group.getChildren().add(button);
		
	}
	
}
