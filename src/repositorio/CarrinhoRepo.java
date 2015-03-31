package repositorio;

import classe.*;

public class CarrinhoRepo
{
	private Carrinho carrinho;

	public CarrinhoRepo()
	{
		carrinho = new Carrinho();
	}
	
	/**
	 * Add a new Client to the Cart
	 * 
	 * @param cliente Cliente instance of Cliente
	 */
	public void addCliente( Cliente cliente )
	{
		carrinho.addCliente( cliente );
	}

	/**
	 * Add a item to the Cart
	 * check if the stock of the item is higher than 0,
	 * if not, don't add the item to the cart
	 * 
	 * @param item Item instance of Item
	 */
	public void addItem( Item item )
	{
		if( item.getStock() > 0 )
		{
			carrinho.addItem( item );
			
			item.setStock( ( item.getStock() - 1 ) );
		}
	}
	
	/**
	 * Do the 'fake' payment
	 * 
	 * @param pagamento Pagamento instance of Payment
	 */
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
	
	/**
	 * Change the status from the cart to 1, that means completed
	 */
	private void finish()
	{
		carrinho.setStatus( 1 );
	}
	
	/**
	 * Print the list of itens in the cart
	 * 
	 * @return String
	 */
	public String getCart()
	{
		return carrinho.toString();
	}
}