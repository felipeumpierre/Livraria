package repositorio;

import classe.*;

import java.util.ArrayList;

public class CarrinhoRepo
{
	private ArrayList<Carrinho> carrinhoArrayList;
    private ArrayList<Item> itemArrayList;
    private ArrayList<Cliente> clienteArrayList;

	public CarrinhoRepo()
	{
		carrinhoArrayList = new ArrayList<Carrinho>();
        itemArrayList = new ArrayList<Item>();
        clienteArrayList = new ArrayList<Cliente>();
	}

	public void addItemToClient( Item item, Cliente cliente )
	{
        itemArrayList.add( item );
        clienteArrayList.add( cliente );
	}
}