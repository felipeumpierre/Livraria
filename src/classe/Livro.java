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
    public Livro( String title, String author, String publisher, String edition, String isbn, String language, int year, String resume )
    {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.edition = edition;
        this.isbn = isbn;
        this.language = language;
        this.year = year;
        this.resume = resume;
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

    /**
     * Return String with all the informations from the object
     *
     * @return String
     */
    @Override
    public String toString()
    {
        return  "\tAutor: " + this.getAuthor() + "\n" +
                "\tEdição: " + this.getEdition() + "\n" +
                "\tISBN: " + this.getIsbn() + "\n" +
                "\tLinguagem: " + this.getLanguage() + "\n" +
                "\tPublisher: " + this.getPublisher() + "\n" +
                "\tTítulo: " + this.getTitle() + "\n" +
                "\tAno: " + this.getYear() + "\n" +
                "\tResumo: " + this.getResume() + "\n" +
                "\t----";
    }
}
