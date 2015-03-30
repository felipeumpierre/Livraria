package classe;

import java.util.ArrayList;

public class Carrinho
{
    private ArrayList<Cliente> clienteArrayList = new ArrayList<Cliente>();
	private ArrayList<Item> itemArrayList = new ArrayList<Item>();

    public void addCliente( Cliente cliente )
    {
        clienteArrayList.add( cliente );
    }

	public void addItem( Item item )
	{
		itemArrayList.add( item );
	}
}
