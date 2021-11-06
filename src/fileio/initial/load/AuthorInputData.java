package fileio.initial.load;

import common.Constants;
import entities.Author;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** This is a handler class used for reading from input file and creating Authors list */
public final class AuthorInputData {
    private AuthorInputData() {}

    private static List<Author> authors = new ArrayList<>();
    public static void inputLoader() {
        try (BufferedReader br = new BufferedReader(new FileReader(Constants.AUTHORS_INPUT_PATH))) {
            br.readLine(); // Skip the first line
            String line;

            while ((line = br.readLine()) != null) {
                List<String> tokens = Arrays.asList(line.split(Constants.FIELDS_DELIMITER));

                int ID = Integer.parseInt(tokens.get(0));
                String firstName = tokens.get(1);
                String lastName = tokens.get(2);

                Author author = new Author(ID, firstName, lastName);
                authors.add(author);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Author> getAuthors() {
        return authors;
    }
}
