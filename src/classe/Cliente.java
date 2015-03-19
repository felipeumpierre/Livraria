package classe;

import repositorio.ClienteRepo;

import java.util.ArrayList;

/**
 * Class that will manage the object classe.Cliente
 *
 * @author Felipe <umpierre.felipe@gmail.com>
 */
public class Cliente extends ClienteRepo
{
    private String name;
    private String cpf;
    private String phone;

    /**
     * Constructor for the class
     *
     * @param name String
     * @param cpf String
     * @param phone String
     */
    public Cliente( String name, String cpf, String phone )
    {
        this.setName( name );
        this.setCpf( cpf );
        this.setPhone( phone );
    }

    /**
     * Get name
     *
     * @return String
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set name
     *
     * @param name String
     */
    private void setName( String name )
    {
        this.name = name;
    }

    /**
     * Get CPF
     *
     * @return String
     */
    public String getCpf()
    {
        return cpf;
    }

    /**
     * Set CPF
     *
     * @param cpf String
     */
    private void setCpf( String cpf )
    {
        this.cpf = cpf;
    }

    /**
     * Get phone
     *
     * @return String
     */
    public String getPhone()
    {
        return phone;
    }

    /**
     * Set phone
     *
     * @param phone String
     */
    private void setPhone( String phone )
    {
        this.phone = phone;
    }

    /**
     * Return String with all the informations from the object
     *
     * @return String
     */
    @Override
    public String toString()
    {
        return "----\n" +
                "Nome: " + this.getName() + "\n" +
                "CPF: " + this.getCpf() + "\n" +
                "Telefone: " + this.getPhone() + "\n" +
                "----";
    }
}