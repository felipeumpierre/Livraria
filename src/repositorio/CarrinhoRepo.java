package repositorio;

import classe.*;

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
		if( item.getStock() > 0 )
		{
			carrinho.addItem( item );
			
			item.setStock( ( item.getStock() - 1 ) );
		}
	}
	
	public void payment( Pagamento pagamento )
	{
		if( pagamento instanceof Cartao )
		{
			System.out.println( "Realizando pagamento...." );
			System.out.println( "Verificando dados do cartão...." );
			this.finish();
			System.out.println( "Pagamento realizado com sucesso!\n" );
		}
		else if( pagamento instanceof Boleto )
		{
			System.out.println( "Realizando pagamento...." );
			System.out.println( "Pagamento por boleto desabilitado.\n" );
		}
	}
	
	private void finish()
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
	
	public String getCart()
	{
		return carrinho.toString();
	}
}