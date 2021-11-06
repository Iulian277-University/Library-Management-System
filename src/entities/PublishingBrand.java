package entities;

import java.util.ArrayList;
import java.util.List;

public class PublishingBrand implements IPublishingArtifact{
    /** Attributes */
    private int ID;
    private String name;
    private List<Book> books = new ArrayList<>();

    /** Constructors */
    public PublishingBrand(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    /** Getters */
    public int getID() {
        return ID;
    }

    public List<Book> getBooks() {
        return books;
    }

    /** Setters */
    public void addBook(Book book) {
        this.books.add(book);
    }

    /** Public methods*/
    public String publish() {

        StringBuilder booksContent = new StringBuilder();
        for(Book book: this.books) {
            booksContent.append(book.bookContent3Tabs());
        }

        return "<xml>\n" +
                "   <publishingBrand>\n" +
                "       <ID>" + this.ID + "</ID>\n" +
                "       <Name>" + this.name + "</Name>\n" +
                "   </publishingBrand>\n" +
                "   <books>\n" +
                        booksContent.toString() +
                "   </books>\n" +
                "</xml>";
    }

    @Override
    public String toString() {
        return "PublishingBrand{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
