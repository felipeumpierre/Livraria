package repo;

import entity.Cart;
import entity.Item;

import list.DoubleLinkedList;
import list.DoubleLinkedListException;

public class CartRepo
{
	private DoubleLinkedList<Item> items;
	private Cart cart;
	
	public CartRepo()
	{
		items = new DoubleLinkedList<Item>();
		cart = new Cart();
		
		cart.setCartStatus( 1 );
	}
	
	public void addItem( Item item )
	{
		if( null != item )
		{
			if( checkStockFromItem( item ) )
			{
				try
				{
					items.insertFirst( item );				
					item.setStock( item.getStock() - 1 );
				}
				catch( DoubleLinkedListException d )
				{
					
				}
			}
			else
			{
				System.out.println( "Produto indisponível." );
				System.out.println( item.toString() );
			}
		}
	}
	
	public boolean checkStockFromItem( Item item )
	{
		if( item.getStock() > 0 )
		{
			return true;
		}
		
		return false;
	}
	
	public String checkStatusCart()
	{
		return this.cart.getCartStatus() == 1 ? "Aberto" : "Fechado";
	}
	
	@Override
	public String toString()
	{		
		StringBuilder products = new StringBuilder();
				
		products.append( String.format( "+-----+------------------------------------------+%n" ) );
		products.append( String.format( "|  %-2s | %-40s |%n", "#", "Item" ) );
		products.append( String.format( "+-----+------------------------------------------+%n" ) );
		
		for( int i = 0; i < items.listSize(); i++ )
		{
			try
			{
				Item item = items.getElementAtPosition( i );
				
				products.append( item.toStringCart() );
			}
			catch( DoubleLinkedListException d )
			{
				
			}
		}
		
		products.append( String.format( "+-----+------------------------------------------+%n" ) );
				
		return products.toString();
	}
}
