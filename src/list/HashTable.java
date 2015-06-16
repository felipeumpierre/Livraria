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
		
		this.hash[ this.key( key ) ] = new HashEntry( key, value );
		
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
			@SuppressWarnings( "unchecked" )
			HashEntry hashEntry = (HashEntry) this.hash[ index ];
			
			return hashEntry.value;
		}
		
		return null;
	}
	
 	public T find( String key )
	{
		int hashCode = key( key );
		
		@SuppressWarnings( "unchecked" )
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
				@SuppressWarnings( "unchecked" )
				HashEntry hashEntry = (HashEntry) old[ i ];
				
				this.put( hashEntry.key, hashEntry.value );
			}
		}
	}
	
	private int key( String key )
	{
		int hashVal = 0;
		
		for( int i = 0; i < key.length( ); i++ )
            hashVal = 9 * hashVal + key.charAt( i );
		
		hashVal %= this.hash.length;
		
        if( hashVal < 0 )
            hashVal += this.hash.length;
		
		return hashVal;
	}
}
