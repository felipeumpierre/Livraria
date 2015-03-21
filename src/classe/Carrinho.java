package classe;

import java.util.ArrayList;

/**
 * @author Felipe Pieretti Umpierre <umpierre.felipe@gmail.com>
 * 
 * Classe para manipulação de clientes no carrinho de compra.
 */
public class Carrinho
{
    /**
     * Inicializa o ArrayList<Cliente> na classe
     */
    private ArrayList<Cliente> clienteArrayList = new ArrayList<Cliente>();

    /**
     * Função para adicionar um novo cliente no carrinho
     * 
     * @param cliente Cliente Objeto cliente
     */
    public void addCliente( Cliente cliente )
    {
        clienteArrayList.add( cliente );
    }

    /**
     * Função para retornar o arry com todos os clientes adicionados no carrinho
     * 
     * @return ArrayList<Cliente>
     */
    public ArrayList<Cliente> getCompras()
    {
        return clienteArrayList;
    }
}
