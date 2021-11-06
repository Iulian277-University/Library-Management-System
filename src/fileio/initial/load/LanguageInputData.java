package fileio.initial.load;

import common.Constants;
import entities.Language;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** This is a handler class used for reading from input file and creating Languages list */
public final class LanguageInputData {
    private LanguageInputData() {}

    private static List<Language> languages = new ArrayList<>();

    public static void inputLoader() {
        try (BufferedReader br = new BufferedReader(new FileReader(Constants.LANGUAGES_INPUT_PATH))) {
            br.readLine(); // Skip the first line
            String line;

            while ((line = br.readLine()) != null) {
                List<String> tokens = Arrays.asList(line.split(Constants.FIELDS_DELIMITER));

                int ID = Integer.parseInt(tokens.get(0));
                String code = tokens.get(1);
                String name = tokens.get(2);

                Language language = new Language(ID, code, name);
                languages.add(language);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Language> getLanguages() {
        return languages;
    }
}
