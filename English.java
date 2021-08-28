import java.io.Serializable;

/**
 * 
 */

/**
 * @author cjohns25
 *
 */
public class English extends Course implements Serializable

{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1837427729073813469L;
	private String level;
    private String format;

    /**
     * @param category
     * @param name
     * @param crn
     * @param level
     * @param format
     */
    public English(String category, String name, int crn, String level,
            String format)
    {
        super(category, name, crn);
        this.level = level;
        this.format = format;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "English [level=" + level + ", format=" + format
                + ", toString()=" + super.toString() + ", getCategory()="
                + getCategory() + ", getName()=" + getName() + ", getCrn()="
                + getCrn() + ", getClass()=" + getClass() + ", hashCode()="
                + hashCode() + "]";
    }

    /**
     * @return the level
     */
    public String getLevel()
    {
        return level;
    }

    /**
     * @param level
     *            the level to set
     */
    public void setLevel(String level)
    {
        this.level = level;
    }

    /**
     * @return the format
     */
    public String getFormat()
    {
        return format;
    }

    /**
     * @param format
     *            the format to set
     */
    public void setFormat(String format)
    {
        this.format = format;
    }

}
