package contacts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person person;
    LocalDateTime created;
    LocalDateTime lastEdit;

    @BeforeEach
    void init() {
        LocalDate date1 = LocalDate.of(2022, 1, 13);
        person = new Person("123", "Mike", "Smith", date1, "M");
    }

    @Test
    void isCorrectGenderValid() {
        var result = Person.isCorrectGender("M");
        assertTrue(result, "Checks if the gender entered is valid");
    }

    @Test
    void isCorrectGenderInvalid() {
        var result = Person.isCorrectGender("d");
        assertFalse(result, "Checks if the invalid gender return false");
    }

    @Test
    void isCorrectBirthDateValid() {
        var result = Person.isCorrectBirthDate("123");
        assertNull(result, "Checks if the birthdate " +
                "entered is valid");
    }

    @Test
    void isCorrectBirthDateInvalid() {
        var result = Person.isCorrectBirthDate("2000-01-01");
        LocalDate date = LocalDate.parse("2000-01-01");
        assertEquals(date, result, "Checks if the birthdate " +
                "entered is valid");
    }

    @Test
    void getName() {
        var result = person.getName();
        assertEquals("Mike", result, "Checks " +
                "if getName return correct name");
    }

    @Test
    void setName() {
        person.setName("John");
        var result = person.getName();
        assertEquals("John", result, "Checks " +
                "if setName changes name");
    }

    @Test
    void getSurname() {
        var result = person.getSurname();
        assertEquals("Smith", result, "Checks " +
                "if getSurname return correct surname");
    }

    @Test
    void setSurname() {
        person.setSurname("Jobs");
        var result = person.getSurname();
        assertEquals("Jobs", result, "Checks " +
                "if setSurname changes surname");
    }

    @Test
    void getBirthDate() {
        var result = person.getBirthDate();
        LocalDate date1 = LocalDate.of(2022, 1, 13);
        assertEquals(date1, result, "Checks if " +
                "getBirthDate return correct BirthDate");
    }

    @Test
    void setBirthDate() {
        LocalDate date1 = LocalDate.of(1999, 1, 13);
        person.setBirthDate(date1);
        var result = person.getBirthDate();
        assertEquals(date1, result, "Checks if " +
                "setBirthDate changes BirthDate");
    }

    @Test
    void getGender() {
        var result = person.getGender();
        assertEquals("M", result, "Checks if " +
                "getGender return correct gender");
    }

    @Test
    void setGender() {
        person.setGender("F");
        var result = person.getGender();
        assertEquals("F", result, "Checks if " +
                "setGender changes gender");
    }

    @Test
    void info() {
        created = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        lastEdit = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        var result = person.info();
        var expected = "Name: Mike\n" +
                "Surname: Smith\n" +
                "Birth date: 2022-01-13\n" +
                "Gender: M\n" +
                "Number: 123\n" +
                "Time created: " + created + "\n" +
                "Time last edit: " + lastEdit + "\n";
        assertEquals(expected, result, "Check if info" +
                " display correct information about person");
    }

    @Test
    void testToString() {
        var result = person.toString();
        assertEquals("Mike Smith", result, "Checks if " +
        "ToString returns correct string format");
    }
}