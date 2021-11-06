package main.testcases;

import actions.GetCommonBooksForRetailerIDs;
import entities.Book;

import java.util.List;

import static main.testcases.TestGetBooksForPublishingRetailerID.printBooks;

/** This is a handler class used for Testing GetCommonBooksForRetailerIDs Method */
public final class TestGetCommonBooksForRetailerIDs {
    private TestGetCommonBooksForRetailerIDs() {}

    /** Get common books for 2 retailers */
    public static void runTestCases() {
        System.out.println("*** Get common books for 2 retailers ***");

        // Testcase 1
        System.out.println("----- Testcase 1 -----");
        List<Book> commonBooks = GetCommonBooksForRetailerIDs.getCommonBooksForRetailerIDs(1, 6);
        printBooks(commonBooks);

        // Testcase 2
        System.out.println("----- Testcase 2 -----");
        commonBooks = GetCommonBooksForRetailerIDs.getCommonBooksForRetailerIDs(7, 13);
        printBooks(commonBooks);

        // Testcase 3
        System.out.println("----- Testcase 3 -----");
        commonBooks = GetCommonBooksForRetailerIDs.getCommonBooksForRetailerIDs(19, 7); // zero common books
        printBooks(commonBooks);

        // Testcase 4
        System.out.println("----- Testcase 4 -----");
        commonBooks = GetCommonBooksForRetailerIDs.getCommonBooksForRetailerIDs(36, 16); // idx1 out of bounds
        printBooks(commonBooks);

        // Testcase 5
        System.out.println("----- Testcase 5 -----");
        commonBooks = GetCommonBooksForRetailerIDs.getCommonBooksForRetailerIDs(25, 39); // idx2 out of bounds
        printBooks(commonBooks);

        // Testcase 6
        System.out.println("----- Testcase 6 -----");
        commonBooks = GetCommonBooksForRetailerIDs.getCommonBooksForRetailerIDs(37, 55); // both idxs out of bounds
        printBooks(commonBooks);
        System.out.println();
    }
}
