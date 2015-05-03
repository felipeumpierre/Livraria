package ui;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

import list.DoubleLinkedList;
import list.DoubleLinkedListException;
import entity.*;
import repo.ItemRepo;
import util.Console;

public class ItemUI
{
	private ItemRepo item;
	
	Map<String, String> methods = new HashMap<String, String>();
	
	public ItemUI( ItemRepo item )
	{
		this.item = item;
		
		methods.put( "addbook", "addBook" );
		methods.put( "addeletronic", "addEletronic" );
		methods.put( "adddvd", "addDvd" );
	}
	
	public void run()
	{
		int opt = 0;
		
		do
		{
			System.out.println( "\n+--------------------------+" );
			System.out.println( String.format( "| %-24s |", "Menu Produtos" ) );
			System.out.println( "+--------------------------+" );
			System.out.println( String.format( "| %-24s |", "1- Adicionar produto" ) );
			System.out.println( String.format( "| %-24s |", "2- Listar produtos" ) );
			System.out.println( String.format( "| %-24s |", "3- Buscar produtos" ) );
			System.out.println( String.format( "| %-24s |", "0- Voltar" ) );
			System.out.println( "+--------------------------+" );
			
			opt = Console.scanInt( "Escolha uma opção: " );
			
			switch( opt )
			{
				case 1: categoryOption( "add" ); break;
				case 2: categoryOption( "list" ); break;
				case 3: categoryOption( "search" ); break;
				case 0: break;
				default: System.out.println( "\n- Opção inválida!" ); break;
			}
		}
		while( opt != 0 );
	}
	
	public void categoryOption( String type )
	{
		int opt = 0;
		
		do
		{
			System.out.println( "\nEscolha uma categoria." );
			System.out.println( "+--------------------------+" );
			System.out.println( String.format( "| %-24s |", "1- Livros" ) );
			System.out.println( String.format( "| %-24s |", "2- Eletrônicos" ) );
			System.out.println( String.format( "| %-24s |", "3- Dvds" ) );
			System.out.println( String.format( "| %-24s |", "0- Voltar" ) );
			System.out.println( "+--------------------------+" );
			
			opt = Console.scanInt( "Escolha uma opção: " );
			
			switch( opt )
			{
				case 1: 
					switch( type )
					{
						case "add": addBook(); break;
						case "list": list( "book" ); break;
						case "search": search( "book" ); break;
					}
					
					break;
				case 2: 
					switch( type )
					{
						case "add": addEletronic(); break;
						case "list": list( "eletronic" ); break;
						case "search": search( "eletronic" ); break;
					}
					
					break;
				case 3: 
					switch( type )
					{
						case "add": addDvd(); break;
						case "list": list( "dvd" ); break;
						case "search": search( "dvd" ); break;
					}
					
					break;
				case 0: break;
				default:
					System.out.println( "\n- Opção inválida!" );
					break;
			}
		}
		while( opt != 0 );
	}
	
	private void addBook()
	{
		System.out.println( "\n--- Adicionando novo livro ---\n" );
		
		boolean valid = false;
		
		int stock = 0;
		String isbn = "";		
		String name = Console.scanString( "Nome: " );
		
		/**
		 * validation of ISBN
		 */
		do
		{
			isbn = Console.scanString( "ISBN: " );
			
			if( null == isbn )
			{
				System.out.println( "\n- Você deve informar o ISBN.\n" );
			}
			else
			{
				valid = true;
			}
		}
		while( valid == false );
		
		/**
		 * change the value of valid that will be on the top TRUE to FALSE
		 */
		valid = false;
		
		/**
		 * validation of stock
		 */
		do
		{
			try
			{
				stock = Console.scanInt( "Estoque: " );
				
				valid = true;
			}
			catch( InputMismatchException format )
			{
				System.out.println( "\n- Você deve informar um número.\n" );
			}
		}
		while( valid == false );
		
		this.item.addItem( new Book( name, isbn, stock ) );
		
		System.out.println( "\nLivro " + name + " cadastrado com sucesso!" );		
		System.out.println( "\n--- Fim de cadastro de livro ---" );
		
		// return to the first menu of products
		run();
	}
	
	private void addEletronic()
	{
		System.out.println( "\n--- Adicionando novo eletrônico ---\n" );
		
		boolean valid = false;
		int stock = 0;
		String name = Console.scanString( "Nome: " );
		String brand = Console.scanString( "Marca: " );
		
		/**
		 * validation of stock
		 */
		do
		{
			try
			{
				stock = Console.scanInt( "Estoque: " );
				
				valid = true;
			}
			catch( InputMismatchException format )
			{
				System.out.println( "\n- Você deve informar um número.\n" );
			}
		}
		while( valid == false );
		
		this.item.addItem( new Eletronic( name, brand, stock ) );
		
		System.out.println( "\nEletrônico " + name + " cadastrado com sucesso!" );		
		System.out.println( "\n--- Fim de cadastro de eletrônico ---" );
		
		// return to the first menu of products
		run();
	}
	
	private void addDvd()
	{
		System.out.println( "\n--- Adicionando novo dvd ---\n" );
		
		boolean valid = false;
		int stock = 0;
		String name = Console.scanString( "Título: " );
		String genre = Console.scanString( "Gênero: " );
		String year = Console.scanString( "Ano: " );
		
		/**
		 * validation of stock
		 */
		do
		{
			try
			{
				stock = Console.scanInt( "Estoque: " );
				
				valid = true;
			}
			catch( InputMismatchException format )
			{
				System.out.println( "\n- Você deve informar um número.\n" );
			}
		}
		while( valid == false );
		
		this.item.addItem( new Dvd( name, genre, year, stock ) );
		
		System.out.println( "\nDvd " + name + " cadastrado com sucesso!" );		
		System.out.println( "\n--- Fim de cadastro de dvd ---" );
		
		// return to the first menu of products
		run();
	}

	private void list( String instance )
	{
		System.out.println( "\n--- Listar produtos ---\n" );	
		System.out.println( this.item.toString( instance ) );		
		System.out.println( "--- Fim da listagem de produtos ---" );
		
		// return to the first menu of products
		run();
	}
	
	private void search( String instance )
	{
		System.out.println( "\n--- Buscar produtos ---\n" );
		
		String keywords = "";
		
		if( "book" == instance )
		{
			keywords = "ISBN";
		}
		else if( "eletronic" == instance )
		{
			keywords = "Nome/Marca";
		}
		else if( "dvd" == instance )
		{
			keywords = "Título/Produtora";
		}
		
		String search = Console.scanString( "\nBuscar por (" + keywords + "): " );
		
		DoubleLinkedList<Item> resultSearch = this.item.searchFor( instance, search );
		
		if( null != resultSearch )
		{
			StringBuilder s = new StringBuilder();
			
			for( int i = 0; i < resultSearch.listSize(); i++ )
			{
				try
				{
					Item item = resultSearch.getElementAtPosition( i );
					
					s.append( item.toString() );
				}
				catch( DoubleLinkedListException d )
				{
					
				}
			}
			
			if( s.length() == 0 )
			{
				s.append( "\n- Nenhum resultado foi encontrado para a busca: " + search );
			}
			
			System.out.println( s.toString() );
		}
		
		System.out.println( "\n--- Fim da busca de produtos ---" );
		
		// return to the first menu of products
		run();
	}
}
