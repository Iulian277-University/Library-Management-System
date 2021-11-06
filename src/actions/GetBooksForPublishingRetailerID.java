package actions;

import entities.*;
import fileio.ProcessInput;
import utils.FilterEntitiesByID;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class GetBooksForPublishingRetailerID {
    private GetBooksForPublishingRetailerID() {}

    /**
     * Create a list with all the books for a specific publishing-retailer
     * @param publishingRetailerID: ID of the wanted publishing-retailer
     * @return List with all the retailer's books
     */
    public static List<Book> getBooksForPublishingRetailerID(int publishingRetailerID) {
        PublishingRetailer publishingRetailer =
                FilterEntitiesByID.filterPublishingRetailersByID(ProcessInput.getPublishingRetailers(), publishingRetailerID);

        // If the retailer's ID isn't in the database
        if(publishingRetailer == null) {
            System.out.println("The publishing-retailer with the ID " + publishingRetailerID + " doesn't exist");
            return Collections.emptyList();
        }

        List<Book> publishedBooks = new ArrayList<>();
        List<IPublishingArtifact> artifacts = publishingRetailer.getPublishingArtifacts();
        for(IPublishingArtifact artifact: artifacts) {
            if(artifact instanceof Book) {
                publishedBooks.add((Book) artifact);
            } else if(artifact instanceof EditorialGroup) {
                publishedBooks.addAll(((EditorialGroup) artifact).getBooks());
            } else if(artifact instanceof PublishingBrand) {
                publishedBooks.addAll(((PublishingBrand) artifact).getBooks());
            }
        }

        // Remove duplicate books
        return publishedBooks.stream().distinct().collect(Collectors.toList());
    }
}
