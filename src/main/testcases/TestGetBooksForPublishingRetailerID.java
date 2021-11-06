package main.testcases;

import actions.GetBooksForPublishingRetailerID;
import entities.Book;

import java.util.List;

/** This is a handler class used for Testing GetBooksForPublishingRetailerID Method */
public final class TestGetBooksForPublishingRetailerID {
    private TestGetBooksForPublishingRetailerID() {}

    public static void printBooks(List<Book> books) {
        for(Book book: books) {
            System.out.print(book + " ");
        }
        System.out.println();
    }

    /** Get books from a specific publishing-retailer */
    public static void runTestCases() {
        System.out.println("*** Get books from a specific publishing-retailer ***");

        // Testcase 1
        System.out.println("----- Testcase 1 -----");
        List<Book> booksForPublishingRetailer = GetBooksForPublishingRetailerID.getBooksForPublishingRetailerID(1);
        printBooks(booksForPublishingRetailer);

        // Testcase 2
        System.out.println("----- Testcase 2 -----");
        booksForPublishingRetailer = GetBooksForPublishingRetailerID.getBooksForPublishingRetailerID(5);
        printBooks(booksForPublishingRetailer);

        // Testcase 3
        System.out.println("----- Testcase 3 -----");
        booksForPublishingRetailer = GetBooksForPublishingRetailerID.getBooksForPublishingRetailerID(17);
        printBooks(booksForPublishingRetailer);

        // Testcase 4
        System.out.println("----- Testcase 4 -----");
        booksForPublishingRetailer = GetBooksForPublishingRetailerID.getBooksForPublishingRetailerID(27);
        printBooks(booksForPublishingRetailer);

        // Testcase 5
        System.out.println("----- Testcase 5 -----");
        booksForPublishingRetailer = GetBooksForPublishingRetailerID.getBooksForPublishingRetailerID(35); // idx out of bounds
        printBooks(booksForPublishingRetailer);
        System.out.println();
    }
}
