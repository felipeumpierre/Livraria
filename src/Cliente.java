import java.util.ArrayList;

public class Cliente
{
    private String name, cpf, rg, phone;
    private ArrayList<Livro> livros = new ArrayList<Livro>();

    public Cliente(String name, String cpf, String rg, String phone)
    {
        this.setName( name );
        this.setCpf( cpf );
        this.setRg( rg );
        this.setPhone( phone );
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getCpf()
    {
        return cpf;
    }

    public void setCpf( String cpf )
    {
        this.cpf = cpf;
    }

    public String getRg()
    {
        return rg;
    }

    public void setRg( String rg )
    {
        this.rg = rg;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone( String phone )
    {
        this.phone = phone;
    }

    public ArrayList<Livro> getLivros()
    {
        return livros;
    }

    public void setLivros( ArrayList<Livro> livros )
    {
        this.livros = livros;
    }
}
