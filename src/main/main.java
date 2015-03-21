package main;

import classe.*;

import java.util.ArrayList;

public class main
{
    public static void main( String[] args )
    {
        // create a new client
        Cliente cliente = new Cliente( "Felipe", "123456", "123456" );
        
        // create a new book
        Livro livro = new Livro( 1, "livro #1", "author", "publisher", "ABC", "1234AVC", "pt_BR", 2015, "Resume" );
        
        // create another book
        Livro livro2 = new Livro( 2, "livro #2", "author", "publisher", "ABC", "1234AVC", "pt_BR", 2015, "Resume" );

        // insert the first book to the client
        cliente.addLivro( livro );
        
        // insert the other book to the client
        cliente.addLivro( livro2 );

        // create the object Carrinho
        Carrinho carrinho = new Carrinho();
        
        // add the client to it
        carrinho.addCliente( cliente );

        // now, to list the informations saved in the ArrayList
        ArrayList<Cliente> clienteArrayList = carrinho.getCompras();

        // make a loop to print all the informations
        for( Cliente cli: clienteArrayList )
        {
            System.out.println( "Nome: " + cli.getName() );
            System.out.println( "CPF: " + cli.getCpf() );
            System.out.println( "Livros:" );

            for( Livro li: cli.getLivros() )
            {
                System.out.println( li.toString() );
            }
        }
    }
}
