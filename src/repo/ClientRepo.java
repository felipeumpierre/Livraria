package repo;

import list.DoubleLinkedList;
import list.DoubleLinkedListException;
import list.DoubleLinkedListSort;
import entity.Client;

public class ClientRepo
{
	private DoubleLinkedList<Client> client;
	
	private int id = 1;
	
	public ClientRepo()
	{
		client = new DoubleLinkedList<Client>();
		
		populate();
	}
	
	public void addClient( Client cli )
	{
		if( null != cli )
		{
			cli.setId( this.id );
			
			try
			{
				client.insertFirst( cli );
			}			
			catch( DoubleLinkedListException d )
			{
				
			}
			
			this.id++;
		}
	}
	
	public Client getClientById( int id )
	{
		if( id > 0 )
		{
			for( int i = 0; i < client.listSize(); i++ )
			{
				try
				{
					Client cli = client.getElementAtPosition( i );
				
					if( cli.getId() == id )
					{
						return cli;
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
	
	public Client getClientByCpf( String cpf )
	{
		if( client.listSize() > 0 )
		{
			for( int i = 0; i < client.listSize(); i++ )
			{
				try
				{
					Client cli = client.getElementAtPosition( i );
				
					if( cli.getCpf().equalsIgnoreCase( cpf ) )
					{
						return cli;
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

	public boolean cpfExists( String cpf )
	{
		for( int i = 0; i < client.listSize(); i++ )
		{
			try
			{
				Client cli = client.getElementAtPosition( i );
			
				if( cli.getCpf().equalsIgnoreCase( cpf ) )
				{
					return true;
				}
			}
			catch( DoubleLinkedListException d )
			{
				return true;
			}
		}
		
		return false;
	}
	
	public DoubleLinkedList<Client> sort()
	{
		this.client = DoubleLinkedListSort.sort( this.client );
		
		return this.client;
	}
	
	@Override
	public String toString()
	{
		StringBuilder clients = new StringBuilder();
		StringBuilder _clients = new StringBuilder();
		
		clients.append( Client.divisor );
		clients.append( Client.header );
		clients.append( Client.divisor );
		
		for( int i = 0; i < client.listSize(); i++ )
		{
			try
			{
				Client cli = client.getElementAtPosition( i );
			
				_clients.append( cli.toString() );
			}
			catch( DoubleLinkedListException d )
			{
				
			}
		}
		
		if( _clients.length() > 0 )
		{
			clients.append( _clients );
		}
		else
		{
			clients.append( Client.none );
		}
		
		clients.append( Client.divisor );
		
		return clients.toString();
	}

	private void populate()
	{		
		this.addClient( new Client( "Felipe", "12345" ) );
		this.addClient( new Client( "Vivian", "54321" ) );
		this.addClient( new Client( "Eduardo", "12345" ) );
		this.addClient( new Client( "João", "12345" ) );
		this.addClient( new Client( "Ana", "12345" ) );
		this.addClient( new Client( "Walter", "12345" ) );
	}
}