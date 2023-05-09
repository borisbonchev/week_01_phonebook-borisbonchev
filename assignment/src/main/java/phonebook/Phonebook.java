package phonebook;

import java.util.ArrayList;
import java.util.List;

/**
 * PhoneBook class to manage contacts.
 *
 * @author urs
 */
public class Phonebook {
    private List<BookEntry> phonebook;

    /**
     * Initializes your phone book.
     */
    public Phonebook() {
        this.phonebook = new ArrayList<>();
    }

    /**
     * Adds entry to your phone book. If an entry with this name already exists,
     * just an additional phone number is added.
     *
     * @param name of a relative person
     * @param number belonging to the name.
     */
    public void addEntry(String name, String number) {
        BookEntry checkEntry = this.phonebook.stream()
                .filter(entry -> entry.getName().equals(name))
                .findAny()
                .orElse(null);
        if (checkEntry == null) {
            this.phonebook.add(new BookEntry(name, number, null));
        } else {
            checkEntry.setNumber(checkEntry.getNumber() + ", " + number);
        }
    }

    /**
     * Search your phone book by name and return all information about the
     * person with this name as text.
     *
     * @param name to lookup
     * @return all info about this person, or null if not found
     */
    public String searchByName(String name) {
        var found = this.phonebook.stream()
                .filter(entry -> (entry.getName().equals(name)))
                .findAny();
        
        return found.isPresent() ? found.toString() : null;
    }

    /**
     * Search all information belonging to a person with the given phone number.
     *
     * @param number to search
     * @return all info about the belonging person, or null if not found.
     */
    public String searchByNumber(String number) {
        var found = this.phonebook.stream()
                .filter(entry -> (entry.getNumber().equals(number)))
                .findAny();
        
        return found.isPresent() ? found.toString() : null;
    }

    /**
     * Add address to name. Adds a new address if there is no address yet,
     * otherwise the address is updated.
     *
     * @param name to add address to
     * @param address address to add
     */
    public void addAddress(String name, String address) {
        BookEntry checkEntry = this.phonebook.stream()
                .filter(entry -> (entry.getName().equals(name)))
                .findAny()
                .orElse(null);
        if (checkEntry == null) {
            this.phonebook.add(new BookEntry(name, null, address));
        } else {
            checkEntry.setAddress(address);
        }
    }

    /**
     * Delete entry from phone book.
     *
     * @param name whose entry should be deleted.
     */
    public void deleteEntry(String name) {
        BookEntry checkEntry = this.phonebook.stream()
                .filter(entry -> (entry.getName().equals(name)))
                .findAny()
                .get();
        this.phonebook.remove(checkEntry);
    }
}
