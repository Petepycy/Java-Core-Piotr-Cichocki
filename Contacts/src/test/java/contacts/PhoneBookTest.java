package contacts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {

    PhoneBook phoneBook;
    Person person;


    @BeforeEach
    void init() {
        phoneBook = new PhoneBook();
        LocalDate date1 = LocalDate.of(2017, 1, 13);
        person = new Person("123", "Mike", "Smith", date1, "M");
    }

    @Test
    void addContact() {
        phoneBook.contacts.add(person);
        assertEquals(1, phoneBook.count());
    }

    @Test
    void remove() {
        phoneBook.contacts.add(person);
        phoneBook.remove(1);
        assertEquals(0, phoneBook.count());
    }


    @Test
    void editWithNoRecords() {
        String expected = "No records to edit!";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        phoneBook.edit(1);

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        assertEquals(expected,actual);
    }

    @Test
    void count() {
        assertEquals(0, phoneBook.count());
    }

    @Test
    void printCount() {
        String expected = "The Phone Book has 0 records.";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        phoneBook.printCount();

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        assertEquals(expected,actual);
    }
}