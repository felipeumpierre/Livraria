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
		
		cart.setCartStatus( false );
	}
	
	public boolean addItem( Item item )
	{
		if( null != item )
		{
			if( !this.cart.getCartStatus() )
			{
				if( checkStockFromItem( item ) )
				{
					try
					{
						items.insertFirst( item );				
						item.setStock( item.getStock() - 1 );
						
						return true;
					}
					catch( DoubleLinkedListException d )
					{
						
					}
				}
				else
				{
					System.out.println( "\n- Produto indisponível." );
					System.out.println( item.toString() );
					
					return false;
				}
			}
			else
			{
				System.out.println( "\n- Este carrinho já está finalizado." );
				
				return false;
			}
		}
		
		return false;
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
		return !this.cart.getCartStatus() ? "Aberto" : "Fechado";
	}
	
	public boolean finish()
	{
		if( !cart.getCartStatus() )
		{
			this.cart.setCartStatus( true );
		}
		
		return this.cart.getCartStatus();
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
