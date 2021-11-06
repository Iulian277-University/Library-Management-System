package fileio.linking;

import common.Constants;
import entities.Author;
import entities.Book;
import utils.FilterEntitiesByID;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/** This is a handler class used for linking Authors to Books */
public final class LinkAuthorsToBooks {
    private LinkAuthorsToBooks() {}

    public static void inputLoader(List<Book> books, List<Author> authors) {
        try (BufferedReader br = new BufferedReader(new FileReader(Constants.BOOKS_AUTHORS_INPUT_PATH))) {
            br.readLine(); // Skip the first line
            String line;

            while ((line = br.readLine()) != null) {
                List<String> tokens = Arrays.asList(line.split(Constants.FIELDS_DELIMITER));

                int bookID = Integer.parseInt(tokens.get(0));
                int authorID = Integer.parseInt(tokens.get(1));

                Book filteredBook = FilterEntitiesByID.filterBooksByID(books, bookID);
                Author filteredAuthor = FilterEntitiesByID.filterAuthorsByID(authors, authorID);
                filteredBook.addAuthor(filteredAuthor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
