import java.io.Serializable;

/**
 * @author cjohns25
 *
 */
public class Math extends Course implements Serializable
{

    /**
	 * 
	 */
	private static final long serialVersionUID = -1882588508146667274L;
	private boolean stem;
    private String format;

    /**
     * @param category
     * @param name
     * @param crn
     * @param stem
     * @param format
     */
    public Math(String category, String name, int crn, boolean stem,
            String format)
    {
        super(category, name, crn);
        this.stem = stem;
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
        return "Math [stem=" + stem + ", format=" + format + ", toString()="
                + super.toString() + ", getCategory()=" + getCategory()
                + ", getName()=" + getName() + ", getCrn()=" + getCrn()
                + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + "]";
    }

    /**
     * @return the stem
     */
    public boolean isStem()
    {
        return stem;
    }

    /**
     * @param stem
     *            the stem to set
     */
    public void setStem(boolean stem)
    {
        this.stem = stem;
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
