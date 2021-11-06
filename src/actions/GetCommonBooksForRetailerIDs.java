package actions;

import entities.Book;

import java.util.List;
import java.util.stream.Collectors;

public final class GetCommonBooksForRetailerIDs {
    private GetCommonBooksForRetailerIDs() {}

    /**
     * Get a list of books for each retailer and create an intersection list of books
     * @param retailerID1: ID of the wanted publishing-retailer-1
     * @param retailerID2: ID of the wanted publishing-retailer-2
     * @return Intersection list of list1 and list2
     */
    public static List<Book> getCommonBooksForRetailerIDs(int retailerID1, int retailerID2) {
        List<Book> booksForRetailer1 = GetBooksForPublishingRetailerID.getBooksForPublishingRetailerID(retailerID1);
        List<Book> booksForRetailer2 = GetBooksForPublishingRetailerID.getBooksForPublishingRetailerID(retailerID2);
        return booksForRetailer1.stream().filter(booksForRetailer2::contains).collect(Collectors.toList());
    }
}
