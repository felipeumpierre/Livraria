package list;

import java.util.Random;

public class HashTable<T>
{
	static final double LOAD_FACTOR = 0.5;
	static final int INITIAL_SIZE = 50;
	
	private Object[] hash;
	private int size = 0;
	
	class HashEntry 
	{
		String key;
		T value;
		
		HashEntry( String key, T value )
		{
			this.key = key;
			this.value = value;
		}
	}
	
	public HashTable()
	{
		this.hash = new Object[ INITIAL_SIZE ];
	}
	
	public void put( String key, T value )
	{
		if( this.size > ( this.hash.length * LOAD_FACTOR ) )
		{
			expand();
		}
		
		int hashCode = key( key );

		this.hash[ hashCode ] = new HashEntry( key, value );
		
		++this.size;
	}
	
	public int size()
	{
		return this.size;
	}
	
	public T find( int index )
	{
		if( null != this.hash[ index ] )
		{
			HashEntry hashEntry = (HashEntry) this.hash[ index ];
			
			return hashEntry.value;
		}
		
		return null;
	}
	
 	public T find( String key )
	{
		int hashCode = key( key );
		
		HashEntry object = (HashEntry) this.hash[ hashCode ];
		
		if( null != object.value )
		{
			return object.value;
		}
		
		return null;
	}
	
	private void expand()
	{
		Object[] old = this.hash;
		
		Random rand = new Random();		
		int newSize = 2 * this.hash.length + rand.nextInt( 10 );
		
		this.hash = new Object[ newSize ];
		
		for( int i = 0; i < old.length; i++ )
		{
			if( null != old[ i ] )
			{
				HashEntry hashEntry = (HashEntry) old[ i ];
				System.out.println( hashEntry.key );
				int hashCode = key( hashEntry.key );
				
				this.hash[ hashCode ] = hashEntry;
			}
		}
	}
	
	private int key( String key )
	{
		int h = 0;
		
		if( h == 0 ) 
		{
			int off = 0;
            char val[] = key.toCharArray();
            int len = key.length();

            for( int i = 0; i < len; i++ )
            {
            	h = 2 * h + val[ off++ ];
            }
		}
		
		return Math.abs( h ) % this.hash.length;
	}
}
