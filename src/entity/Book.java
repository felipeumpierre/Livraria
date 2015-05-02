package entity;

public class Book extends Item
{
	private String isbn, author;
	
	public Book( String name, String isbn, int stock )
	{
		this.setName( name );
		this.setIsbn( isbn );
		this.setStock( stock );
	}

	public String getIsbn() 
	{
		return isbn;
	}

	public void setIsbn( String isbn )
	{
		this.isbn = isbn;
	}
	
	public String getAuthor() 
	{
		return author;
	}

	public void setAuthor( String author ) 
	{
		this.author = author;
	}

	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		
		result.append( super.toString() );
		result.append( String.format( "| %-6s ", this.getIsbn() ) );
		result.append( String.format( "|%n" ) );
		
		return result.toString();
	}
}
