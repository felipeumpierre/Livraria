package entity;

public class Eletronic extends Item
{
	private String brand;

	public Eletronic( String name, String brand, int stock )
	{
		this.setName( name );
		this.setBrand( brand );
		this.setStock( stock );
	}
	
	public String getBrand()
	{
		return brand;
	}

	public void setBrand( String brand ) 
	{
		this.brand = brand;
	}
	
	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		
		result.append( super.toString() );
		result.append( String.format( "| %-16s", this.getBrand() ) );
		result.append( String.format( "|%n" ) );
		
		return result.toString();
	}
}
