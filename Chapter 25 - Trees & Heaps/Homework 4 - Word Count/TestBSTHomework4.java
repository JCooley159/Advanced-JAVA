import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



/**Class: TestBSTHomework4
 * @author Cynthia Johnson, edited by Jeremy Cooley
 * @version 1.0
 * Course : ITEC 3150
 * Written: October 26, 2018
 *
 *
 * This class holds the fields, constructors, and methods to
 * create and traverse a binary tree
 */
public class TestBSTHomework4
{
	public static void main(String[] args) throws FileNotFoundException
	{
		
		// Create Scanner based on File
	    Scanner fileScanner = new Scanner(new File("CarlAndTheCottonGin.txt"));
	    




    	// Create a WordCount array
		ArrayList<WordCount> wordCountAL = new ArrayList<>();
		// Use any characters other than a-z or A-Z as delimiters
		fileScanner.useDelimiter("[^a-zA-Z]+");
		while (fileScanner.hasNext())
		{
				WordCount newWord = new WordCount( fileScanner.next().toLowerCase() );
 				wordCountAL.add(newWord);
				//////////////////////
		}



	    // Create a BST from the WordCount Array and put them
		// into the tree if they don't already exist yet
	    BST<?> tree = new BST<>(wordCountAL);




	    // print the WordCount tree in reverse order
        System.out.println("Reverse Order: ");
        tree.reverseOrder();
        fileScanner.close();
    }
}
