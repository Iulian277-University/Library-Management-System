package fileio.linking;

import common.Constants;
import entities.PublishingBrand;
import entities.PublishingRetailer;
import utils.FilterEntitiesByID;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/** This is a handler class used for linking PublishingBrands to PublishingRetailers */
public final class LinkPublishingBrandsToPublishingRetailers {
    private LinkPublishingBrandsToPublishingRetailers() {}

    public static void inputLoader(List<PublishingRetailer> publishingRetailers, List<PublishingBrand> publishingBrands) {
        try (BufferedReader br = new BufferedReader(new FileReader(Constants.PUBLISHING_RETAILERS_PUBLISHING_BRANDS_INPUT_PATH))) {
            br.readLine(); // Skip the first line
            String line;

            while ((line = br.readLine()) != null) {
                List<String> tokens = Arrays.asList(line.split(Constants.FIELDS_DELIMITER));

                int retailerID = Integer.parseInt(tokens.get(0));
                int publishingBrandID = Integer.parseInt(tokens.get(1));

                PublishingRetailer filteredPublishingRetailer =
                        FilterEntitiesByID.filterPublishingRetailersByID(publishingRetailers, retailerID);
                PublishingBrand publishingBrand =
                        FilterEntitiesByID.filterPublishingBrandsByID(publishingBrands, publishingBrandID);

                if(filteredPublishingRetailer != null) {
                    filteredPublishingRetailer.addPublishingBrand(publishingBrand);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
