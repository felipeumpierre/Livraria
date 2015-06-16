package repo;

import list.DoubleLinkedList;
import list.DoubleLinkedListException;
import list.DoubleLinkedListSort;
import list.HashTable;

import java.util.HashMap;
import java.util.Map;

import entity.Book;
import entity.Dvd;
import entity.Eletronic;
import entity.Item;

public class ItemRepo
{
	Map<String, String> header = new HashMap<String, String>();
	Map<String, String> divisors = new HashMap<String, String>();
	Map<String, String> none = new HashMap<String, String>();
	
	private DoubleLinkedList<Item> items;
	private HashTable<Item> hashTable;
	private int id = 1;
	
	public ItemRepo()
	{
		items = new DoubleLinkedList<Item>();
		hashTable = new HashTable<Item>();
		
		header.put( "item", String.format( "| %-2s | %-21s", "#", "Item" ) );
		header.put( "book", String.format( "| %-6s | %-70s %n", "ISBN", "Mais informaçoes" ) );
		header.put( "eletronic", String.format( "| %-15s |%n", "Marca" ) );
		header.put( "dvd", String.format( "| %-19s | %-4s |%n", "Genero", "Ano" ) );
		
		divisors.put( "item", String.format( "+------+-----------------------------------" ) );
		divisors.put( "book", String.format( "+---------------+------------------------%n" ) );
		divisors.put( "eletronic", String.format( "+-----------------+%n" ) );
		divisors.put( "dvd", String.format( "+---------------------+------+%n" ) );
		
		none.put( "book", String.format( "| %-34s |%n", "Nenhum livro foi encontrado" ) );
		none.put( "eletronic", String.format( "| %-44s |%n", "Nenhum eletronico foi encontrado" ) );
		none.put( "dvd", String.format( "| %-54s |%n", "Nenhum dvd foi encontrado" ) );
		
		populate();
	}
	
	public int addItem( Item item )
	{
		if( null != item )
		{
			item.setId( this.id );
			
			try
			{
				items.insertFirst( item );
			}
			catch( DoubleLinkedListException d )
			{
				
			}
			
			return this.id++;
		}
		
		return 0;
	}

	/**
	 * Apenas para Book
	 * 
	 * @param String isbn
	 * @param Item item
	 * @return HashTable<Item>
	 */
	public HashTable<Item> addItemHash( String isbn, Item item )
	{
		if( null != item )
		{
			item.setId( this.id );

			hashTable.put( isbn, item );
			
			this.id++;
			
			return hashTable;
		}
		
		return null;
	}

	public HashTable<Item> hashTable()
	{
		return this.hashTable;
	}
	
	public Item getItemById( int id )
	{
		if( id > 0 )
		{
			for( int i = 0; i < items.listSize(); i++ )
			{
				try
				{
					Item item = items.getElementAtPosition( i );
					
					if( item.getId() == id )
					{
						return item;
					}
				}
				catch( DoubleLinkedListException d )
				{
					return null;
				}
			}
		}

		return null;
	}
	
	public Item getItem( int index )
	{
		try
		{
			return items.getElementAtPosition( index );
		}
		catch( DoubleLinkedListException d )
		{
			return null;
		}
	}
	
	public void removeItem( int index )
	{
		try
		{
			items.deleteElementAtPosition( index );
		}
		catch( DoubleLinkedListException d )
		{
			
		}
	}
	
	public DoubleLinkedList<Item> searchFor( String instance, String search )
	{
		DoubleLinkedList<Item> searchResult = new DoubleLinkedList<Item>();
		
		for( int i = 0; i < items.listSize(); i++ )
		{
			try
			{
				Item item = items.getElementAtPosition( i );
				
				if( item instanceof Book && instance.equalsIgnoreCase( "book" ) )
				{
					Book book = (Book)item;
					
					if( book.getIsbn().equalsIgnoreCase( search ) )
					{
						searchResult.insertFirst( book );
					}
				}
				else if( item instanceof Eletronic && instance.equalsIgnoreCase( "eletronic" ) )
				{
					Eletronic eletronic = (Eletronic)item;
					
					/**
					 * Change the case of the Name and the search key
					 * put the both in lowercase.
					 */
					if( eletronic.getName().toLowerCase().contains( search.toLowerCase() ) || eletronic.getBrand().toLowerCase().contains( search.toLowerCase() ) )
					{
						searchResult.insertFirst( eletronic );
					}
				}
				else if( item instanceof Dvd && instance.equalsIgnoreCase( "dvd" ) )
				{
					Dvd dvd = (Dvd)item;
					
					/**
					 * Change the case of the Name and the search key
					 * put the both in lowercase.
					 */
					if( dvd.getName().toLowerCase().contains( search.toLowerCase() ) || dvd.getGenre().toLowerCase().contains( search.toLowerCase() ) )
					{
						searchResult.insertFirst( dvd );
					}
				}
			}
			catch( DoubleLinkedListException d )
			{
				
			}
		}
		
		return searchResult;
	}

