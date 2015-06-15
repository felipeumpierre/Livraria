package entity;

import java.util.ArrayList;

public class Book extends Item
{
	private String isbn;
	private ArrayList<String> authorArray = new ArrayList<String>();
	
	public Book( String name, String isbn, int stock )
	{
		this.setName( name );
		this.setIsbn( isbn );
		this.setStock( stock );
	}
	
	public void addAuthor( String author )
	{
		authorArray.add( author );
	}

	public String getIsbn() 
	{
		return isbn;
	}

	public void setIsbn( String isbn )
	{
		this.isbn = isbn;
	}

	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		
		result.append( super.toString() );
		result.append( String.format( "| %-6s ", this.getIsbn() ) );
		
		if( null != this.getDescription() )
		{
			result.append( String.format( "| %-40s ", this.getDescription() ) );
		}
		
		for( String a: authorArray )
		{
			result.append( String.format( "| %-6s ", a ) );
		}
		
		result.append( String.format( "|%n" ) );
		
		return result.toString();
	}
}
