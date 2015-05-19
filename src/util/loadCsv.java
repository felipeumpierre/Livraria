package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import entity.Book;
import entity.Dvd;
import repo.ItemRepo;

public class loadCsv
{
	private static ItemRepo itemRepo;

	public static ItemRepo load( ItemRepo item )
	{
		try
		{
			itemRepo = item;
			
			Scanner input = new Scanner( new File( "/home/felipe/workspace/Livraria/src/util/dados.txt" ) );
			input.useDelimiter( ";" );
			
			while( input.hasNextLine() )
			{
				String line = input.next();
				
				if( line.equalsIgnoreCase( "livro" ) )
				{
					addBook( input.nextLine() );
				}
				else if( line.equalsIgnoreCase( "dvd" ) )
				{
					addDvd( input.nextLine() );
				}
			}
			
			input.close();
		}
		catch( FileNotFoundException e )
		{
			e.printStackTrace();
		}
		
		return itemRepo;
	}
	
	private static void addBook( String string )
	{
		Scanner line = new Scanner( string );
		line.useDelimiter( ";" );
		
		int id = itemRepo.addItem( new Book( line.next(), line.next(), 2 ) );
		Book book = (Book)itemRepo.getItemById( id );
		
		while( line.hasNext() )
		{
			book.addAuthor( line.next() );
			book.setDescription( book.getName() + " - " + book.getIsbn() );
		}
		
		line.close();
	}
	
	private static void addDvd( String string )
	{
		Scanner line = new Scanner( string );
		line.useDelimiter( ";" );
		
		int id = itemRepo.addItem( new Dvd( line.next(), line.next(), line.next(), 1 ) );
		Dvd dvd = (Dvd)itemRepo.getItemById( id );
		
		dvd.setDescription( dvd.getName() + " (" + dvd.getYear() + ") - " + dvd.getGenre() );
		
		line.close();
	}
}
