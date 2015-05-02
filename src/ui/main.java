package ui;

import repo.*;
import util.Console;
import util.loadCsv;

public class main
{
	public static void main( String[] args )
	{
		init();
				
		/*// Clientes
		client.addClient( new Client( "Felipe", "123456" ) );
		client.addClient( new Client( "Vivian", "123456" ) );
		//System.out.println( client.toString() );
		
		// Items
		item.addItem( new Book( "Livro #1", "A123", "Felipe", 2 ) );
		item.addItem( new Eletronic( "Lavadoura de Louças", "Brastemp", 1 ) );
		item.addItem( new Dvd( "Interstelar", "Warner", 2 ) );
		System.out.println( item.toString( "all" ) );
		
		// Carrinho
		CartRepo cart = new CartRepo();
		cart.addClient( client.getClientById( 1 ) );
		cart.addItem( item.getItemById( 3 ) );
		cart.addItem( item.getItemById( 2 ) );
		cart.addItem( item.getItemById( 1 ) );
		cart.addItem( item.getItemById( 4 ) );
		
		CartRepo cart2 = new CartRepo();
		cart2.addClient( client.getClientById( 2 ) );
		cart2.addItem( item.getItemById( 1 ) );
		cart2.addItem( item.getItemById( 2 ) );
		
		//System.out.println( cart.toString() );
		//System.out.println( cart2.toString() );
		
		// Search
		ArrayList<Item> search = item.searchFor( "dvd", "inter" );
		
		if( null != search )
		{
			StringBuilder s = new StringBuilder();
			
			for( Item i: search )
			{
				s.append( i.toString() );
			}
			
			//System.out.println( s.toString() );
		}*/
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
