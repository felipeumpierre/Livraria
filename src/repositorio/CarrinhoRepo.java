package repositorio;

import classe.*;

import java.util.ArrayList;

public class CarrinhoRepo
{
	private Carrinho carrinho;

	public CarrinhoRepo()
	{
		carrinho = new Carrinho();
	}
	
	public void addCliente( Cliente cliente )
	{
		carrinho.addCliente( cliente );
	}

	public void addItem( Item item )
	{
		carrinho.addItem( item );
	}
	
	public void finish()
	{
		carrinho.setStatus( 1 );
	}
	
	public String getOpenCart()
	{
		if( carrinho.getStatus() == 0 )
		{
			return carrinho.toString();
		}
		
		return "O carrinho não está aberto.";
	}
	
	public String getClosedCart()
	{
		if( carrinho.getStatus() == 1 )
		{
			return carrinho.toString();
		}
		
		return "O carrinho não está concluído";
	}
}