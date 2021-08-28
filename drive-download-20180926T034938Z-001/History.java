import java.io.Serializable;

/**
 * 
 */

/**
 * @author cjohns25
 *
 */
public class History extends Course  implements Serializable
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 222448369804107336L;
	private boolean areaEligible;
    private String format;

    /**
     * @param category
     * @param name
     * @param crn
     * @param areaEligible
     * @param format
     */
    public History(String category, String name, int crn, boolean areaEligible,
            String format)
    {
        super(category, name, crn);
        this.areaEligible = areaEligible;
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
        return "History [areaEligible=" + areaEligible + ", format=" + format
                + ", toString()=" + super.toString() + ", getCategory()="
                + getCategory() + ", getName()=" + getName() + ", getCrn()="
                + getCrn() + ", getClass()=" + getClass() + ", hashCode()="
                + hashCode() + "]";
    }

    /**
     * @return the areaEligible
     */
    public boolean isAreaEligible()
    {
        return areaEligible;
    }

    /**
     * @param areaEligible
     *            the areaEligible to set
     */
    public void setAreaEligible(boolean areaEligible)
    {
        this.areaEligible = areaEligible;
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
