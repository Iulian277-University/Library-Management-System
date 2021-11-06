package entities;

public class Language {
    /** Attributes */
    private int ID;
    private String code;
    private String name;

    /** Constructors */
    public Language(int ID, String code, String name) {
        this.ID = ID;
        this.code = code;
        this.name = name;
    }

    /** Getters */
    public int getID() {
        return ID;
    }

    /** Public methods*/
    @Override
    public String toString() {
        return "Language{" +
                "ID=" + ID +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
