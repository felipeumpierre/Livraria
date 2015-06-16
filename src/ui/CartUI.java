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
			System.out.println( String.format( "| %-24s |", "1- Acessar carrinho" ) );
			System.out.println( String.format( "| %-24s |", "2- Finalizar carrinho" ) );
			System.out.println( String.format( "| %-24s |", "0- Voltar" ) );
			System.out.println( "+--------------------------+" );
			
			opt = Console.scanInt( "Escolha uma opção: " );
			
			switch( opt )
			{
				case 1: accessCart(); break;
				case 2: finishCart(); break;
				case 0: break;
				default: System.out.println( "\n- Opcao invalida!" ); break;
			}
		}
		while( opt != 0 );
	}
	
	public void accessCart()
	{
		System.out.println( "\n--- Acessando carrinho do cliente ---\n" );
		
		String cpf;
		
		System.out.println( "Para sair, basta informar 0 (zero)" );
		
		do
		{
			cpf = Console.scanString( "Informe o CPF do cliente: " );
			
			if( !cpf.equalsIgnoreCase( "0" ) )
			{
				Client cli = this.client.getClientByCpf( cpf );
				
				if( null != cli )
				{
					addItems( cli );
				}
				else
				{
					System.out.println( "\n- Cliente nao encontrado!" );
				}
			}
		}
		while( !cpf.equalsIgnoreCase( "0" ) );
		
		System.out.println( "\n--- Fim do acesso ao carrinho ---" );
	}
	
	public void finishCart()
	{
		System.out.println( "\n--- Finalizando carrinho ---\n" );		
		System.out.println( "Para sair, basta informar 0 (zero)" );
		
		String cpf;
		
		do
		{
			cpf = Console.scanString( "Informe o CPF do cliente: " );
			
			if( !cpf.equalsIgnoreCase( "0" ) )
			{
				Client cli = this.client.getClientByCpf( cpf );
				
				if( null != cli )
				{
					if( cli.getCart().finish() )
					{
						System.out.println( "\nCarrinho de " + cli.getName() + " finalizado com sucesso!" );
					}
				}
				else
				{
					System.out.println( "\n- Cliente nao encontrado!\n" );
				}
			}
		}
		while( !cpf.equalsIgnoreCase( "0" ) );
		
		System.out.println( "\n--- Fim de finalizar carrinho ---" );
	}
	
	private void addItems( Client cli )
	{
		System.out.println( "\n--- Adicinando produtos ao carrinho ---\n" );
		
		System.out.println( "Você irá adicionar produtos para " + cli.getName() );
		System.out.println( "\n" );
		
		int id = 0;
		
		System.out.println( "Para sair, basta informar 0 (zero)" );
		
		do
		{
			id = Console.scanInt( "Escolha o id do produto: " );
			
			Item i = this.item.getItemById( id );
			
			if( null != i )
			{
				if( cli.getCart().addItem( i ) )
				{
					System.out.println( "\nProduto\n" + i.toString() + "Adicionado com sucesso!\n" );
					System.out.println( cli.getCart().toString() );
				}
			}
			else
			{
				System.out.println( "- Produto nao encontrado!\n" );
			}
		}
		while( id != 0 );
		
		System.out.println( "\n--- Fim de adicao de produtos ao carrinho ---" );
		
		run();
	}
}