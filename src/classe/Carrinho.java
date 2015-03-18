package classe;

import java.util.ArrayList;

public class Carrinho
{
    private ArrayList<Cliente> clienteArrayList = new ArrayList<Cliente>();

    public void addCliente( Cliente cliente )
    {
        clienteArrayList.add( cliente );
    }
}
