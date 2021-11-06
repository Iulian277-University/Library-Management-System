package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Book implements IPublishingArtifact{
    /** Attributes */
    private int ID;
    private String name;
    private String subtitle;
    private String ISBN;
    private int pageCount;
    private List<String> keywords;
    private int languageID;
    private Date createdOn;
    private List<Author> authors = new ArrayList<>();


    /** Constructors */
    public Book(int ID, String name, String subtitle, String ISBN, int pageCount,
                List<String> keywords, int languageID, Date createdOn) {
        this.ID = ID;
        this.name = name;
        this.subtitle = subtitle;
        this.ISBN = ISBN;
        this.pageCount = pageCount;
        this.keywords = keywords;
        this.languageID = languageID;
        this.createdOn = createdOn;
    }

    /** Getters */
    public int getID() {
        return ID;
    }

    public int getLanguageID() {
        return languageID;
    }

    /** Setters */
    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    /** Public methods*/
    public String bookContent3Tabs() {
        return  "       <book>\n" +
                "           <title>" + this.name + "</title>\n" +
                "           <subtitle>" + this.subtitle + "</subtitle>\n" +
                "           <isbn>" + this.ISBN + "</isbn>\n" +
                "           <pageCount>" + this.pageCount + "</pageCount>\n" +
                "           <keywords>" + this.keywords + "</keywords>\n" +
                "           <languageID>" + this.languageID + "</languageID>\n" +
                "           <createdOn>" + this.createdOn + "</createdOn>\n" +
                "           <authors>" + this.authors + "</authors>\n" +
                "       </book>\n";
    }

    public String publish() {
        String content =
                "   <title>" + this.name + "</title>\n" +
                "   <subtitle>" + this.subtitle + "</subtitle>\n" +
                "   <isbn>" + this.ISBN + "</isbn>\n" +
                "   <pageCount>" + this.pageCount + "</pageCount>\n" +
                "   <keywords>" + this.keywords + "</keywords>\n" +
                "   <languageID>" + this.languageID + "</languageID>\n" +
                "   <createdOn>" + this.createdOn + "</createdOn>\n" +
                "   <authors>" + this.authors + "</authors>\n";

        return "<xml>\n" +
                content +
                "</xml>\n";
    }

    @Override
    public String toString() {
        return "Book{" +
                "ID=" + ID +
                '}';
    }
}
