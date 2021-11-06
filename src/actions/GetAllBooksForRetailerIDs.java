package actions;

import entities.Book;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class GetAllBooksForRetailerIDs {
    private GetAllBooksForRetailerIDs() {}

    /**
     * Get a list of books for each retailer and create a union list of books
     * @param retailerID1: ID of the wanted publishing-retailer-1
     * @param retailerID2: ID of the wanted publishing-retailer-2
     * @return Union list of list1 and list2
     */
    public static List<Book> getAllBooksForRetailerIDs(int retailerID1, int retailerID2) {
        List<Book> booksForRetailer1 = GetBooksForPublishingRetailerID.getBooksForPublishingRetailerID(retailerID1);
        List<Book> booksForRetailer2 = GetBooksForPublishingRetailerID.getBooksForPublishingRetailerID(retailerID2);

        // I'm using set because we are not accepting duplicates
        Set<Book> unionBooks = new HashSet<>();
        unionBooks.addAll(booksForRetailer1);
        unionBooks.addAll(booksForRetailer2);

        // Convert back to the returned type
        return new ArrayList<>(unionBooks);
    }
}
