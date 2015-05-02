package entity;

public class Dvd extends Item
{
	private String genre;
	private String year;
	
	public Dvd( String name, String year, String genre, int stock )
	{
		this.setName( name );
		this.setGenre( genre );
		this.setYear( year );
		this.setStock( stock );
	}

	public String getGenre() 
	{
		return genre;
	}

	public void setGenre( String genre )
	{
		this.genre = genre;
	}
	
	public String getYear()
	{
		return year;
	}

	public void setYear( String year )
	{
		this.year = year;
	}

	public String toString()
	{
		StringBuilder result = new StringBuilder();
		
		result.append( super.toString() );
		result.append( String.format( "| %-20s", this.getGenre() ) );
		result.append( String.format( "| %-4s ", this.getYear() ) );
		result.append( String.format( "|%n" ) );
		
		return result.toString();
	}
}
