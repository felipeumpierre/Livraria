package list;

import list.DoubleLinkedList;

public class DoubleLinkedListSort
{
	public static <T extends Comparable<T>> DoubleLinkedList<T> sort( DoubleLinkedList<T> Ts )
	{
		if( Ts.listSize() <= 1 ) 
		{
			return Ts;
		}

		DoubleLinkedList<T> left = new DoubleLinkedList<T>();
		DoubleLinkedList<T> right = new DoubleLinkedList<T>();
		DoubleLinkedList<T> result = new DoubleLinkedList<T>();

		int middle = Ts.listSize() / 2;
		int added = 0;
		
		for( int i = 0; i < Ts.listSize(); i++ )
		{
			try
			{
				if( added++ < middle )
				{
					left.insertFirst( Ts.getElementAtPosition( i ) );
				}
				else
				{
					right.insertFirst( Ts.getElementAtPosition( i ) );
				}
			}
			catch( DoubleLinkedListException d )
			{
				
			}
		}

		left = sort( left );
		right = sort( right );
		result = merge( left, right );

		return result;
	}

	private static <T extends Comparable<T>> DoubleLinkedList<T> merge( DoubleLinkedList<T> left, DoubleLinkedList<T> right ) 
	{
		DoubleLinkedList<T> result = new DoubleLinkedList<T>();
		
		while( left.listSize() > 0 && right.listSize() > 0 )
		{
			try
			{
				if( left.getElementAtPosition( 0 ).compareTo( right.getElementAtPosition( 0 ) ) < 0 )
				{
					result.insertLast( left.getElementAtPosition( 0 ) );
					
					left.deleteElementAtPosition( 0 );
				}
				else
				{
					result.insertLast( right.getElementAtPosition( 0 ) );
					
					right.deleteElementAtPosition( 0 );
				}
			}
			catch( DoubleLinkedListException d )
			{
				
			}
		}
		
		try
		{
			if( left.listSize() > 0 )
			{
				for( int i = 0; i < left.listSize(); i++ )
				{
					result.insertLast( left.getElementAtPosition( i ) );
				}
			}
			else
			{
				for( int i = 0; i < right.listSize(); i++ )
				{
					result.insertLast( right.getElementAtPosition( i ) );
				}
			}
		}
		catch( DoubleLinkedListException d )
		{
			
		}

		return result;
	}
}
