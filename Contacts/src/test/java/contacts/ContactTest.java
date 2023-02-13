package contacts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    Contact contact;
    LocalDateTime created;
    LocalDateTime lastEdit;
    @BeforeEach
    void init() {
        contact = new Organization("", "Pizza", "Street 123");
    }
    @Test
    void isCorrectNumber() {
        var result = Contact.isCorrectNumber("123");
        assertTrue(result, "Checks if the number is valid");
    }

    @Test
    void isCorrectNumberInvalid() {
        var result = Contact.isCorrectNumber("()()");
        assertFalse(result, "Checks if the number is valid");
    }

    @Test
    void getNumber() {
        var result = contact.getNumber();
        assertEquals("", result, "Check if getNumber return correct number");
    }

    @Test
    void setNumber() {
        contact.setNumber("123");
        var result = contact.getNumber();
        assertEquals("123", result, "Check if setNumber changes number");
    }

    @Test
    void hasNumber() {
        var result = contact.hasNumber();
        assertTrue(result, "Check if number is not null");
    }

    @Test
    void info() {
        var result = contact.info();
        created = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        lastEdit = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        var expected = "Organization name: Pizza\n" +
                "Address: Street 123\n" +
                "Number: \n" +
                "Time created: " + created + "\n" +
                "Time last edit: " + lastEdit + "\n";
        assertEquals(expected, result,"Checks if " +
                "info display correct information about organization");
    }

    @Test
    void testToString() {
        var result = contact.toString();
        assertEquals("Pizza", result, "Checks if " +
                "ToString returns correct string format");
    }
}