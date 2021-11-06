package entities;

import java.util.ArrayList;
import java.util.List;

public class PublishingRetailer {
    /** Attributes */
    private int ID;
    private String name;
    List<IPublishingArtifact> publishingArtifacts = new ArrayList<>();
    private List<Country> countries = new ArrayList<>();

    /** Constructors */
    public PublishingRetailer(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    /** Getters */
    public int getID() {
        return ID;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public List<IPublishingArtifact> getPublishingArtifacts() {
        return publishingArtifacts;
    }

    /** Setters */
    public void addCountry(Country country) {
        this.countries.add(country);
    }

    /** Add IPublishingArtifact - Book */
    public void addBook(Book book) {
        this.publishingArtifacts.add(book);
    }

    /** Add IPublishingArtifact - EditorialGroup */
    public void addEditorialGroup(EditorialGroup editorialGroup) {
        this.publishingArtifacts.add(editorialGroup);
    }

    /** Add IPublishingArtifact - PublishingBrand */
    public void addPublishingBrand(PublishingBrand publishingBrand) {
        this.publishingArtifacts.add(publishingBrand);
    }

    /** Public methods*/
    @Override
    public String toString() {
        return "PublishingRetailer{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", publishingArtifacts=" + publishingArtifacts +
                ", countries=" + countries +
                '}';
    }
}
