package main;

import classe.Boleto;
import classe.Cartao;
import classe.Cliente;
import classe.Eletronico;
import classe.Livro;
import classe.Dvd;
import repositorio.*;

/**
 * @author Felipe Pieretti Umpierre <umpierre.felipe@gmail.com>
 */
public class main
{
    public static void main( String[] args )
    {
    	System.out.println( "Criando usuários" );
    	
    	// Clientes
        ClienteRepo cliente = new ClienteRepo();        
			        cliente.addClient( new Cliente( "Felipe Umpierre", "123456", "123456" ) );
			        cliente.addClient( new Cliente( "Eduardo Umpierre", "123456", "123456" ) );
        cliente.getClients();
        
		System.out.println( "---" );
        System.out.println( "Criando itens" );
        // Itens
        ItemRepo item = new ItemRepo();
		         item.addItem( new Livro( "livro #1", "author", "publisher", "ABC", "1234AVC", "pt_BR", 2015, "Resume", 3 ) );
		         item.addItem( new Livro( "livro #2", "author", "publisher", "ABC", "1234AVC", "pt_BR", 2015, "Resume", 2 ) );
		         item.addItem( new Livro( "livro #3", "author", "publisher", "ABC", "1234AVC", "pt_BR", 2015, "Resume", 1 ) );
		         item.addItem( new Dvd( "The wolf of wall street", 2013, 2 ) );
		         item.addItem( new Dvd( "Interstellar", 2014, 4 ) );
		         item.addItem( new Eletronico( "Leitor de DVD", 2010, 120, 1 ) );
        System.out.println( item.getItens() );
         
		         
        // Carrinho        
        CarrinhoRepo carrinho = new CarrinhoRepo();
			         carrinho.addCliente( cliente.getClient( 0 ) );
			         carrinho.addItem( item.getItem( 0 ) );
			         carrinho.addItem( item.getItem( 0 ) );
			         carrinho.addItem( item.getItem( 0 ) );
			         carrinho.addItem( item.getItem( 0 ) );
			         carrinho.addItem( item.getItem( 5 ) );
        
        // Carrinho 2
        CarrinhoRepo carrinho2 = new CarrinhoRepo();        
			         carrinho2.addCliente( cliente.getClient( 1 ) );
			         carrinho2.addItem( item.getItem( 1 ) );
			         carrinho2.addItem( item.getItem( 2 ) );
			         carrinho2.addItem( item.getItem( 0 ) );
			         carrinho2.addItem( item.getItem( 0 ) );
        
        System.out.println( "Finalizando pagamento\n" );
        
        carrinho2.payment( new Cartao() );
	        System.out.println( "Carrinho 2:" );
	        System.out.println( carrinho2.getCart() );
        
        carrinho.payment( new Boleto() );
	        System.out.println( "Carrinho 1:" );
	        System.out.println( carrinho.getCart() );
    }
}
