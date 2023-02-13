package contacts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ContactFactoryTest {

    ContactFactory contactFactory;
    Person person;
    Organization organization;

    @BeforeEach
    void init() {
        contactFactory = new ContactFactory();
    }

    @Test
    void createContactPerson() {
        var result = contactFactory.createContact("other");
        assertNull(result, "Check if function return null if the type is not correct");
    }

    @Test
    void createPerson() {
        String input = "";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    void createOrganization() {
        String userInput = String.format("Dan%sVega%sdanvega@gmail.com",
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        var expected = new Organization("Dan", "Vega", "danvega@gmail.com");
        //var result = contactFactory.createOrganization();

        //assertEquals(expected, result);
    }
}