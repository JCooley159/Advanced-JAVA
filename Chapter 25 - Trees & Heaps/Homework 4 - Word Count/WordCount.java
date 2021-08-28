import java.lang.Comparable;

/**Class: WordCount
 * @author Jeremy Cooley
 * @version 1.0
 * Course : ITEC 3150
 * Written: October 26, 2018
 *
 *
 * This class – holds the fields for a String Word and an int Count
 */
public class WordCount implements Comparable<WordCount>
{


    private String word;
    private int count;

    /**Method: WordCount(String)
     *
     * This method – Constructs a new WordCount Object with a
     * given string and sets its count to 1.
     *
     * ONLY gets called if the word does not already exist in
     * the tree--i.e. in an if statement in TestBSTHomework4.java
     */
    public WordCount(String word)
    {
        this.word = word;
        this.count = 1;
    }



    public String getWord()
    {
        return word;
    }

    public void setWord(String word)
    {
        this.word = word;
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }





    public String toString()
    {
    	return getWord() + " is displayed " + getCount() + " times";
    }

    public String stringClass ()
    {
        return "WordCount";
    }


    /**
     * Compares this object with the specified object for order.  Returns a
     * negative or a positive integer as this object's string is lexicographically
     * before or after the specified object's string, respectively.
     *
     * @param wc
     * 		the object to be compared.
     * @return Returns a
     *      * negative or a positive integer as this object's string is lexicographically
     *      * before or after the specified object's string, respectively. Returns 0 if
     *        the strings are the same, to be handled by the test class.
     *
     *
     * @throws NullPointerException
     * 		if the specified object is null
     * @throws ClassCastException
     * 		if the specified object's type prevents it
     * 		from being compared to this object.
     */
    @Override
    public
    int compareTo(WordCount wc)
    {
	    int compVar = this.getWord().compareToIgnoreCase( wc.getWord() );
        if (compVar < 0)
        {
	        return -1;
        }
        else if (compVar > 0)
        {
        	return 1;
        }
        else
        {
            // it increments the current element's count
		    // only when this method detects a match in words
		    wc.setCount(wc.getCount() + 1);
            return 0;
        }
    }






}
