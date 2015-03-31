package classe;

import java.util.ArrayList;

public class Carrinho
{
    private ArrayList<Cliente> clienteArrayList = new ArrayList<Cliente>();
	private ArrayList<Item> itemArrayList = new ArrayList<Item>();
	private int status = 0; // 0 - carrinho, 1 - compra finalizada

	/**
	 * Add a Client to the ArrayList<Cliente>
	 * 
	 * @param cliente Cliente instance of Cliente
	 */
    public void addCliente( Cliente cliente )
    {
        clienteArrayList.add( cliente );
    }

    /**
     * Add a Item to the ArrayList<Item>
     * 
     * @param item Item instance of Item
     */    
	public void addItem( Item item )
	{
		itemArrayList.add( item );
	}
		
	/**
	 * Get the status from the Cart
	 * 
	 * @return int
	 */
	public int getStatus() 
	{
		return status;
	}

	/**
	 * Set the status from the Cart
	 * 
	 * @param status int
	 */
	public void setStatus( int status )
	{
		this.status = status;
	}
	
	/**
	 * Get the String format representation of the status
	 * 
	 * @return String
	 */
	public String getStatusString()
	{
		return ( this.getStatus() == 0 ) ? "Aberto" : "Finalizado";
	}

	@Override
	public String toString()
	{
		String leftAlignStatusCartFormat = "| %-30s | %-11s |%n";
		
		System.out.format( "+--------------------------------+-------------+%n" );
		System.out.printf( leftAlignStatusCartFormat, "Status do carrinho", this.getStatusString()  );		
		System.out.format( "+--------------------------------+-------------+%n\n" );
		
			System.out.format( "+----------------------------------------------+%n" );
			System.out.printf( "| Dados do cliente                             |%n" );
			System.out.format( "+----------------------+------------+----------+%n" );
			System.out.printf( "| Nome                 | CPF        | Telefone |%n" );
			System.out.format( "+----------------------+------------+----------+%n" );
			
			for( Cliente cli: clienteArrayList )
			{
				cli.toString();
			}
			
			System.out.format( "+----------------------+------------+----------+%n\n" );
		
		System.out.format( "+------------------------------------------------------------------------------------------------------------------------------+%n" );
		System.out.printf( "| %-124s |%n", "Produtos" );
		System.out.format( "+--------------+--------------------------------+------+--------+---------+-----------+-------------+--------+-----------------+%n" );
		
			for( Item item: itemArrayList )
			{
				item.toString();
			}
		
		System.out.format( "+--------------+--------------------------------+------+--------+---------+-----------+-------------+--------+-----------------+%n" );
		
		return "";
	}
}
