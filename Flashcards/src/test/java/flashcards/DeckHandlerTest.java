package flashcards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeckHandlerTest {

    DeckHandler deckHandler;

    Deck deck;

    @BeforeEach
    void init() {
        deckHandler = new DeckHandler();
        deck = new Deck();
    }


    @Test
    void addNewCard() {
        deck.add("Paris", "France");
        var size = deck.getCards().size();
        assertEquals(1, size);
    }

    @Test
    void removeCard() {
        deck.add("Berlin", "Germany");
        deck.remove("Berlin");
        var size = deck.getCards().size();
        assertEquals(0, size);
    }


    @Test
    void importCards() {
        deckHandler.importTxt = "text.txt";
        String expected = "File not found";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        deckHandler.importCards();

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        assertEquals(expected,actual);
    }

    @Test
    void printHardestTerms() {
        List<String> terms = new ArrayList<>();
        terms.add("Berlin");
        terms.add("Paris");

        String expected = "The hardest cards are \"Berlin\", \"Paris\". You have 2 errors answering them.";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        deckHandler.printHardestTerms(terms, 2);

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        assertEquals(expected,actual);
    }

    @Test
    void resetStats() {
        var result = 0;
        deck.add("Paris", "France", 2);
        for (Flashcard card : deck.getCards()) {
            card.setMistake(0);
            result = card.getMistake();
        }
        assertEquals(0, result);
    }
}