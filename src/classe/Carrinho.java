package classe;

import java.util.ArrayList;

/**
 * Manipulate clients from or to cart
 * 
 * @author Felipe Pieretti Umpierre <umpierre.felipe@gmail.com>
 */
public class Carrinho
{
    /**
     * Initialize the ArrayList<Cliente>
     */
    private ArrayList<Cliente> clienteArrayList = new ArrayList<Cliente>();
	private ArrayList<Item> itemArrayList = new ArrayList<Item>();

    /**
     * Method that add a new client to the cart
     * 
     * @param cliente Cliente Cliente object
     */
    public void addCliente( Cliente cliente )
    {
        clienteArrayList.add( cliente );
    }

	public void addItem( Item item )
	{
		itemArrayList.add( item );
	}


}
