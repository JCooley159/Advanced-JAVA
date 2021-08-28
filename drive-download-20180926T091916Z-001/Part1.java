import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class: Part1
 * 
 * @author Dr. Johnson
 * @version 1.0 Course : ITEC 3150, Fall, 2015 Written: January 18, 2012
 * 
 * 
 *          This class creates the binary file used in the main part of homework
 *          2. It is a standalone program that reads in a text file from
 *          homework 1 and rewrites the courses as a binary file using
 *          ObjectOutputStream
 *
 */
public class Part1
{

    // actual CourseList data
    private ArrayList<Course> courseListItems = new ArrayList<Course>();

    /**
     * Method:printCourseListItems()
     * 
     * This method prints the courseList items contained in the courseListItems
     * Array list. It relies on the toString method of the various Course types
     * to print the items in a user friendly format.
]\     * 
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
     */
    public void readFile()
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

        // read one person at a time
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
     * Method:writeBinaryFile()
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

    /**
     * 
     * Method:main()
     * 
     * This method is the starting point of the program. It contains the initial
     * reading of items from the text file Course.txt and the writing of the
     * binary file
     * 
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        // create courseList by reading in from text file named courses.txt
        Part1 myCourseList = new Part1();

        myCourseList.readFile();

        // write out contents of courseList to a binary file named courses.dat
        myCourseList.writeFile();

    }

}
