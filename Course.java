
/**
 * Parent class for courses at Pretend University
 * 
 * @author Jeremy Cooley
 *
 */
public class Course
{
    private String category;
    private String name;
    private int crn;

    /**
     * @param category
     * @param name
     * @param crn
     */
    public Course(String category, String name, int crn)
    {
        super();
        this.category = category;
        this.name = name;
        this.crn = crn;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Course [category=" + category + ", name=" + name + ", crn="
                + crn + "]";
    }

    /**
     * @return the category
     */
    public String getCategory()
    {
        return category;
    }

    /**
     * @param category
     *            the category to set
     */
    public void setCategory(String category)
    {
        this.category = category;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the crn
     */
    public int getCrn()
    {
        return crn;
    }

    /**
     * @param crn
     *            the crn to set
     */
    public void setCrn(int crn)
    {
        this.crn = crn;
    }

 

}
