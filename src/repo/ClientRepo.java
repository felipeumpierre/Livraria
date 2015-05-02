package repo;

import java.util.ArrayList;
import entity.Client;

public class ClientRepo
{
	private ArrayList<Client> client;
	
	private int id = 1;
	
	public ClientRepo()
	{
		client = new ArrayList<Client>();
		
		populate();
	}
	
	public void addClient( Client cli )
	{
		if( null != cli )
		{
			cli.setId( this.id );			
			client.add( cli );
			
			this.id++;
		}
	}
	
	public Client getClientById( int id )
	{
		if( id > 0 && id <= client.size() )
		{
			for( Client i: client )
			{
				if( i.getId() == id )
				{
					return i;
				}
			}
		}
		
		return null;
	}
	
	public Client getClientByCpf( String cpf )
	{
		if( client.size() > 0 )
		{
			for( Client i: client )
			{
				if( i.getCpf().equalsIgnoreCase( cpf ) )
				{
					return i;
				}
			}
		}
		
		return null;
	}

	public boolean cpfExists( String cpf )
	{
		for( Client cli: client )
		{
			if( cli.getCpf().equalsIgnoreCase( cpf ) )
			{
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public String toString()
	{
		StringBuilder clients = new StringBuilder();
		StringBuilder _clients = new StringBuilder();
		
		clients.append( Client.divisor );
		clients.append( Client.header );
		clients.append( Client.divisor );
		
		for( Client c: client )
		{
			_clients.append( c.toString() );
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
	}
}