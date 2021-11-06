package main;

import main.testcases.*;

/** This class is used to test the application */
public final class Test {
    private Test() {}

    public static void runTestCases() {
        // Get books from a specific publishing-retailer
        TestGetBooksForPublishingRetailerID.runTestCases();

        // Get languages of the books from a specific publishing-retailer
        TestGetLanguagesForPublishingRetailerID.runTestCases();

        // Get countries for a specific book
        TestGetCountriesForBookID.runTestCases();

        // Get common books for 2 retailers
        TestGetCommonBooksForRetailerIDs.runTestCases();

        // Get union of books for 2 retailers
        TestGetAllBooksForRetailerIDs.runTestCases();
    }
}
