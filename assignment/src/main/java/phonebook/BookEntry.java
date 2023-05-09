package phonebook;

/**
 * 
 * @author urs
 */
public class BookEntry {
    private String name;
    private String number;
    private String address;

    public BookEntry(String name, String number, String address) {
        this.name = name;
        this.number = number;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.number + ", " + this.address;
    }
}
