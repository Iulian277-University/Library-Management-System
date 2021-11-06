package fileio.linking;

import common.Constants;
import entities.Country;
import entities.PublishingRetailer;
import utils.FilterEntitiesByID;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/** This is a handler class used for linking Countries to PublishingRetailers */
public final class LinkCountriesToPublishingRetailers {
    private LinkCountriesToPublishingRetailers() {}

    public static void inputLoader(List<PublishingRetailer> publishingRetailers, List<Country> countries) {
        try (BufferedReader br = new BufferedReader(new FileReader(Constants.PUBLISHING_RETAILERS_COUNTRIES_INPUT_PATH))) {
            br.readLine(); // Skip the first line
            String line;

            while ((line = br.readLine()) != null) {
                List<String> tokens = Arrays.asList(line.split(Constants.FIELDS_DELIMITER));

                int retailerID = Integer.parseInt(tokens.get(0));
                int countryID = Integer.parseInt(tokens.get(1));

                PublishingRetailer filteredPublishingRetailer =
                        FilterEntitiesByID.filterPublishingRetailersByID(publishingRetailers, retailerID);
                Country filteredCountry = FilterEntitiesByID.filterCountriesByID(countries, countryID);

                if(filteredPublishingRetailer != null) {
                    filteredPublishingRetailer.addCountry(filteredCountry);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
