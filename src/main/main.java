package main;

import classe.Cliente;
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
        ClienteRepo cliente = new ClienteRepo();
        cliente.addClient( new Cliente( "Felipe", "123456", "123456" ) );
        cliente.addClient( new Cliente( "Eduardo", "123456", "123456" ) );

        ItemRepo item = new ItemRepo();

        // item.addItem( new Livro( "livro #1", "author", "publisher", "ABC", "1234AVC", "pt_BR", 2015, "Resume" ) );
        // item.addItem( new Livro( "livro #2", "author", "publisher", "ABC", "1234AVC", "pt_BR", 2015, "Resume" ) );
        item.addItem( new Dvd( "The wolf of wall street", 2013 ) );
        item.addItem( new Dvd( "Interstellar", 2014 ) );
        
        CarrinhoRepo carrinho = new CarrinhoRepo();
        carrinho.addCliente( cliente.getClient( 0 ) );
        carrinho.addItem( item.getItem( 0 ) );
        carrinho.finish();
        
        CarrinhoRepo carrinho2 = new CarrinhoRepo();        
        carrinho2.addCliente( cliente.getClient( 1 ) );
        carrinho2.addItem( item.getItem( 1 ) );
        
        System.out.println( "Carrinho finalizado: \n" );
        System.out.println( carrinho.getClosedCart() );
        System.out.println( "\n--------------\n" );
        System.out.println( "Carrinho aberto: \n" );
        System.out.println( carrinho2.getOpenCart() );
    }
}
