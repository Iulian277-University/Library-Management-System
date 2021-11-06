package main.testcases;

import actions.GetCountriesForBookID;
import entities.Country;

import java.util.List;

/** This is a handler class used for Testing GetCountriesForBookID Method */
public final class TestGetCountriesForBookID {
    private TestGetCountriesForBookID() {}

    private static void printCountries(List<Country> countries) {
        for(Country country: countries) {
            System.out.println(country);
        }
    }

    /** Get countries for a specific book */
    public static void runTestCases() {
        System.out.println("*** Get countries for a specific book ***");

        // Testcase 1
        System.out.println("----- Testcase 1 -----");
        List<Country> countriesForBook = GetCountriesForBookID.getCountriesForBookID(262);
        printCountries(countriesForBook);

        // Testcase 2
        System.out.println("----- Testcase 2 -----");
        countriesForBook = GetCountriesForBookID.getCountriesForBookID(1353);
        printCountries(countriesForBook);


        // Testcase 3
        System.out.println("----- Testcase 3 -----");
        countriesForBook = GetCountriesForBookID.getCountriesForBookID(11738);
        printCountries(countriesForBook);

        // Testcase 4
        System.out.println("----- Testcase 4 -----");
        countriesForBook = GetCountriesForBookID.getCountriesForBookID(14407);
        printCountries(countriesForBook);

        // Testcase 5
        System.out.println("----- Testcase 5 -----");
        countriesForBook = GetCountriesForBookID.getCountriesForBookID(717); // doesn't exist a book with this idx
        printCountries(countriesForBook);
        System.out.println();
    }
}
