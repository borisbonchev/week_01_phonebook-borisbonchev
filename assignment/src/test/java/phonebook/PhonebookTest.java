package phonebook;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author urs
 */
public class PhonebookTest {
    Phonebook phonebook = new Phonebook();
    
    @Test
    public void addOnePhoneNumber() {
        phonebook.addEntry("Boris", "123-456789");
        assertThat(phonebook.searchByName("Boris"))
                .as("Added person object, phone number should be found.")
                .contains("123-456789");
    }
    
    @Test
    public void phonebookSearchByNameNotFound() {
        assertThat(phonebook.searchByName("Boris"))
                .as("Person should not be found in the phonebook.")
                .isNull();
    }
    
    @Test
    public void addMultiplePhoneNumbers() {
        phonebook.addEntry("Boris", "123-456789");
        phonebook.addEntry("Boris", "234-567891");
        assertThat(phonebook.searchByName("Boris"))
                .as("An added person, phone number should be found")
                .contains("123-456789, 234-567891");
    }
    
    @Test
    public void searchPhoneNumberByName() {
        phonebook.addEntry("Boris", "123-456789");
        assertThat(phonebook.searchByName("Boris"))
                .as("Should return number for the relative person.")
                .contains("123-456789");
    }
    
    @Test
    public void searchByPhoneNumber() {
        phonebook.addEntry("Boris", "123-456789");
        assertThat(phonebook.searchByNumber("123-456789"))
                .as("Should return the correspoding name.")
                .contains("Boris");
    }
    
    @Test
    public void addAddressToPerson() {
        phonebook.addEntry("Boris", "123-456789");
        phonebook.addAddress("Boris", "Test address 67, Venlo");
        assertThat(phonebook.searchByName("Boris"))
                .as("Should add an address to the coresponding person.")
                .contains("Test address 67, Venlo");
    }
    
    @Test
    public void searchAddressAndNumberByName() {
        phonebook.addEntry("Boris", "123-456789");
        phonebook.addAddress("Boris", "Test address 67, Venlo");
        assertThat(phonebook.searchByName("Boris"))
                .as("Should return the appropriate address and phone number.")
                .contains("123-456789", "Test address 67, Venlo");
    }
    
    @Test
    public void deletePersonInformation() {
        phonebook.addEntry("Boris", "123-456789");
        phonebook.addAddress("Boris", "Test address 67, Venlo");
        phonebook.deleteEntry("Boris");
        assertThat(phonebook.searchByName("Boris"))
                .as("Should return null as the person is deleted from the Map.")
                .isNull();
    }

    @Test
    public void searchAddress() {
        phonebook.addEntry("Boris", "123-456789");
        phonebook.addAddress("Boris", "Test address 67, Venlo");
        assertThat(phonebook.searchByName("Boris"))
                .as("after add, parts of the address required")
                .contains("Test address 67, Venlo");
    }
}
