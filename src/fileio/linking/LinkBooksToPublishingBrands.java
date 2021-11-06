package fileio.linking;

import common.Constants;
import entities.Book;
import entities.PublishingBrand;
import utils.FilterEntitiesByID;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/** This is a handler class used for linking Books to PublishingBrands */
public final class LinkBooksToPublishingBrands {
    private LinkBooksToPublishingBrands() {}

    public static void inputLoader(List<PublishingBrand> publishingBrands, List<Book> books) {
        try (BufferedReader br = new BufferedReader(new FileReader(Constants.PUBLISHING_BRANDS_BOOKS_INPUT_PATH))) {
            br.readLine(); // Skip the first line
            String line;

            while ((line = br.readLine()) != null) {
                List<String> tokens = Arrays.asList(line.split(Constants.FIELDS_DELIMITER));

                int publishingBrandID = Integer.parseInt(tokens.get(0));
                int bookID = Integer.parseInt(tokens.get(1));

                PublishingBrand filteredPublishingBrand =
                        FilterEntitiesByID.filterPublishingBrandsByID(publishingBrands, publishingBrandID);
                Book filteredBook =
                        FilterEntitiesByID.filterBooksByID(books, bookID);

                filteredPublishingBrand.addBook(filteredBook);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
