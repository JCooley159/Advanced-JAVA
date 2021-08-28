
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MyJavaFX extends Application
{
	public void start(Stage primaryStage)
	{
		Button btnOK = new Button("OK");
		btnOK.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                Stage stage = new Stage();
                stage.setTitle("Second stage");
                stage.setScene(new Scene(new Button("New Stage"), 100,100));
                stage.show();                
            }
		    
		});
		Scene scene = new Scene(btnOK, 200, 250);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args)
	{
		Application.launch(args);
	}

}
