import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;


public class UserInterface extends Application {
	@Override
	public void start(Stage stage) 
	{
		try 
		{		
			BorderPane root = new BorderPane();
			    
			Scene scene = new Scene(root,400,400);
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public Rectangle makeSquare()
	{
		Rectangle rectangle = new Rectangle();
		
		rectangle.setX(20);
		rectangle.setY(20);
		rectangle.setWidth(20);
		rectangle.setHeight(20);
		return rectangle;
	}
	
	public void makePlayButton(BorderPane root)
	{
		Button button = new Button("Play");
		
		button.setLayoutX(0);
		button.setLayoutY(0);
		
		root.getChildren().add(button);
	}
}
