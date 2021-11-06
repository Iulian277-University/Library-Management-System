package fileio.initial.load;

import common.Constants;
import entities.PublishingRetailer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** This is a handler class used for reading from input file and creating PublishingRetailers list */
public final class PublishingRetailerInputData {
    private PublishingRetailerInputData() {}

    private static List<PublishingRetailer> publishingRetailers = new ArrayList<>();

    public static void inputLoader() {
        try (BufferedReader br = new BufferedReader(new FileReader(Constants.PUBLISHING_RETAILERS_INPUT_PATH))) {
            br.readLine(); // Skip the first line
            String line;

            while ((line = br.readLine()) != null) {
                List<String> tokens = Arrays.asList(line.split(Constants.FIELDS_DELIMITER));

                int ID = Integer.parseInt(tokens.get(0));
                String name = tokens.get(1);

                PublishingRetailer publishingRetailer = new PublishingRetailer(ID, name);
                publishingRetailers.add(publishingRetailer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<PublishingRetailer> getPublishingRetailers() {
        return publishingRetailers;
    }
}
