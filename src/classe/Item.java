package classe;

public class Item
{
    private int year;
    private String title;
    private int stock;

    /**
     * Get title
     *
     * @return String
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Set title
     *
     * @param title String
     */
    public void setTitle( String title )
    {
        this.title = title;
    }

    /**
     * Get year
     *
     * @return int
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Set year
     *
     * @param year int
     */
    public void setYear( int year )
    {
        this.year = year;
    }

	public int getStock()
	{
		return stock;
	}

	public void setStock( int stock )
	{
		this.stock = stock;
	}    
}
