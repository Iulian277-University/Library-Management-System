package main.testcases;

import actions.GetAllBooksForRetailerIDs;
import entities.Book;

import java.util.List;

import static main.testcases.TestGetBooksForPublishingRetailerID.printBooks;

/** This is a handler class used for Testing GetAllBooksForRetailerIDs Method */
public final class TestGetAllBooksForRetailerIDs {
    private TestGetAllBooksForRetailerIDs() {}

    /** Get union of books for 2 retailers */
    public static void runTestCases() {
        System.out.println("*** Get union of books for 2 retailers ***");

        // Testcase 1
        System.out.println("----- Testcase 1 -----");
        List<Book> unionOfBooks = GetAllBooksForRetailerIDs.getAllBooksForRetailerIDs(1, 6);
        printBooks(unionOfBooks);

        // Testcase 2
        System.out.println("----- Testcase 2 -----");
        unionOfBooks = GetAllBooksForRetailerIDs.getAllBooksForRetailerIDs(7, 13);
        printBooks(unionOfBooks);

        // Testcase 3
        System.out.println("----- Testcase 3 -----");
        unionOfBooks = GetAllBooksForRetailerIDs.getAllBooksForRetailerIDs(36, 16); // idx1 out of bounds
        printBooks(unionOfBooks);

        // Testcase 4
        System.out.println("----- Testcase 4 -----");
        unionOfBooks = GetAllBooksForRetailerIDs.getAllBooksForRetailerIDs(25, 39); // idx2 out of bounds
        printBooks(unionOfBooks);

        // Testcase 5
        System.out.println("----- Testcase 5 -----");
        unionOfBooks = GetAllBooksForRetailerIDs.getAllBooksForRetailerIDs(37, 55); // both idxs out of bounds
        printBooks(unionOfBooks);
        System.out.println();
    }
}
