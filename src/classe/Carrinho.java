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
	
	public String getStatusString()
	{
		return ( this.getStatus() == 0 ) ? "Aberto" : "Finalizado";
	}

	@Override
	public String toString()
	{
		String leftAlignFormat = "| %-19s | %-13s | %-14s |%n";
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
