package utils;

import entities.*;

import java.util.List;
import java.util.stream.Collectors;

/** This is a handler function for filtering entities given a specific ID */
public final class FilterEntitiesByID {
    private FilterEntitiesByID() {}

    // Return the editorial-group with the wantedID
    public static EditorialGroup filterEditorialGroupsByID(List<EditorialGroup> editorialGroups, int wantedID) {
        List<EditorialGroup> filteredEditorials =   editorialGroups
                                                    .stream()
                                                    .filter(g -> g.getID() == wantedID)
                                                    .collect(Collectors.toList());
        if(filteredEditorials.isEmpty()) {
            return null;
        } else {
            return filteredEditorials.get(0);
        }
    }

    // Return the publishing-retailer with the wantedID
    public static PublishingRetailer filterPublishingRetailersByID(List<PublishingRetailer> retailers, int wantedID) {
        List<PublishingRetailer> filteredRetailers = retailers
                                                    .stream()
                                                    .filter(r -> r.getID() == wantedID)
                                                    .collect(Collectors.toList());
        if(filteredRetailers.isEmpty()) {
            return null;
        } else {
            return filteredRetailers.get(0);
        }
    }

    // Return the publishing-brand with the wantedID
    public static PublishingBrand filterPublishingBrandsByID(List<PublishingBrand> publishingBrands, int wantedID) {
        List<PublishingBrand> filteredPublishingBrands =    publishingBrands
                                                            .stream()
                                                            .filter(b -> b.getID() == wantedID)
                                                            .collect(Collectors.toList());
        if(filteredPublishingBrands.isEmpty()) {
            return null;
        } else {
            return filteredPublishingBrands.get(0);
        }
    }

    // Return the book with the wantedID
    public static Book filterBooksByID(List<Book> books, int wantedID) {
        List<Book> filteredBooks =  books
                                    .stream()
                                    .filter(b -> b.getID() == wantedID)
                                    .collect(Collectors.toList());
        if(filteredBooks.isEmpty()) {
            return null;
        } else {
            return filteredBooks.get(0);
        }
    }

    // Return the author with the wantedID
    public static Author filterAuthorsByID(List<Author> authors, int wantedID) {
        List<Author> filteredAuthors =  authors
                                        .stream()
                                        .filter(a -> a.getID() == wantedID)
                                        .collect(Collectors.toList());
        if(filteredAuthors.isEmpty()) {
            return null;
        } else {
            return filteredAuthors.get(0);
        }
    }

    // Return the language with the wantedID
    public static Language filterLanguagesByID(List<Language> languages, int wantedID) {
        List<Language> filteredLanguages =  languages
                                            .stream()
                                            .filter(l -> l.getID() == wantedID)
                                            .collect(Collectors.toList());
        if(filteredLanguages.isEmpty()) {
            return null;
        } else {
            return filteredLanguages.get(0);
        }
    }

    // Return the country with the wantedID
    public static Country filterCountriesByID(List<Country> countries, int wantedID) {
        List<Country> filteredCountries =   countries
                                            .stream()
                                            .filter(c -> c.getID() == wantedID)
                                            .collect(Collectors.toList());
        if(filteredCountries.isEmpty()) {
            return null;
        } else {
            return filteredCountries.get(0);
        }
    }
}
