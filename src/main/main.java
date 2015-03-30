package main;

import classe.Cliente;
import classe.Dvd;
import classe.Livro;
import repositorio.*;

import java.util.ArrayList;

/**
 * @author Felipe Pieretti Umpierre <umpierre.felipe@gmail.com>
 */
public class main
{
    public static void main( String[] args )
    {
        ClienteRepo cliente = new ClienteRepo();
        cliente.addClient( new Cliente( "Felipe", "123456", "123456" ) );
        ClienteRepo cliente2 = new ClienteRepo();

        ItemRepo livro = new ItemRepo();
        ItemRepo dvd1 = new ItemRepo();
        ItemRepo eletronico1 = new ItemRepo();

        livro.addItem( new Livro( "livro #1", "author", "publisher", "ABC", "1234AVC", "pt_BR", 2015, "Resume" ) );
        // dvd1.addItem( new Dvd());

        CarrinhoRepo carrinho = new CarrinhoRepo();
        carrinho.addItemToClient( livro.getItem( 0 ), cliente.getClient( 0 ) );


    }
}
