package flashcards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlashcardTest {

    Flashcard flashcard;


    @BeforeEach
    void init() {
        flashcard = new Flashcard("PaRiS", "France", 0);
    }

    @Test
    void checkAnswer() {
        var result = flashcard.checkAnswer("France");
        assertTrue(result, "Checks if the answer(string) matches the existing definition");
    }

    @Test
    void checkAnswerIfExist() {
        var result = flashcard.checkAnswer("Paris");
        assertFalse(result, "Checks if the answer(string) matches the existing definition");
    }

    @Test
    void checkAnswerWithUpperLetter() {
        var result = flashcard.checkAnswer("FRANCE");
        assertTrue(result, "Checks if the answer(string) matches the existing definition");
    }

    @Test
    void checkHashCode() {
        var result = flashcard.hashCode();
        assertEquals(76853547, result);
    }
}