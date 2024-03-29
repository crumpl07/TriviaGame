package UserInterface;
import SQL.SQLCalls;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


/*
 * This is the start of the application, upon start the user is brought to the login page.
 * Quizzes cannot be one question, they break the application
 */
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
	      scene.setFill(Color.LAVENDER);
	      stage.setResizable(false);

	      stage.setTitle("Login");
	      stage.setScene(scene);
	      stage.show();
	      
	      HomePage homepage = new HomePage();
	      
	      scene.setOnKeyReleased(e->{
	    	  if(e.getCode() == KeyCode.Q)
	    	  {
	    		  homepage.homePage(stage, "q");
	    	  }
	      });
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	//The sign in button 
	public void signInButton(Group root, Stage stage)
	{	
		Button button = new Button();
		button.setText("Sign In");
		button.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
		button.setPrefSize(100, 50);
		button.relocate(300, 300); 

		
		button.setOnAction(e-> {
		//	if() 
			{
				try {
					signInAction(username.getText(), password.getText(), stage);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		root.getChildren().add(button);
	}
	
	//Creates the account button
	public void createAccountButton(Group root, Stage stage)
	{
		Button button = new Button();
		button.setText("Create Account");
		button.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 12));
		button.setPrefSize(110, 50);
		button.relocate(10, 10);
		
		button.setOnAction(e-> {
			CreateAccountPage page = new CreateAccountPage();
			page.accountPage(stage);
			
		});
		
		root.getChildren().add(button);
	}
	
	//Creates the user name box
	public void userNameBox(Group root)
	{
		Label username = new Label("Username:");
		username.relocate(190, 170);
		username.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));

		this.username.relocate(300, 173);
		this.username.setFont(Font.font(15));
		
		root.getChildren().addAll(username, this.username);
	}
	
	//Creates the password box
	public void passwordBox(Group root)
	{
		Label password = new Label("Password:");
		
		password.relocate(197, 218);
		password.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
		
		this.password.relocate(300, 220);
		this.password.setFont(Font.font(15));
		
		root.getChildren().addAll(password, this.password);
	}
	
	//Creates the sign in action
	public void signInAction(String username, String password, Stage stage) throws Exception
	{
			HomePage home = new HomePage();
			SQLCalls sql = new SQLCalls();
			System.out.println("Username " + username + "\tPassword" + password);
			//Checks if the users name and password are correct before changing 
			try 
			{
				if(sql.getPassword(username) == null || sql.getUsername(password) == null)
				{
					System.out.println("Not found");
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("OOPSIES");
					alert.setContentText("Incorrect information!");
					alert.show();
				}
				else
				{
					home.homePage(stage, username);
				}
			}catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println("owo Inccorect Loign Info");
			}
			
	}
}
