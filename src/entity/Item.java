package entity;

public class Item implements Comparable<Item>
{
	private int id = 0, stock;
	private String name, description;

	public int getId() 
	{
		return id;
	}

	public void setId( int id ) 
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}
	
	public void setName( String name )
	{
		this.name = name;
	}
		
	public int getStock()
	{
		return stock;
	}

	public void setStock( int stock )
	{
		this.stock = stock;
	}
	
	public String getDescription() 
	{
		return description;
	}

	public void setDescription( String description )
	{
		this.description = description;
	}
	
	@Override
    public int compareTo( Item it )
	{
		if( this.description != null && it.description != null )
			return this.description.compareTo( it.description );
		
		return 0;
    }

	public String toString()
	{
		StringBuilder result = new StringBuilder();
		
		result.append( String.format( "| %-2s ", this.getId() ) );
		result.append( String.format( "| %-20s ", this.getName() ) );
		
		return result.toString();
	}
	
	public String toStringCart()
	{
		StringBuilder result = new StringBuilder();
		
		result.append( String.format( "| %-2s ", this.getId() ) );
		result.append( String.format( "| %-40s |%n", this.getName() ) );
		
		return result.toString();
	}
}