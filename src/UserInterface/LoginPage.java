package UserInterface;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginPage extends Application{
	
	TextField username = new TextField();
	TextField password = new TextField();
	
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
		String password, username;
		
		Button button = new Button();
		button.setText("Sign In");
		button.setPrefSize(100, 50);
		button.setTranslateX(300);
		button.setTranslateY(250);
		
		HomePage home = new HomePage();
		
		button.setOnAction(e-> {
			home.homePage(stage);
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

		this.username.setTranslateX(300);
		this.username.setTranslateY(170);
		
		root.getChildren().addAll(username, this.username);
	}
	
	public void passwordBox(Group root)
	{
		Label password = new Label("Password:");
		password.setTranslateX(240);
		password.setTranslateY(205);
		
		this.password.setTranslateX(300);
		this.password.setTranslateY(200);
		
		root.getChildren().addAll(password, this.password);
	}
}
