package fileio.initial.load;

import common.Constants;
import entities.EditorialGroup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** This is a handler class used for reading from input file and creating EditorialGroups list */
public final class EditorialGroupInputData {
    private EditorialGroupInputData() {}

    private static List<EditorialGroup> editorialGroups = new ArrayList<>();

    public static void inputLoader() {
        try (BufferedReader br = new BufferedReader(new FileReader(Constants.EDITORIAL_GROUPS_INPUT_PATH))) {
            br.readLine(); // Skip the first line
            String line;

            while ((line = br.readLine()) != null) {
                List<String> tokens = Arrays.asList(line.split(Constants.FIELDS_DELIMITER));

                int ID = Integer.parseInt(tokens.get(0));
                String name = tokens.get(1);

                EditorialGroup editorialGroup = new EditorialGroup(ID, name);
                editorialGroups.add(editorialGroup);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<EditorialGroup> getEditorialGroups() {
        return editorialGroups;
    }
}
