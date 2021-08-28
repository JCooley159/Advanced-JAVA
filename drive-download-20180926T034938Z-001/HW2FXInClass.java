import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 * Class: HW2FXInClass
 * 
 * @author Dr. Johnson, with edits from Jeremy Cooley
 * @version 1.0 Course : ITEC 3150, Fall, 2015 Written: January 18, 2012
 * 
 * 
 *          This class describes CourseList used to contain the
 *          Course item CourseList. It also contains the main method which
 *          starts the program.
 * 
 *          Purpose: � Methods and attributes needed to create a CourseList of
 *          Course class items. Print them, read them from a file,search for a
 *          particular id and add a new item.
 *
 */
public class HW2FXInClass 
//implements Application
{

    // actual CourseList data
    private ArrayList<Course> courseListItems = new ArrayList<Course>();
    private Integer courseCount;
    private Stage primaryStage = new Stage();

   

    /**
     * @return the courseListItems
     */
    public ArrayList<Course> getcourseListItems()
    {
        return courseListItems;
    }

    /**
     * Method:addItem()
     * 
     * This method adds the parameter m to the courseListItems array list
     * [Cooley - this addItem also increments the counter and sleeps the
     * thread for half a second so the GUI can visually update.]
     * 
     * @param m
     * @throws InterruptedException 
     * 
     */
    public void addItem(Course m) throws InterruptedException
    {
    	start(primaryStage);
        courseCount++;
        courseListItems.add(m);
        Thread.sleep(500);
    }

    public void start(Stage primaryStage) {
      // Create a scene and place a button in the scene
      BorderPane border = new BorderPane();
      String strCount = courseCount.toString();
      Label countLabel = new Label(strCount);
      border.setCenter(countLabel);
      Scene scene = new Scene(border, 200, 250);
      primaryStage.setTitle("Course Counter"); // Set the stage title
      primaryStage.setScene(scene); // Place the scene in the stage
      primaryStage.show(); // Display the stage
      primaryStage.show();

      
    }


    /**
     * Method:readFile()
     * 
     * This method reads in file named courses.txt and populates the
     * courseListItems arrayList
     * @throws InterruptedException 
     * 
     */
    public void readFile() throws InterruptedException
    {
        // open text file
        File courseFile = new File("courses.txt");
        // open a Scanner to read data from File
        Scanner courseReader = null;
        try
        {
            courseReader = new Scanner(courseFile);
        } catch (FileNotFoundException e)
        {

            System.out
                    .println("No courseList Course found- courseList is empty");

        }


       
        // read one course at a time & determine which subject it is
        // before creating an instance of the course and adding it to 
        // the list
        while (courseReader != null && courseReader.hasNext())
        {

            String category = courseReader.nextLine();
            String name = courseReader.nextLine();
            String crnString = courseReader.nextLine();
            int crn = Integer.parseInt(crnString);

            if (category.equalsIgnoreCase("English"))
            {
                String level = courseReader.nextLine();

                String format = courseReader.nextLine();
                English tp = new English(category, name, crn, level, format);
                addItem(tp);

            } else if (category.equalsIgnoreCase("Math"))
            {
                String temp = courseReader.nextLine();
                boolean stem = Boolean.parseBoolean(temp);

                String format = courseReader.nextLine();

                Math tp = new Math(category, name, crn, stem, format);
                addItem(tp);

            } else if (category.equalsIgnoreCase("History"))
            {
                String temp = courseReader.nextLine();
                boolean areaEligible = Boolean.parseBoolean(temp);
                String format = courseReader.nextLine();
                History tp = new History(category, name, crn, areaEligible,
                        format);
                addItem(tp);
            } else
            {
                System.out.println("Unknown Course type " + category);
            }

        }

    }

    /**
     * Method:writeObjectFile()
     * 
     * This method writes file named courses.txt with information from arrayList
     * @throws IOException 
     * 
     */
    public void writeObjectFile() throws IOException
    {
        ObjectOutputStream output = null;
        
        
        // open file for writing
        try
        {
            output = new ObjectOutputStream(new FileOutputStream("coursesObjOutput.dat"));
        } catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // write contents of each courseList item to file
        for (Course c : getcourseListItems())
        {
            output.writeObject(c);
        }
        output.close();

    }

    /**
     * 
     * Method:main()
     * 
     * This method is the starting point of the program. It contains the initial
     * reading of items from the text file Course.txt and a menu for allowing
     * user to choose various tasks.
     * 
     * 
     * @param args
     * @throws IOException 
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws IOException, InterruptedException
    {
        // create courseList by reading in from text file named media.txt
        CourseList myCourseList = new CourseList();

        myCourseList.courseCount = 0;
        myCourseList.readFile();
        myCourseList.writeObjectFile();

    }

}
