package contacts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class OrganizationTest {

    PhoneBook phoneBook;

    Organization organization;
    LocalDateTime created;
    LocalDateTime lastEdit;

    @BeforeEach
    void init() {
        phoneBook = new PhoneBook();
        organization = new Organization("123", "PizzaPlace", "Land 123");
    }

    @Test
    void getOrganizationName() {
        var result = organization.getOrganizationName();
        assertEquals("PizzaPlace", result, "Checks if " +
                "getOrganizationName returns correct name");
    }

    @Test
    void setOrganizationName() {
        organization.setOrganizationName("PastaPlace");
        var result = organization.getOrganizationName();
        assertEquals("PastaPlace", result, "Checks if " +
                "setOrganizationName changes name");
    }

    @Test
    void getAddress() {
        var result = organization.getAddress();
        assertEquals("Land 123", result, "Checks if " +
                "getAddress returns correct address");
    }

    @Test
    void setAddress() {
        organization.setAddress("Island 123");
        var result = organization.getAddress();
        assertEquals("Island 123", result, "Checks if " +
                "setAddress changes address");
    }

    @Test
    void info() {
        var result = organization.info();
        created = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        lastEdit = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        var expected = "Organization name: PizzaPlace\n" +
                "Address: Land 123\n" +
                "Number: 123\n" +
                "Time created: " + created + "\n" +
                "Time last edit: " + lastEdit + "\n";
        assertEquals(expected, result,"Checks if " +
                "info display correct information about organization");
    }

    @Test
    void testToString() {
        var result = organization.toString();
        assertEquals("PizzaPlace", result, "Checks if " +
                "ToString returns correct string format");
    }
}