package classe;

public class Dvd extends Item
{
	private String leftAlignFormat = "| %-12s | %-30s | %-4s | %-69s |%n";
	
    public Dvd( String title, int year, int stock )
    {
    	this.setTitle( title );
    	this.setYear( year );
    	this.setStock( stock );
    }
    
    @Override
    public String toString()
    {
    	System.out.printf( this.leftAlignFormat, "DVD", this.getTitle(), this.getYear(), "" );
    	
    	return "";
    }
}
