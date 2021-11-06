package entities;

public class Author {
    /** Attributes */
    private int ID;
    private String firstName;
    private String lastName;

    /** Constructors */
    public Author(int ID, String firstName, String lastName) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /** Getters */
    public int getID() {
        return ID;
    }

    /** Public methods*/
    @Override
    public String toString() {
        return "Author{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