	public Item searchFromHashTable( String search )
	{
		Item item = this.hashTable.find( search );
		
		if( item instanceof Item )
		{
			return item;
		}
		
		return null;
	}
	
	public DoubleLinkedList<Item> sort()
	{
		this.items = DoubleLinkedListSort.sort( this.items );
		
		return this.items;
	}
	
	public String toString( String type )
	{	
		StringBuilder products = new StringBuilder();
		
		StringBuilder book = new StringBuilder();
		StringBuilder eletronic = new StringBuilder();
		StringBuilder dvd = new StringBuilder();
		
		StringBuilder _book = new StringBuilder();
		StringBuilder _eletronic = new StringBuilder();
		StringBuilder _dvd = new StringBuilder();
		
		book.append( generateHeaderTable( "book" ) );
		eletronic.append( generateHeaderTable( "eletronic" ) );
		dvd.append( generateHeaderTable( "dvd" ) );
		
		HashTable<Item> hash = this.hashTable;
		
		for( int i = 0; i < hash.size(); i++ )
		{
			Book bookHash = (Book) hash.find( i );
			
			if( bookHash instanceof Book )
			{
				_book.append( bookHash.toString() );
			}
		}
		
		for( int i = 0; i < items.listSize(); i++ )
		{
			try
			{
				Item item = items.getElementAtPosition( i );
				
				if( item instanceof Eletronic )
				{
					_eletronic.append( item.toString() );
				}
				else if( item instanceof Dvd )
				{
					_dvd.append( item.toString() );
				}
			}
			catch( DoubleLinkedListException d )
			{
				
			}
		}
		
		book.append( generateTable( _book, "book" ) );
		eletronic.append( generateTable( _eletronic, "eletronic" ) );
		dvd.append( generateTable( _dvd, "dvd" ) );
		
		switch( type )
		{
			case "book": products.append( book ); break;
			case "eletronic": products.append( eletronic ); break;
			case "dvd": products.append( dvd ); break;
			default: 
				products.append( book + "\n" + eletronic + "\n" + dvd );
				break;
		}
		
		return products.toString();
	}
	
	private StringBuilder generateHeaderTable( String item )
	{		
		StringBuilder head = new StringBuilder();
		
		head.append( divisors.get( "item" ) + divisors.get( item ) );
		head.append( header.get( "item" ) + header.get( item ) );
		head.append( divisors.get( "item" ) + divisors.get( item ) );
		
		return head;
	}
	
	private StringBuilder generateTable( StringBuilder sb, String item )
	{
		StringBuilder table = new StringBuilder();
		
		if( sb.length() > 0 )
		{
			table.append( sb );
		}
		else
		{
			table.append( none.get( item ) );
		}
		
		table.append( divisors.get( "item" ) + divisors.get( item ) );
		
		return table;
	}

	private void populate()
	{
		this.addItem( new Eletronic( "Maquina de lavar", "Brastemp", 2 ) );
		this.addItem( new Eletronic( "Geladeira", "Brastemp", 3 ) );
		this.addItem( new Eletronic( "Cara", "Apple", 1 ) );
		this.addItem( new Eletronic( "Notebook", "Apple", 1 ) );
		this.addItem( new Eletronic( "Beta", "Apple", 1 ) );
		this.addItem( new Eletronic( "Mouse", "Razer", 2 ) );
		this.addItem( new Eletronic( "Asta", "Razer", 2 ) );
	}
}