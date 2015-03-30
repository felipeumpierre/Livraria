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

	public boolean addClient( Cliente cliente )
	{
		return clienteArrayList.add( cliente );
	}

	public Cliente getClient( int index )
	{
		return clienteArrayList.get( index );
	}
}
