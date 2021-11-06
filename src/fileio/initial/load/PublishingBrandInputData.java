package fileio.initial.load;

import common.Constants;
import entities.PublishingBrand;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** This is a handler class used for reading from input file and creating PublishingBrands list */
public final class PublishingBrandInputData {
    private PublishingBrandInputData() {}

    private static List<PublishingBrand> publishingBrands = new ArrayList<>();

    public static void inputLoader() {
        try (BufferedReader br = new BufferedReader(new FileReader(Constants.PUBLISHING_BRANDS_INPUT_PATH))) {
            br.readLine(); // Skip the first line
            String line;

            while ((line = br.readLine()) != null) {
                List<String> tokens = Arrays.asList(line.split(Constants.FIELDS_DELIMITER));

                int ID = Integer.parseInt(tokens.get(0));
                String name = tokens.get(1);

                PublishingBrand publishingBrand = new PublishingBrand(ID, name);
                publishingBrands.add(publishingBrand);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<PublishingBrand> getPublishingBrands() {
        return publishingBrands;
    }
}
