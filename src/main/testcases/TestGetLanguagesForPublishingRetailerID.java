package main.testcases;

import actions.GetLanguagesForPublishingRetailerID;
import entities.Language;

import java.util.List;

/** This is a handler class used for Testing GetLanguagesForPublishingRetailerID Method */
public final class TestGetLanguagesForPublishingRetailerID {
    private TestGetLanguagesForPublishingRetailerID() {}

    private static void printLanguages(List<Language> languages) {
        for(Language language: languages) {
            System.out.println(language);
        }
    }

    /** Get languages of the books from a specific publishing-retailer */
    public static void runTestCases() {
        System.out.println("*** Get languages of the books from a specific publishing-retailer ***");

        // Testcase 1
        System.out.println("----- Testcase 1 -----");
        List<Language> languagesForRetailer = GetLanguagesForPublishingRetailerID.getLanguagesForPublishingRetailerID(1);
        printLanguages(languagesForRetailer);

        // Testcase 2
        System.out.println("----- Testcase 2 -----");
        languagesForRetailer = GetLanguagesForPublishingRetailerID.getLanguagesForPublishingRetailerID(5);
        printLanguages(languagesForRetailer);

        // Testcase 3
        System.out.println("----- Testcase 3 -----");
        languagesForRetailer = GetLanguagesForPublishingRetailerID.getLanguagesForPublishingRetailerID(17);
        printLanguages(languagesForRetailer);

        // Testcase 4
        System.out.println("----- Testcase 4 -----");
        languagesForRetailer = GetLanguagesForPublishingRetailerID.getLanguagesForPublishingRetailerID(27);
        printLanguages(languagesForRetailer);

        // Testcase 5
        System.out.println("----- Testcase 5 -----");
        languagesForRetailer = GetLanguagesForPublishingRetailerID.getLanguagesForPublishingRetailerID(35); // idx out of bounds
        printLanguages(languagesForRetailer);
        System.out.println();
    }
}
