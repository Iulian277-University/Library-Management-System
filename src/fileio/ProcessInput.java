package fileio;

import entities.*;
import fileio.initial.load.*;
import fileio.linking.*;

import java.util.List;

/** This is a handler class used for:
 * -> Reading from input files
 * -> Creating and linking entities (as objects)
 * -> Returning lists of entities where needed
 * */
public final class ProcessInput {
    private ProcessInput() {}

    private static List<Book> books;
    private static List<Language> languages;
    private static List<Author> authors;
    private static List<Country> countries;
    private static List<EditorialGroup> editorialGroups;
    private static List<PublishingBrand> publishingBrands;
    private static List<PublishingRetailer> publishingRetailers;

    /** Read from all input files, create and link entities */
    public static void processInput() {
        // Load books as objects from books.in file
        BookInputData.inputLoader();
        books = BookInputData.getBooks();

        // Load languages as objects from languages.in file
        LanguageInputData.inputLoader();
        languages = LanguageInputData.getLanguages();

        /// Load authors as objects from authors.in file
        AuthorInputData.inputLoader();
        authors = AuthorInputData.getAuthors();

        // Link authors to books (set Authors field from each Book)
        LinkAuthorsToBooks.inputLoader(books, authors);

        // Load countries as objects from countries.in file
        CountryInputData.inputLoader();
        countries = CountryInputData.getCountries();

        // Load editorial-groups as objects from editorial-groups.in file
        EditorialGroupInputData.inputLoader();
        editorialGroups = EditorialGroupInputData.getEditorialGroups();

        // Load publishing-brands as objects from publishing-brands.in file
        PublishingBrandInputData.inputLoader();
        publishingBrands = PublishingBrandInputData.getPublishingBrands();

        // Link books to editorial-groups from editorial-groups-nooks.in file
        LinkBooksToEditorialGroups.inputLoader(editorialGroups, books);

        // Link books to publishing-brands from publishing-brands-books.in file
        LinkBooksToPublishingBrands.inputLoader(publishingBrands, books);

        // Load publishing-retailers as objects from publishing-retailers.in file
        PublishingRetailerInputData.inputLoader();
        publishingRetailers = PublishingRetailerInputData.getPublishingRetailers();

        // Link countries to publishing-retailers from publishing-retailers-countries.in file
        LinkCountriesToPublishingRetailers.inputLoader(publishingRetailers, countries);

        // Link books to publishing-retailers from publishing-retailers-books.in file
        LinkBooksToPublishingRetailers.inputLoader(publishingRetailers, books);

        // Link editorial-groups to publishing-retailers from publishing-retailers-editorial-groups.in file
        LinkEditorialGroupsToPublishingRetailers.inputLoader(publishingRetailers, editorialGroups);

        // Link publishing-brands to publishing-retailers from publishing-retailers-publishing-brands.in file
        LinkPublishingBrandsToPublishingRetailers.inputLoader(publishingRetailers, publishingBrands);
    }

    /** Return the entities */
    public static List<Book> getBooks() {
        return books;
    }

    public static List<Language> getLanguages() {
        return languages;
    }

    public static List<Author> getAuthors() {
        return authors;
    }

    public static List<Country> getCountries() {
        return countries;
    }

    public static List<EditorialGroup> getEditorialGroups() {
        return editorialGroups;
    }

    public static List<PublishingBrand> getPublishingBrands() {
        return publishingBrands;
    }

    public static List<PublishingRetailer> getPublishingRetailers() {
        return publishingRetailers;
    }
}
