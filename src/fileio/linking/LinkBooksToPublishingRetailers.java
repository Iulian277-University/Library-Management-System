package fileio.linking;

import common.Constants;
import entities.Book;
import entities.PublishingRetailer;
import utils.FilterEntitiesByID;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/** This is a handler class used for linking Books to PublishingRetailers */
public final class LinkBooksToPublishingRetailers {
    private LinkBooksToPublishingRetailers() {}

    public static void inputLoader(List<PublishingRetailer> publishingRetailers, List<Book> books) {
        try (BufferedReader br = new BufferedReader(new FileReader(Constants.PUBLISHING_RETAILERS_BOOKS_INPUT_PATH))) {
            br.readLine(); // Skip the first line
            String line;

            while ((line = br.readLine()) != null) {
                List<String> tokens = Arrays.asList(line.split(Constants.FIELDS_DELIMITER));

                int retailerID = Integer.parseInt(tokens.get(0));
                int bookID = Integer.parseInt(tokens.get(1));

                PublishingRetailer filteredPublishingRetailer =
                        FilterEntitiesByID.filterPublishingRetailersByID(publishingRetailers, retailerID);
                Book filteredBook =
                        FilterEntitiesByID.filterBooksByID(books, bookID);

                if(filteredPublishingRetailer != null) {
                    filteredPublishingRetailer.addBook(filteredBook);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
