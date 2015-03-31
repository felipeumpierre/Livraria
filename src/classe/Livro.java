package classe;

/**
 * Class that will manage the object classe.Livro
 *
 * @author Felipe Pieretti Umpierre <umpierre.felipe@gmail.com>
 */
public class Livro extends Item
{
    private String author, publisher;
    private String edition;
    private String isbn, language;
    private String resume;
    private String leftAlignFormat = "| %-12s | %-30s | %-4s | %-6s | %-5s | %-9s | %-11s | %-5s | %-15s |%n";

    /**
     * Constructor for the class
     *
     * @param title String
     * @param author String
     * @param publisher String
     * @param edition String
     * @param isbn String
     * @param language String
     * @param year int
     * @param resume String
     */
    public Livro( String title, String author, String publisher, String edition, String isbn, String language, int year, String resume, int stock )
    {
        this.setTitle( title );
        this.setAuthor( author );
        this.setPublisher( publisher );
        this.setEdition( edition );
        this.setIsbn( isbn );
        this.setLanguage( language );
        this.setYear( year );
        this.setResume( resume );
        this.setStock( stock );
    }

    public Livro()
    {
        // do nothing
    }

    /**
     * Get author
     *
     * @return String
     */
    public String getAuthor()
    {
        return author;
    }

    /**
     * Set author
     *
     * @param author String
     */
    public void setAuthor( String author )
    {
        this.author = author;
    }

    /**
     * Get edition
     *
     * @return String
     */
    public String getEdition()
    {
        return edition;
    }

    /**
     * Set edition
     *
     * @param edition String
     */
    public void setEdition( String edition )
    {
        this.edition = edition;
    }

    /**
     * Get publisher
     *
     * @return String
     */
    public String getPublisher()
    {
        return publisher;
    }

    /**
     * Set publisher
     *
     * @param publisher String
     */
    public void setPublisher( String publisher )
    {
        this.publisher = publisher;
    }

    /**
     * Get language
     *
     * @return String
     */
    public String getLanguage()
    {
        return language;
    }

    /**
     * Set language
     *
     * @param language String
     */
    public void setLanguage( String language )
    {
        this.language = language;
    }

    /**
     * Get isbn
     *
     * @return String
     */
    public String getIsbn()
    {
        return isbn;
    }

    /**
     * Set isbn
     *
     * @param isbn String
     */
    public void setIsbn( String isbn )
    {
        this.isbn = isbn;
    }

    /**
     * Get resume
     *
     * @return String
     */
    public String getResume()
    {
        return resume;
    }

    /**
     * Set resume
     *
     * @param resume String
     */
    public void setResume( String resume )
    {
        this.resume = resume;
    }
    
    public void getHeader()
    {	
    	System.out.format( "+----------------------------------------------------------------------------------------------------+%n" );
    	System.out.printf( "| Livro                                                                                              |%n" );
    	System.out.format( "+------------------------+--------+--------+---------+-----------+-------------+----------+-----------------+%n" );
		System.out.printf( "| Título                 | Ano    | Edição | ISBN    | Linguagem | Editora     |  Author  | Resumo          |%n" );
		System.out.format( "+------------------------+--------+--------+---------+-----------+-------------+----------+-----------------+%n" );
    }

    public void getFooter()
    {
    	System.out.format( "+-----------------+-----------+--------+---------+-----------+-------------+-------+-----------------+%n" );
    }
    
    /**
     * Return String with all the informations from the object
     *
     * @return String
     */
    @Override
    public String toString()
    {	
		System.out.printf( this.leftAlignFormat, "Livro", this.getTitle(), this.getYear(), this.getEdition(), this.getIsbn(), this.getLanguage(), this.getPublisher(), this.getAuthor(), this.getResume() );
		
		return "";
    }
}
