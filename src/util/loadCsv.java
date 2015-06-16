package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import list.HashTable;
import entity.Book;
import entity.Dvd;
import entity.Item;
import repo.ItemRepo;

public class loadCsv
{
	private static ItemRepo itemRepo;

	public static ItemRepo load( ItemRepo item )
	{
		try
		{
			itemRepo = item;
			
			// Scanner input = new Scanner( new File( "/Users/felipeumpierre/Documents/workspace/Livraria/src/util/dados.csv" ) );
			Scanner input = new Scanner( new File( "C:/Users/Felipe/workspace/Livraria/src/util/dados.txt" ) );
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
		
		String title = line.next();
		String isbn = line.next();
		
		HashTable<Item> hashTable = new HashTable<Item>();
		hashTable = itemRepo.addItemHash( isbn, new Book( title, isbn, 2 ) );
		
		Book book = (Book)hashTable.find( isbn );
		
		while( line.hasNext() )
		{
			book.addAuthor( line.next() );
			book.setDescription( book.getName() + " - " + book.getIsbn() );
		}
		
		hashTable.put( isbn, book );
		
		line.close();
	}
	
	private static void addDvd( String string )
	{
		Scanner line = new Scanner( string );
		line.useDelimiter( ";" );
		
		String name = line.hasNext() ? line.next() : null;
		String year = line.hasNext() ? line.next() : null;
		String genre = line.hasNext() ? line.next() : null;
		
		int id = itemRepo.addItem( new Dvd( name, year, genre, 1 ) );
		Dvd dvd = (Dvd)itemRepo.getItemById( id );
		
		dvd.setDescription( dvd.getName() + " (" + dvd.getYear() + ") - " + dvd.getGenre() );
		
		line.close();
	}
}
