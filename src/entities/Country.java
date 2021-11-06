package entities;

public class Country {
    /** Attributes */
    private int ID;
    private String countryCode;

    /** Constructors */
    public Country(int ID, String countryCode) {
        this.ID = ID;
        this.countryCode = countryCode;
    }

    /** Getters */
    public int getID() {
        return ID;
    }

    /** Public methods*/
    @Override
    public String toString() {
        return "Country{" +
                "ID=" + ID +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
