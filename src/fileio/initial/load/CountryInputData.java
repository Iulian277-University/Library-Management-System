package fileio.initial.load;

import common.Constants;
import entities.Country;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** This is a handler class used for reading from input file and creating Countries list */
public final class CountryInputData {
    private CountryInputData() {}

    private static List<Country> countries = new ArrayList<>();

    public static void inputLoader() {
        try (BufferedReader br = new BufferedReader(new FileReader(Constants.COUNTRIES_INPUT_PATH))) {
            br.readLine(); // Skip the first line
            String line;

            while ((line = br.readLine()) != null) {
                List<String> tokens = Arrays.asList(line.split(Constants.FIELDS_DELIMITER));

                int ID = Integer.parseInt(tokens.get(0));
                String countryCode = tokens.get(1);

                Country country = new Country(ID, countryCode);
                countries.add(country);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Country> getCountries() {
        return countries;
    }
}
