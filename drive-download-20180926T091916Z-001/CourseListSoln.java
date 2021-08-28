import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Class: CourseList
 * 
 * @author Dr. Johnson
 * @version 1.0 Course : ITEC 3150, Fall, 2015 Written: January 18, 2012
 * 
 * 
 *          This class � This class describes CourseList used to contain the
 *          Course item CourseList. It also contains the main method which
 *          starts the program.
 * 
 *          Purpose: � Methods and attributes needed to create a CourseList of
 *          Course class items. Print them, read them from a file,search for a
 *          particular id and add a new item.
 *
 */
public class CourseListSoln
{

    // actual CourseList data
    private ArrayList<Course> courseListItems = new ArrayList<Course>();

    /**
     * Method:printCourseListItems()
     * 
     * This method prints the courseList items contained in the courseListItems
     * Array list. It relies on the toString method of the various Course types
     * to print the items in a user friendly format.
     * 
     * 
     */
    public void printCourseListItems()
    {
        for (int i = 0; i < courseListItems.size(); i++)
        {
            Course temp = courseListItems.get(i);
            System.out.println(temp);
        }

    }

    /**
     * Method:searchById()
     * 
     * This method looks at each item in the courseListItems array list and if
     * its idNumber attribute matches the input parameter id, that item is
     * returned to the caller. It returns null if item is not found.
     * 
     * @param name
     * 
     * @return Course
     * 
     */
    public Course searchByName(String name)
    {
        Course item = null;
        for (Course temp : courseListItems)
        {
            if (temp.getName().equalsIgnoreCase(name))
            {
                item = temp;
            }

        }
        return item;
    }

    /**
     * Getter method for the arrayList courseListItems
     * 
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
     * 
     * @param m
     * 
     */
    public void addItem(Course m)
    {
        courseListItems.add(m);
    }

    /**
     * Method:removeItem()
     * 
     * This method removes the item with id from the array list
     * 
     * @param m
     * 
     */
    public void removeItem(String name)
    {
        Course g = this.searchByName(name);
        if (g != null)
        {
            courseListItems.remove(g);
        }
    }

    /**
     * Method:readFile()
     * 
     * This method reads in file named courses.txt and populates the
     * courseListItems arrayList
     * 
     * @throws IOException
     * 
     */
    public void readFile() throws IOException
    {
        // open text file
        ObjectInputStream courseReader = null;
        try
        {
            courseReader = new ObjectInputStream(new FileInputStream(
                    "courses.dat"));
        } catch (FileNotFoundException e)
        {

            System.out
                    .println("No courseList Course found- courseList is empty");

        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try
        {
            // read one course at a time
            while (true)
            {

                Course c = (Course) courseReader.readObject();
                addItem(c);

            }
        } catch (EOFException e)
        {
            // do nothing
        } catch (ClassNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * Method:writeFile()
     * 
     * This method writes file named courses.txt with information from arrayList
     * 
     */
    public void writeFile()
    {
        ObjectOutputStream out = null;
        // open file for writing
        try
        {
            out = new ObjectOutputStream(new FileOutputStream("courses.dat"));
        } catch (FileNotFoundException e)
        {

            e.printStackTrace();
        } catch (IOException e)
        {

            e.printStackTrace();
        }

        // write contents of each courseList item to file
        for (Course g : getcourseListItems())
        {
            try
            {
                out.writeObject(g);
            } catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        try
        {
            out.close();
        } catch (IOException e)
        {

            e.printStackTrace();
        }
    }

}
