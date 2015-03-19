package main;

import classe.*;

import java.util.ArrayList;

public class main
{
    public static void main( String[] args )
    {
        Cliente cliente = new Cliente( "Felipe", "123456", "123456" );
        Livro livro = new Livro( 1, "livro #1", "author", "publisher", "ABC", "1234AVC", "pt_BR", 2015, "Resume" );
        Livro livro2 = new Livro( 2, "livro #2", "author", "publisher", "ABC", "1234AVC", "pt_BR", 2015, "Resume" );

        cliente.addLivro( livro );
        cliente.addLivro( livro2 );

        Carrinho carrinho = new Carrinho();
        carrinho.addCliente( cliente );

        ArrayList<Cliente> clienteArrayList = carrinho.getCompras();

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