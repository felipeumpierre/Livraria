package classe;

public class Eletronico extends Item
{
    private int voltage;
    private String leftAlignFormat = "| %-12s | %-30s | %-4s | %-6s | %-60s |%n";
    
    public Eletronico( String title, int year, int voltage, int stock )
    {
    	this.setTitle( title );
    	this.setYear( year );
    	this.setVoltage( voltage );
    	this.setStock( stock );
    }

	public int getVoltage()
	{
		return voltage;
	}

	public void setVoltage( int voltage )
	{
		this.voltage = voltage;
	}
    
    public String toString()
    {
    	System.out.printf( leftAlignFormat, "Eletrônico", this.getTitle(), this.getYear(), this.getVoltage(), "" );
    	
    	return "";
    }
}
