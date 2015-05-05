package ui;

import repo.*;
import util.Console;
import util.loadCsv;

public class main
{
	public static void main( String[] args )
	{
		init();
	}
	
	public static void init()
	{
		ClientRepo client = new ClientRepo();
		ItemRepo item = new ItemRepo();
		
		item = loadCsv.load( item );
		
		int opt = 0;
		
		do
		{
			System.out.println( "\n+--------------------------+" );
			System.out.println( String.format( "| %-24s |", "Menu Inicial" ) );
			System.out.println( "+--------------------------+" );
			System.out.println( String.format( "| %-24s |", "1- Menu Cliente" ) );
			System.out.println( String.format( "| %-24s |", "2- Menu Produtos" ) );
			System.out.println( String.format( "| %-24s |", "3- Menu Carrinho" ) );
			System.out.println( String.format( "| %-24s |", "0- Sair" ) );
			System.out.println( "+--------------------------+" );
			
			opt = Console.scanInt( "Escolha uma opção: " );
			
			switch( opt )
			{
				case 1: new ClientUI( client ).run(); break;
				case 2: new ItemUI( item ).run(); break;
				case 3: new CartUI( client, item ).run(); break;
				case 0: break;
				default: System.out.println( "\n- Opção inválida!" ); break;
			}
		}
		while( opt != 0 );		
	}
}
