import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Class: MainInterface
 * 
 * @author cjohns25
 * @version 1.0 Course : ITEC 3150, Fall, 2018 Written: August 18, 2018
 *
 *          Main GUI class - contains ListView and launches additional Stages as
 *          needed
 * 
 * 
 *
 */
public class MainInterface extends Application
{
    private CourseList myLibrary = new CourseList();

    /*
     * Start method indicates starting point of JavaFX program (non-Javadoc)
     * 
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // read in file and create library
        myLibrary.readFile();

        // display list of library items
        VBox mainPane = new VBox();
        Label mainLabel = new Label("Course List");

        mainPane.getChildren().add(mainLabel);
        ListView<Course> list = new ListView<Course>();
        ObservableList<Course> items = FXCollections
                .observableArrayList(myLibrary.getcourseListItems());
        list.setItems(items);

        mainPane.getChildren().add(list);

        // make list selectable and popup info on selected item in a separate
        // stage
        list.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<Course>()
                {

                    public void changed(
                            ObservableValue<? extends Course> observable,
                            Course oldValue, Course newValue)
                    {
                        // pop up detail stage of selected Course object
                        Stage newStage = null;
                        if (newValue.getCategory().equalsIgnoreCase("math"))
                        {
                            newStage = createMathStage(newValue);
                        }

                        else if (newValue.getCategory().equalsIgnoreCase(
                                "History"))
                        {
                            newStage = createHistoryStage(newValue);
                        } else
                        {

                            newStage = createEnglishStage(newValue);
                        }

                        newStage.show();
                    }
                });

        // Create a scene and place it in the stage
        Scene scene = new Scene(mainPane, 500, 200);
        primaryStage.setTitle("Course Library"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

    }

    /*
     * Method to create new Stage for a Book Course item
     * 
     * @param Course
     * 
     * @return Stage
     */
    private Stage createEnglishStage(Course m)
    {
        Stage s = new Stage();
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        English b = (English) m;
        // Place nodes in the pane
        pane.add(new Label("Name:"), 0, 0);
        pane.add(new Label(b.getName()), 1, 0);
        pane.add(new Label("ID:"), 0, 1);
        pane.add(new Label("" + b.getCrn()), 1, 1);
        pane.add(new Label("Format:"), 0, 2);
        pane.add(new Label(b.getFormat()), 1, 2);
        pane.add(new Label("Level:"), 0, 3);
        pane.add(new Label(b.getLevel()), 1, 3);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        s.setScene(scene);
        s.setTitle("English");
        return s;
    }

    /*
     * Method to create new Stage for a Music Course item
     * 
     * @param Course
     * 
     * @return Stage
     */
    private Stage createMathStage(Course m)
    {

        Stage s = new Stage();
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        Math b = (Math) m;
        // Place nodes in the pane
        pane.add(new Label("Name:"), 0, 0);
        pane.add(new Label(b.getName()), 1, 0);
        pane.add(new Label("ID:"), 0, 1);
        pane.add(new Label("" + b.getCrn()), 1, 1);
        pane.add(new Label("Format:"), 0, 2);
        pane.add(new Label(b.getFormat()), 1, 2);
        pane.add(new Label("STEM?:"), 0, 3);
        pane.add(new Label(b.isStem() + " "), 1, 3);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        s.setScene(scene);
        s.setTitle("Matg");
        return s;
    }

    /*
     * Method to create new Stage for a Video Course item
     * 
     * @param Course
     * 
     * @return Stage
     */
    private Stage createHistoryStage(Course m)
    {
        Stage s = new Stage();
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        History b = (History) m;
        // Place nodes in the pane
        pane.add(new Label("Name:"), 0, 0);
        pane.add(new Label(b.getName()), 1, 0);
        pane.add(new Label("ID:"), 0, 1);
        pane.add(new Label("" + b.getCrn()), 1, 1);
        pane.add(new Label("Format:"), 0, 2);
        pane.add(new Label(b.getFormat()), 1, 2);

        pane.add(new Label("Area E Eligible?:"), 0, 5);
        pane.add(new Label(b.isAreaEligible() + " "), 1, 5);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        s.setScene(scene);
        s.setTitle("History");
        return s;
    }

    /**
     * Main method
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        launch(args);

    }

}
