package fileio.linking;

import common.Constants;
import entities.EditorialGroup;
import entities.PublishingRetailer;
import utils.FilterEntitiesByID;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/** This is a handler class used for linking EditorialGroups to PublishingRetailers */
public final class LinkEditorialGroupsToPublishingRetailers {
    private LinkEditorialGroupsToPublishingRetailers() {}

    public static void inputLoader(List<PublishingRetailer> publishingRetailers, List<EditorialGroup> editorialGroups) {
        try (BufferedReader br = new BufferedReader(new FileReader(Constants.PUBLISHING_RETAILERS_EDITORIAL_GROUPS_INPUT_PATH))) {
            br.readLine(); // Skip the first line
            String line;

            while ((line = br.readLine()) != null) {
                List<String> tokens = Arrays.asList(line.split(Constants.FIELDS_DELIMITER));

                int retailerID = Integer.parseInt(tokens.get(0));
                int editorialID = Integer.parseInt(tokens.get(1));


                PublishingRetailer filteredPublishingRetailer =
                        FilterEntitiesByID.filterPublishingRetailersByID(publishingRetailers, retailerID);
                EditorialGroup filteredEditorialGroup =
                        FilterEntitiesByID.filterEditorialGroupsByID(editorialGroups, editorialID);

                if(filteredPublishingRetailer != null) {
                    filteredPublishingRetailer.addEditorialGroup(filteredEditorialGroup);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
