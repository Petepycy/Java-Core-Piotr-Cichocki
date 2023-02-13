package flashcards;

import java.util.*;

public class Deck {

    private final Set<Flashcard> cards = new HashSet<>();

    public Set<Flashcard> getCards() {
        return cards;
    }

    public Flashcard getRandomCard() {
        List<Flashcard> cardList = new ArrayList<>(cards);
        int index = (int) (cardList.size() * Math.random());
        return cardList.get(index);
    }

    public void add(String term, String definition) {
        add(term, definition, 0);
    }

    public void add(String term, String definition, int mistakes) {
        Flashcard card = new Flashcard(term, definition, mistakes);
        cards.add(card);
    }

    public boolean remove(String term) {
        Flashcard card = getByTerm(term);
        if (cards.contains(card)) {
            cards.remove(card);
            return true;
        }
        return false;
    }

    public boolean isTermPresent(String term) {
        for (Flashcard card : cards) {
            if (card.getTerm().equalsIgnoreCase(term)) {
                return true;
            }
        }
        return false;
    }

    public boolean isDefinitionPresent(String def) {
        for (Flashcard card : cards) {
            if (card.getDefinition().equalsIgnoreCase(def)) {
                return true;
            }
        }
        return false;
    }

    public Flashcard getByDefinition(String def) {
        for (Flashcard card : cards) {
            if (card.getDefinition().equalsIgnoreCase(def)) {
                return card;
            }
        }
        return null;
    }

    public Flashcard getByTerm(String term) {
        for (Flashcard card : cards) {
            if (card.getTerm().equalsIgnoreCase(term)) {
                return card;
            }
        }
        return null;
    }
}