package fileio.linking;

import common.Constants;
import entities.Book;
import entities.EditorialGroup;
import utils.FilterEntitiesByID;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/** This is a handler class used for linking Books to EditorialGroups */
public final class LinkBooksToEditorialGroups {
    private LinkBooksToEditorialGroups() {}

    public static void inputLoader(List<EditorialGroup> editorialGroups, List<Book> books) {
        try (BufferedReader br = new BufferedReader(new FileReader(Constants.EDITORIAL_GROUPS_BOOKS_INPUT_PATH))) {
            br.readLine(); // Skip the first line
            String line;

            while ((line = br.readLine()) != null) {
                List<String> tokens = Arrays.asList(line.split(Constants.FIELDS_DELIMITER));

                int editorialGroupID = Integer.parseInt(tokens.get(0));
                int bookID = Integer.parseInt(tokens.get(1));

                EditorialGroup filteredEditorialGroup =
                        FilterEntitiesByID.filterEditorialGroupsByID(editorialGroups, editorialGroupID);
                Book filteredBook =
                        FilterEntitiesByID.filterBooksByID(books, bookID);

                filteredEditorialGroup.addBook(filteredBook);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
