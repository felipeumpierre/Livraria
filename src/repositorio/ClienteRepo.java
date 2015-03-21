package repositorio;

import classe.Livro;
import java.util.ArrayList;

public class ClienteRepo
{
    /**
     * Class var from type ArrayList<Livro>
     */
    private ArrayList<Livro> livroArrayList;

    /**
     * Constructor that only create a new object in the var
     */
    public ClienteRepo()
    {
        livroArrayList = new ArrayList<Livro>();
    }

    /**
     * Method that add a new Livro in the Client list
     * 
     * @param livro Livro Livro object
     */
    public void addLivro( Livro livro )
    {
        livroArrayList.add( livro );
    }

    /**
     * Method that remove a livro from a index
     * 
     * @param index int number of the index
     */
    public void removeLivro( int index )
    {
        livroArrayList.remove( index );
    }

    /**
     * Method that return the full ArrayList<Livro>
     * 
     * @return ArrayList<Livro>
     */
    public ArrayList<Livro> getLivros()
    {
        return livroArrayList;
    }
}
