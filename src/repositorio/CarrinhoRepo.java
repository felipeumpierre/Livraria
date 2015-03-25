package repositorio;

import classe.Carrinho;
import classe.Cliente;
import classe.Item;

import java.util.ArrayList;

public class CarrinhoRepo
{
	private ArrayList<Carrinho> carrinhoArrayList;

	public CarrinhoRepo()
	{
		carrinhoArrayList = new ArrayList<Carrinho>();
	}

	public boolean addItemToClient( Item item, Cliente cliente )
	{
		return true;
	}
}
