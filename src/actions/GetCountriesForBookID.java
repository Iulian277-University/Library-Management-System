package actions;

import entities.Book;
import entities.Country;
import entities.PublishingRetailer;
import fileio.ProcessInput;

import java.util.ArrayList;
import utils.FilterEntitiesByID;

import java.util.Collections;
import java.util.List;

public final class GetCountriesForBookID {
    private GetCountriesForBookID() {}

    /**
     * Get a list of countries where the wanted-book reached
     * @param bookID: ID of the wanted book
     * @return List of desired countries
     */
    public static List<Country> getCountriesForBookID(int bookID) {
        // Get the book object
        Book wantedBook = FilterEntitiesByID.filterBooksByID(ProcessInput.getBooks(), bookID);

        // If the book's ID isn't in the database
        if(wantedBook == null) {
            System.out.println("The book with the ID " + bookID + " doesn't exist");
            return Collections.emptyList();
        }

        List<Country> countriesPublished = new ArrayList<>();
        // Iterate through each publishing-retailer
        List<PublishingRetailer> publishingRetailers = ProcessInput.getPublishingRetailers();
        for(PublishingRetailer publishingRetailer: publishingRetailers) {
            // Get the published books for each retailer
            List<Book> booksForThisRetailer =
                    GetBooksForPublishingRetailerID.getBooksForPublishingRetailerID(publishingRetailer.getID());

            // If the list of books published by this retailer contains our book
            if(booksForThisRetailer.contains(wantedBook)) {
                // Add the countries where this retailer sends books
                countriesPublished.addAll(publishingRetailer.getCountries());
            }
        }
        return countriesPublished;
    }
}
