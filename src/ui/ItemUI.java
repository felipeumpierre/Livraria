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
			System.out.println( String.format( "| %-24s |", "4- Reordenar produtos" ) );
			System.out.println( String.format( "| %-24s |", "0- Voltar" ) );
			System.out.println( "+--------------------------+" );
			
			opt = Console.scanInt( "Escolha uma opcao: " );
			
			switch( opt )
			{
				case 1: categoryOption( "add" ); break;
				case 2: categoryOption( "list" ); break;
				case 3: categoryOption( "search" ); break;
				case 4: categoryOption( "reorder" ); break;
				case 0: break;
				default: System.out.println( "\n- Opcao invalida!" ); break;
			}
		}
		while( opt != 0 );
		
		main.init();
	}
	
	public void categoryOption( String type )
	{
		int opt = 0;
		
		do
		{
			System.out.println( "\nEscolha uma categoria." );
			System.out.println( "+--------------------------+" );
			
			// livros usa HASHTABLE
			// não pode ser ordenado
			if( type != "reorder" )
			{
				System.out.println( String.format( "| %-24s |", "1- Livros" ) );
			}
			
			System.out.println( String.format( "| %-24s |", "2- Eletronicos" ) );
			System.out.println( String.format( "| %-24s |", "3- Dvds" ) );
			System.out.println( String.format( "| %-24s |", "0- Voltar" ) );
			System.out.println( "+--------------------------+" );
			
			opt = Console.scanInt( "Escolha uma opcao: " );
			
			switch( opt )
			{
				case 1: 
					switch( type )
					{
						case "add": addBook(); break;
						case "list": list( "book" ); break;
						case "search": search( "book" ); break;
						case "reorder": reorder( "book" ); break;
						case "description": description( "book" ); break;
					}
					
					break;
				case 2: 
					switch( type )
					{
						case "add": addEletronic(); break;
						case "list": list( "eletronic" ); break;
						case "search": search( "eletronic" ); break;
						case "reorder": reorder( "eletronic" ); break;
						case "description": description( "eletronic" ); break;
					}
					
					break;
				case 3: 
					switch( type )
					{
						case "add": addDvd(); break;
						case "list": list( "dvd" ); break;
						case "search": search( "dvd" ); break;
						case "reorder": reorder( "dvd" ); break;
						case "description": description( "dvd" ); break;
					}
					
					break;
				case 0: 
					break;
				default:
					System.out.println( "\n- Opcao invalida!" );
					break;
			}
		}
		while( opt != 0 );
		
		run();
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
				System.out.println( "\n- Voce deve informar o ISBN.\n" );
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
				System.out.println( "\n- Voce deve informar um numero.\n" );
			}
		}
		while( valid == false );
		
		this.item.addItemHash( isbn, new Book( name, isbn, stock ) );
		
		System.out.println( "\nLivro " + name + " cadastrado com sucesso!" );		
		System.out.println( "\n--- Fim de cadastro de livro ---" );
		
		// return to the first menu of products
		run();
	}
	
	private void addEletronic()
	{
		System.out.println( "\n--- Adicionando novo eletronico ---\n" );
		
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
				System.out.println( "\n- Voce deve informar um numero.\n" );
			}
		}
		while( valid == false );
		
		this.item.addItem( new Eletronic( name, brand, stock ) );
		
		System.out.println( "\nEletrenico " + name + " cadastrado com sucesso!" );		
		System.out.println( "\n--- Fim de cadastro de eletronico ---" );
		
		// return to the first menu of products
		run();
	}
	
	private void addDvd()
	{
		System.out.println( "\n--- Adicionando novo dvd ---\n" );
		
		boolean valid = false;
		int stock = 0;
		String name = Console.scanString( "Titulo: " );
		String genre = Console.scanString( "Genero: " );
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
				System.out.println( "\n- Voce deve informar um numero.\n" );
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
	
	private void reorder( String instance )
	{
		System.out.println( "\n--- Reordenar produtos ---\n" );	
		
		this.item.sort();
		
		System.out.println( this.item.toString( instance ) );		
		System.out.println( "--- Fim da reordem de produtos ---" );
		
		// return to the first menu of products
		run();
	}
	
	private void search( String instance )
	{
		System.out.println( "\n--- Buscar produtos ---\n" );
		
		StringBuilder s = new StringBuilder();
		
		if( "book" != instance )
		{		
			DoubleLinkedList<Item> resultSearch = this.searchEngine( instance );
			
			if( null != resultSearch )
			{				
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
					s.append( "\n- Nenhum resultado foi encontrado" );
				}
			}
		}
		else
		{
			Item item = this.searchEngine();
			
			if( null != item )
			{
				s.append( item.toString() );
			}
			else
			{
				s.append( "\n- Nenhum resultado foi encontrado" );
			}
		}
		
		System.out.println( s.toString() );
		
		System.out.println( "\n--- Fim da busca de produtos ---" );
		
		// return to the first menu of products
		run();
	}
	
	private void description( String instance )
	{
		System.out.println( "\n--- Adição/Edição produtos ---\n" );
		
		DoubleLinkedList<Item> resultSearch = this.searchEngine( instance );
		
		if( null != resultSearch )
		{
			if( resultSearch.listSize() > 1 )
			{
				System.out.println( "\n- Sua busca retornou mais de um resultado. Por isso, não será possível adicionar/editar a descrição." );
			}
			else
			{
				try
				{
					System.out.println( "Item encontrado: " + resultSearch.getElementAtPosition( 0 ).getName() );
					
					String description = Console.scanString( "Informe a descricao: " );
					resultSearch.getElementAtPosition( 0 ).setDescription( description );
				}
				catch( DoubleLinkedListException d )
				{
					
				}
			}
		}
		
		System.out.println( "\n--- Fim da adição/edição de produtos ---" );
		
		// return to the first menu of products
		run();
	}
	
	private DoubleLinkedList<Item> searchEngine( String instance )
	{
		String keywords = "";
		
		if( "eletronic" == instance )
		{
			keywords = "Nome/Marca";
		}
		else if( "dvd" == instance )
		{
			keywords = "Titulo/Produtora";
		}
		
		String search = Console.scanString( "\nBuscar por (" + keywords + "): " );
		
		return this.item.searchFor( instance, search );
	}
	
	private Item searchEngine()
	{	
		String search = Console.scanString( "\nBuscar por (ISBN): " );
		
		return this.item.searchFromHashTable( search );
	}
}
