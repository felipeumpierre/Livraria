package repo;

import entity.Cart;
import entity.Item;

import java.util.ArrayList;

public class CartRepo
{
	private ArrayList<Item> items;
	private Cart cart;
	
	public CartRepo()
	{
		items = new ArrayList<Item>();
		cart = new Cart();
		
		cart.setCartStatus( 1 );
	}
	
	public void addItem( Item item )
	{
		if( null != item )
		{
			if( checkStockFromItem( item ) )
			{
				items.add( item );				
				item.setStock( item.getStock() - 1 );
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
		
		for( Item i: items )
		{
			products.append( i.toStringCart() );
		}
		
		products.append( String.format( "+-----+------------------------------------------+%n" ) );
				
		return products.toString();
	}
}
