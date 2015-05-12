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
			
			Scanner input = new Scanner( new File( "/home/felipe/workspace/Livraria2/src/util/dados.txt" ) );
			input.useDelimiter( ";" );
			
			while( input.nextLine() != null && input.hasNextLine() )
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
		
		while( line.hasNext() )
		{
			Book book = (Book)itemRepo.getItemById( id );
			book.addAuthor( line.next() );
		}
		
		line.close();
	}
	
	private static void addDvd( String string )
	{
		Scanner line = new Scanner( string );
		line.useDelimiter( ";" );
		
		itemRepo.addItem( new Dvd( line.next(), line.next(), line.next(), 1 ) );
		
		line.close();
	}
	
	/*public static ItemRepo load( ItemRepo itemsRepo )
	{
		String csvFile = "/home/felipe/workspace/Livraria2/src/util/dados.txt";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";
	 
		try
		{
			br = new BufferedReader( new FileReader( csvFile ) );
			
			while( ( line = br.readLine() ) != null )
			{
				String[] items = line.split( cvsSplitBy );
				
				try
				{
					if( items[ 0 ].equalsIgnoreCase( "livro" ) )
					{
						itemsRepo.addItem( new Book( items[ 1 ], items[ 2 ], 2 ) );
					}
					else if( items[ 0 ].equalsIgnoreCase( "dvd" ) )
					{
						itemsRepo.addItem( new Dvd( items[ 1 ], items[ 2 ], items[ 3 ], 1 ) );
					}
				}
				catch( Exception e )
				{
					System.out.println( "ERRO ao carregar o arquivo" );
				}
			}
		}
		catch( FileNotFoundException e )
		{
			e.printStackTrace();
		}
		catch( IOException e )
		{
			e.printStackTrace();
		} 
		finally
		{
			if( br != null )
			{
				try 
				{
					br.close();
				}
				catch( IOException e )
				{
					e.printStackTrace();
				}
			}
		}
		
		return itemsRepo;
	}*/
}
