package actions;

import entities.Book;
import entities.Language;
import fileio.ProcessInput;
import utils.FilterEntitiesByID;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class GetLanguagesForPublishingRetailerID {
    private GetLanguagesForPublishingRetailerID() {}

    /**
     * Get a list of languages in which the books from a specific publishing-retailer are written
     * @param publishingRetailerID: ID of the wanted publishing-retailer
     * @return List of desired languages
     */
    public static List<Language> getLanguagesForPublishingRetailerID(int publishingRetailerID) {
        List<Book> publishedBooks = GetBooksForPublishingRetailerID.getBooksForPublishingRetailerID(publishingRetailerID);

        List<Language> publishedLanguages = new ArrayList<>();
        for(Book book: publishedBooks) {
            Language language = FilterEntitiesByID.filterLanguagesByID(ProcessInput.getLanguages(), book.getLanguageID());
            publishedLanguages.add(language);
        }

        // Remove duplicate languages
        return publishedLanguages.stream().distinct().collect(Collectors.toList());
    }
}
