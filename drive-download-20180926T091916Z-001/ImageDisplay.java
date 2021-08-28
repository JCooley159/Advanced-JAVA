

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
//import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;


/**Class: ImageDisplay
 * @author Jeremy Cooley
 * @version 1.0
 * Last Updated: September 7, 2018
 */
public class ImageDisplay extends Application {

	private Image image;
	private ImageView iView = new ImageView();
	
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		BorderPane top = new BorderPane();
		BorderPane border = new BorderPane();
		
		
		
		// Combo Box with List
		ObservableList<String> choices = 
				FXCollections.observableArrayList(
						"Load an Image",
						"Invert colors of Image",
						"Change colors");		
		ComboBox<String> cb = new ComboBox<String>(choices);
		cb.setValue("Load an Image");
		cb.setDisable(true);
		
		
		// Event handler for ComboBox
		
		
		
		// Create Top panel with List and TextField
		Label prompt = new Label("Please enter the value to change the color of the image");
		TextField textField = new TextField();
		top.setLeft(cb);
		top.setCenter(prompt);
		top.setRight(textField);
		
		
		
		
		
		border.setTop(top);
		
		
		
		// Add ImageView
		
		
		
		
		// Create Bottom panel
		BorderPane bottom = new BorderPane();
		
		
		// OK Button - old way
		Button okBttn = new Button("OK");
		okBttn.setOnAction(new EventHandler<ActionEvent>()
				{
					@Override
					public void handle(ActionEvent event)
					{
						// Loads the image
						String cbValue = (String) cb.getValue();
						if (cbValue.equalsIgnoreCase("Load an Image"))
						{
							String fileName = getFile(primaryStage);
							image = new Image(fileName);
							iView.setImage(image);
							border.setCenter(iView);
							primaryStage.setHeight(image.getHeight() + 200);
							primaryStage.setWidth(image.getWidth() + 50);
							cb.setDisable(false);
						} 
						
						
						// Inverts each of the colors of the image
						else if (cbValue.equalsIgnoreCase("Invert colors of Image"))
						{
							Image invertedImage = invertColors(image);
							iView.setImage(invertedImage);
						} 
						
						
						// Offsets each of the colors of the image
						else if (cbValue.equalsIgnoreCase("Change colors"))
						{
														
								try 
								{
									int offset = Integer.parseInt(textField.getText());
									Image offsettedImg = offsetImage(image, offset);
									iView.setImage(offsettedImg);
								} 
								catch(NumberFormatException nfe)
								{
									// System.out.println("What you entered was not a number.");
									
									// create new popup that is passed with the parent window and an OK or Exit button
									// Create a new Stage and title it
									Stage errorStage = new Stage();
									errorStage.setTitle("Error");
									
									// Create a new Pane and a new Scene, and put the Pane in the Scene
									BorderPane errorBorderPane = new BorderPane();
									BorderPane errorBottomPane = new BorderPane();
									Scene errorScene = new Scene(errorBorderPane, 400, 100);
									errorStage.setScene(errorScene);
									// Sets the Bottom Pane within the Border Pane
									errorBorderPane.setBottom(errorBottomPane);
									
									// Create the error message and exit button
									Label errorMsg = new Label("What you entered was not a number.");
									Button exitBttn = new Button("Exit");
									exitBttn.setOnAction(e ->
									{
										errorStage.close();
									});
									
									// Set the location of the message and button in the Pane
									errorBorderPane.setCenter(errorMsg);
									errorBottomPane.setCenter(exitBttn);
									
									errorStage.show();
									
								}
							
						}
						
						
					}
				});
		
		
		
		
		
		
		// Exit Button - lambda way
		Button exitBttn = new Button("Exit");
		exitBttn.setOnAction((event)->
		{
			primaryStage.close();
			Platform.exit();
		});
		
		
		
		
		
		bottom.setCenter(okBttn);
		bottom.setRight(exitBttn);
		
		border.setBottom(bottom);
		
		
		
		// Display Scene
		Scene scene = new Scene(border, 800, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	
	private String getFile(Stage mainStage)
	{
		FileChooser chooser = new FileChooser();
		String fileName = chooser.showOpenDialog(mainStage).toURI().toString();
		return fileName;
	}
	
	private Image invertColors(Image image)
	{
		WritableImage wi = new WritableImage((int)image.getWidth(), (int)image.getHeight());
		PixelWriter pw = wi.getPixelWriter();
		PixelReader pr = image.getPixelReader();
		
		for (int width = 0; width < image.getWidth(); width++)
		{
			for (int height = 0; height < image.getHeight(); height ++)
			{
				pw.setColor(width, height, pr.getColor(width,  height).invert());
			}
		}
		return wi;
	}
	
	private Image offsetImage(Image image, int offset)
	{
		WritableImage wi = new WritableImage((int)image.getWidth(), (int)image.getHeight());
		PixelWriter pw = wi.getPixelWriter();
		PixelReader pr = image.getPixelReader();
		
		for (int width = 0; width < image.getWidth(); width++)
		{
			for (int height = 0; height < image.getHeight(); height ++)
			{
				pw.setArgb(width, height, pr.getArgb(width, height) + offset);
			}
		}
		return wi;
	}
	
	
}
