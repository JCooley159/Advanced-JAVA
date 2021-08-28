//package JavaFX;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MyFirstJavaFX extends Application {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);

	}
	
	public void start(Stage primaryStage) throws Exception {
		
		BorderPane bp = new BorderPane();
		
		
		
		Button btnOK = new Button("OK");
		btnOK.setOnAction(new EventHandler<ActionEvent>() 
		{
			
			@Override
			public void handle(ActionEvent event) 
			{
				Stage stage = new Stage();
				stage.setTitle("Second stage");
				stage.setScene(new Scene(new Button("New Stage"), 100,100));
				stage.show();
			}
			
		});
			
		
		
		Button btnExit = new Button("Exit");
		btnExit.setOnAction((event)->
		{
			primaryStage.close();
			Platform.exit();
		});
		
		
		bp.setLeft(btnOK);
		bp.setCenter(btnExit);
		Scene scene = new Scene(bp, 200, 250);
		primaryStage.setScene(scene);
		primaryStage.show();
			
	}

	

	
	
}
