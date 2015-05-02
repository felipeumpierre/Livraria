package ui;

import entity.Client;
import entity.Item;
import repo.ClientRepo;
import repo.ItemRepo;
import util.Console;

public class CartUI
{
	private ClientRepo client;
	private ItemRepo item;
	
	public CartUI( ClientRepo client, ItemRepo item )
	{
		this.client = client;
		this.item = item;
	}
	
	public void run()
	{
		int opt = 0;
		
		do
		{
			System.out.println( "\n+--------------------------+" );
			System.out.println( String.format( "| %-24s |", "Menu Carrinho" ) );
			System.out.println( "+--------------------------+" );
			System.out.println( String.format( "| %-24s |", "1- Novo carrinho" ) );
			System.out.println( String.format( "| %-24s |", "2- Acessar carrinho" ) );
			System.out.println( String.format( "| %-24s |", "0- Voltar" ) );
			System.out.println( "+--------------------------+" );
			
			opt = Console.scanInt( "Escolha uma opção: " );
			
			switch( opt )
			{
				case 1: newCart(); break;
				case 2: openCart(); break;
				default: System.out.println( "\n- Opção inválida!" ); break;
			}
		}
		while( opt != 0 );
	}
	
	public void newCart()
	{
		System.out.println( "\n--- Novo carrinho ---\n" );
		
		boolean found = false;
		
		do
		{
			String cpf = Console.scanString( "Informe o CPF do cliente: " );
			
			Client cli = this.client.getClientByCpf( cpf );
			
			if( null != cli )
			{
				addItems( cli );

				found = true;
			}
			else
			{
				System.out.println( "\n- Cliente não encontrado!\n" );
			}
		}
		while( found == false );
		
		System.out.println( "\n--- Fim do novo carrinho ---" );
	}
	
	public void openCart()
	{
		System.out.println( "\n--- Acessar carrinho ---\n" );
		
		boolean found = false;
		
		do
		{
			String cpf = Console.scanString( "Informe o CPF do cliente: " );
			
			Client cli = this.client.getClientByCpf( cpf );
			
			if( null != cli )
			{
				System.out.println( "Os produtos neste carrinho" );
				System.out.println( cli.getCart().toString() );
				
				addItems( cli );

				found = true;
			}
			else
			{
				System.out.println( "\n- Cliente não encontrado!\n" );
			}
		}
		while( found == false );
		
		System.out.println( "\n--- Fim do acesso ao carrinho já existente ---" );
	}
	
	private void addItems( Client cli )
	{
		System.out.println( "\n--- Adicinando produtos ao carrinho ---\n" );
		
		int id = 0;
		
		do
		{
			id = Console.scanInt( "0- Sair | Escolha o id do produto: " );
			
			Item i = this.item.getItemById( id );
			
			if( null != i )
			{
				cli.getCart().addItem( i );
				
				System.out.println( "\nProduto\n" + i.toString() + "Adicionado com sucesso!\n" );
			}
			
			System.out.println( cli.toString() );
			System.out.println( cli.getCart().toString() );	
		}
		while( id != 0 );
		
		System.out.println( "\n--- Fim de adição de produtos ao carrinho ---" );
	}
}
