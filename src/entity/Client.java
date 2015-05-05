package entity;

import repo.CartRepo;

public class Client implements Comparable<Client>
{
	private String name;
	private String cpf;
	private int id;
	
	public static final String divisor = String.format( "+-----+------------------------+---------------+%n" );
	public static final String header = String.format( "|  %-2s | %-22s | %-13s |%n", "#", "Nome", "CPF" );
	public static final String none = String.format( "| %-44s |%n", "Nenhum cliente encontrado" );
	
	private CartRepo cart = new CartRepo();
	
	public Client( String name, String cpf )
	{
		this.setName( name );
		this.setCpf( cpf );
	}
	
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
	
	public String getCpf()
	{
		return cpf;
	}
	
	public void setCpf( String cpf )
	{
		this.cpf = cpf;
	}
	
	public CartRepo getCart()
	{
		return this.cart;
	}
	
	@Override
	public int compareTo( Client cli )
	{
		return this.name.compareTo( cli.name );
	}
	
	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		
		result.append( String.format( "|  %-2s ", this.getId() ) );
		result.append( String.format( "| %-22s ", this.getName() ) );
		result.append( String.format( "| %-13s |%n", this.getCpf() ) );
		
		return result.toString();
	}
}
