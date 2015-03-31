package repositorio;

import classe.Cliente;

import java.util.ArrayList;

/**
 * Helper to manipulate the ArrayList
 * 
 * @author Felipe Pieretti Umpierre <umpierre.felipe@gmal.com>
 */
public class ClienteRepo
{
	private ArrayList<Cliente> clienteArrayList;

	public ClienteRepo()
	{
		clienteArrayList = new ArrayList<Cliente>();
	}

	/**
	 * Add a new client to the ArrayList
	 * 
	 * @param cliente Cliente instance of Cliente
	 * @return boolean
	 */
	public boolean addClient( Cliente cliente )
	{
		return clienteArrayList.add( cliente );
	}

	/**
	 * Get info from a Client by the index
	 * 
	 * @param index int index of the ArrayList
	 * @return 
	 */
	public Cliente getClient( int index )
	{
		return clienteArrayList.get( index );
	}
	
	/**
	 * Get the list from all the Clients
	 * 
	 * @return String
	 */
	public void getClients()
	{
		for( Cliente cli: clienteArrayList )
		{
			cli.toString();
		}
	}
	
	@Override
	public String toString()
	{
		return clienteArrayList.toString();
	}
}
