package UserInterface;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class LoginPage extends Application{
	
	public void start(Stage stage) 
	{
	      Group root = new Group();
	      
	      userNameBox(root);
	      passwordBox(root);
	      signInButton(root, stage);
	      createAccountButton(root, stage);

	      Scene scene = new Scene(root, 700, 500);
	      stage.setTitle("Login");
	      stage.setScene(scene);
	      stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void signInButton(Group root, Stage stage)
	{
		Button button = new Button();
		button.setText("Sign In");
		button.setPrefSize(100, 50);
		button.setTranslateX(300);
		button.setTranslateY(250);
		
		button.setOnAction(e-> {
			System.out.println("Take username input and password input");
		});
		
		root.getChildren().add(button);
	}
	
	public void createAccountButton(Group root, Stage stage)
	{
		Button button = new Button();
		button.setText("Create Account");
		button.setPrefSize(100, 50);
		button.setTranslateX(300);
		button.setTranslateY(350);
		
		CreateAccountPage page = new CreateAccountPage();
		
		button.setOnAction(e-> {
			page.accountPage(stage);
		});
		
		root.getChildren().add(button);
	}
	
	public void userNameBox(Group root)
	{
		Label username = new Label("Username:");
		username.setTranslateX(240);
		username.setTranslateY(175);
		TextField textField = new TextField ();
		textField.setTranslateX(300);
		textField.setTranslateY(170);
		
		root.getChildren().addAll(username, textField);
	}
	
	public void passwordBox(Group root)
	{
		Label password = new Label("Password:");
		password.setTranslateX(240);
		password.setTranslateY(205);
		TextField textField = new TextField();
		textField.setTranslateX(300);
		textField.setTranslateY(200);
		
		root.getChildren().addAll(password, textField);
	}
/*
	public void createButton(Group root, Stage stage)
	{
	      Button button = new Button();
	      button.setText("Sign In");
	      button.setTranslateX(300);
	      button.setTranslateY(250);
	      
	      button.setOnAction(e-> {
	    	  newScreen(stage);
	      });
	      
	      root.getChildren().add(button);
	}
	
	public void newScreen(Stage stage)
	{
		Group group = new Group();
		Button newButton = new Button("tuttle");
		newButton.setTranslateX(20);
		newButton.setTranslateY(20);
		newButton.setOnAction(e-> System.out.println("I like Tuttles"));
		group.getChildren().add(newButton);
		
		Scene scene = new Scene(group, 500, 500);
		stage.setTitle("Titties");
		stage.setScene(scene);
		stage.show();
	}*/
}
