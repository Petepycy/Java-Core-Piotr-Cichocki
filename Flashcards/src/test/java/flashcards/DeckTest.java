package flashcards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    Set<Flashcard> cards;
    Flashcard flashcard;

    Deck deck;

    @BeforeEach
    void init() {
        deck = new Deck();
        cards = new HashSet<>();
        flashcard = new Flashcard("PaRiS", "France", 0);
        deck.add("Paris", "France");
    }

    @Test
    void get1Cards() {
        var result = deck.getCards();
        assertEquals("[flashcards.Flashcard@495296b]", result.toString(), "Checks if the get card method is working correctly");
    }

    @Test
    void get2Cards() {
        deck.add("Berlin", "Germany");
        var result = deck.getCards();
        assertEquals("[flashcards.Flashcard@766493c2, flashcards.Flashcard@495296b]", result.toString(), "Checks if the get card method is working correctly");
    }

    @Test
    void testAdd() {
        deck.add("Berlin", "Germany");
        var size = deck.getCards().size();
        assertEquals(2, size);
    }

    @Test
    void removeExisting() {
        var result = deck.remove("Paris");
        assertTrue(result);
    }

    @Test
    void removeNonExisting() {
        var result = deck.remove("Berlin");
        assertFalse(result);
    }

    @Test
    void isTermPresentExisting() {
        var result = deck.isTermPresent("Paris");
        assertTrue(result, "Checks if the term exist");
    }

    @Test
    void isTermPresentExistingWithLetterCase() {
        var result = deck.isTermPresent("Paris");
        assertTrue(result, "Checks if the term exist with upper case letter");
    }

    @Test
    void isTermPresentNonExisting() {
        var result = deck.isTermPresent("Berlin");
        assertFalse(result, "Checks if the term doesn't exist");
    }

    @Test
    void isDefinitionPresent() {
        var result = deck.isDefinitionPresent("France");
        assertTrue(result, "Checks if the definition exist");
    }

    @Test
    void isDefinitionPresentNonExisting() {
        var result = deck.isDefinitionPresent("Germany");
        assertFalse(result, "Checks if the definition doesnt exist");
    }

    @Test
    void isDefinitionPresentExistingWithLetterCase() {
        var result = deck.isDefinitionPresent("PaRiS");
        assertFalse(result, "Checks if the definition exist with upper case letter");
    }

    @Test
    void getByDefinition() {
        var result = deck.getByDefinition("France");
        assertEquals("France", result.getDefinition(), "Checks if definition exist in deck");
    }

    @Test
    void getByTerm() {
        var result = deck.getByTerm("Paris");
        assertEquals("Paris", result.getTerm(), "Checks if term exist in deck");
    }

    @Disabled
    @Test
    void getByTermInvalid() {
        var result = deck.getByTerm("Paris");
        assertEquals("France", result.getTerm());
    }
}