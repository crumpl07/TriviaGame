package UserInterface;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
	
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	public void signInButton(Group root, Stage stage)
	{	
		Button button = new Button();
		button.setText("Sign In");
		button.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
		button.setPrefSize(100, 50);
		button.relocate(300, 300); 
		
		HomePage home = new HomePage();
		
		button.setOnAction(e-> {
		//	if() 
			{
				home.homePage(stage);
			}
		});
		
		root.getChildren().add(button);
	}
	
	public void createAccountButton(Group root, Stage stage)
	{
		Button button = new Button();
		button.setText("Create Account");
		button.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 12));
		button.setPrefSize(110, 50);
		button.relocate(10, 10);
				
		CreateAccountPage page = new CreateAccountPage();
		
		button.setOnAction(e-> {
			page.accountPage(stage);
		});
		
		root.getChildren().add(button);
	}
	
	public void userNameBox(Group root)
	{
		Label username = new Label("Username:");
		username.relocate(190, 170);
		username.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));

		this.username.relocate(300, 173);
		this.username.setFont(Font.font(15));
		
		root.getChildren().addAll(username, this.username);
	}
	
	public void passwordBox(Group root)
	{
		Label password = new Label("Password:");
		
		password.relocate(197, 218);
		password.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
		
		this.password.relocate(300, 220);
		this.password.setFont(Font.font(15));
		
		root.getChildren().addAll(password, this.password);
	}
	
	public void signInAction(String username, String password, Stage stage)
	{
		
	}
}
