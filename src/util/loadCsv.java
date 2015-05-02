package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import entity.Book;
import entity.Dvd;
import repo.ItemRepo;

public class loadCsv
{
	public static ItemRepo load( ItemRepo itemsRepo )
	{
		String csvFile = "/home/felipe/workspace/Livraria2/src/util/dados.txt";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";
	 
		try {
	 
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
	}
}
