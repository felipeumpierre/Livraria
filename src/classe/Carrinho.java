package classe;

import java.util.ArrayList;

public class Carrinho
{
    private ArrayList<Cliente> clienteArrayList = new ArrayList<Cliente>();
	private ArrayList<Item> itemArrayList = new ArrayList<Item>();
	private int status = 0; // 0 - carrinho, 1 - compra finalizada

    public void addCliente( Cliente cliente )
    {
        clienteArrayList.add( cliente );
    }

	public void addItem( Item item )
	{
		itemArrayList.add( item );
	}
		
	public int getStatus() 
	{
		return status;
	}

	public void setStatus( int status )
	{
		this.status = status;
	}

	@Override
	public String toString()
	{
		return "Carrinho: " + this.getStatus() + "\n"
				+ "Cliente: \n" + clienteArrayList.toString() + "\n"
				+ "\tItens: \n"
				+ itemArrayList.toString();
	}
}
