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

    /**
     * Method that add a new client to the cart
     * 
     * @param cliente Cliente Cliente object
     */
    public void addCliente( Cliente cliente )
    {
        clienteArrayList.add( cliente );
    }

    /**
     * Method that return all the clients add in the ArrayList
     * 
     * @return ArrayList<Cliente>
     */
    public ArrayList<Cliente> getCompras()
    {
        return clienteArrayList;
    }
}
