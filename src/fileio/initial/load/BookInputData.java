package fileio.initial.load;

import entities.*;
import common.Constants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

/** This is a handler class used for reading from input file and creating Books list */
public final class BookInputData {
    private BookInputData() {}

    private static List<Book> books = new ArrayList<>();

    public static void inputLoader() {
        try (BufferedReader br = new BufferedReader(new FileReader(Constants.BOOKS_INPUT_PATH))) {
            br.readLine(); // Skip the first line
            String line;

            while ((line = br.readLine()) != null) {
                List<String> tokens = Arrays.asList(line.split(Constants.FIELDS_DELIMITER));

                int ID = Integer.parseInt(tokens.get(0));
                String name = tokens.get(1);
                String subtitle = tokens.get(2);
                String ISBN = tokens.get(3);
                int pageCount = Integer.parseInt(tokens.get(4));
                List<String> keywords = Arrays.asList(tokens.get(5));
                int languageID = Integer.parseInt(tokens.get(6));

                DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy HH:mm:ss");
                Date createdOn = dateFormat.parse(tokens.get(7));

                Book book = new Book(ID, name, subtitle, ISBN, pageCount, keywords, languageID, createdOn);
                books.add(book);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public static List<Book> getBooks() {
        return books;
    }
}
