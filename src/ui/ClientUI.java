package ui;

import entity.Client;
import repo.ClientRepo;
import util.Console;

public class ClientUI
{
	private ClientRepo client = new ClientRepo();
	
	public ClientUI( ClientRepo client )
	{
		this.client = client;
	}
	
	public void run()
	{
		int opt = 0;
		
		do
		{
			System.out.println( "\n+--------------------------+" );
			System.out.println( String.format( "| %-24s |", "Menu Cliente" ) );
			System.out.println( "+--------------------------+" );
			System.out.println( String.format( "| %-24s |", "1- Adicionar cliente" ) );
			System.out.println( String.format( "| %-24s |", "2- Listar clientes" ) );
			System.out.println( String.format( "| %-24s |", "3- Buscar clientes" ) );
			System.out.println( String.format( "| %-24s |", "0- Voltar" ) );
			System.out.println( "+--------------------------+" );
			
			opt = Console.scanInt( "Escolha uma opção: " );
			
			switch( opt )
			{
				case 1: addClient(); break;
				case 2: listClient(); break;
				case 3: searchClient(); break;
				default: System.out.println( "\n- Opção inválida!" ); break;
			}
		}
		while( opt != 0 );
	}
	
	private void addClient()
	{
		System.out.println( "\n--- Adicionando novo cliente ---\n" );
		String name = Console.scanString( "Nome: " );
		String cpf = Console.scanString( "CPF: " );
		
		if( this.client.cpfExists( cpf ) )
		{
			System.err.println( "\nO CPF já foi cadastrado.\n" );
		}
		else
		{
			this.client.addClient( new Client( name, cpf ) );
			
			System.out.println( "\nCliente " + name + " cadastrado com sucesso!" );
		}
		
		System.out.println( "\n--- Fim de cadastro de cliente ---" );
	}
	
	public void listClient()
	{
		System.out.println( "\n--- Listar clientes ---\n" );	
		System.out.println( this.client.toString() );		
		System.out.println( "--- Fim da listagem de clientes ---" );
	}
	
	public void searchClient()
	{
		System.out.println( "\n--- Buscando clientes ---\n" );
		
		String cpf = Console.scanString( "Informe o CPF: " );
		
		Client cli = this.client.getClientByCpf( cpf );
		
		if( null != cli )
		{
			StringBuilder result = new StringBuilder();
			
			result.append( Client.divisor );
			result.append( Client.header );
			result.append( Client.divisor );
			result.append( cli.toString() );
			result.append( Client.divisor );
			
			System.out.println( result.toString() );
		}
		else
		{
			System.out.println( "\nNão foi encontrado nenhum cliente com o CPF: " + cpf + "\n" );
		}
		
		System.out.println( "--- Fim da busca de clientes ---" );
	}
}
