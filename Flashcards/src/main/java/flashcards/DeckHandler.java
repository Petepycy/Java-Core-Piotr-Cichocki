package flashcards;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeckHandler {

    private final Deck deck = new Deck();
    private final Scanner scanner = CommonScanner.getScanner();
    final Log log = Log.getInstance();

    String importTxt = null;
    String exportTxt = null;

    public boolean isExportTrue = false;
    public void addCard() {
        log.print("The Card:");
        String term = scanner.nextLine();
        log.print(term, true);
        term = term.trim();
        if (deck.isTermPresent(term)) {
            log.print(String.format("The card \"%s\" already exists.", term));
            return;
        }
        log.print("The definition of the card:");
        String definition = scanner.nextLine();
        log.print(definition, true);
        definition = definition.trim();
        if (deck.isDefinitionPresent(definition)) {
            log.print(String.format("The definition \"%s\" already exists.", definition));
            return;
        }
        deck.add(term, definition);
        log.print(String.format("The pair (\"%s\":\"%s\") has been added.", term, definition));
    }

    public void removeCard() {
        log.print("Which card?");
        String term = scanner.nextLine();
        log.print(term, true);
        term = term.trim();
        removeLogic(term);
    }

    private void removeLogic(String term) {
        boolean isRemoved = deck.remove(term);
        if (isRemoved) {
            log.print("The card has been removed.");
        } else {
            log.print(String.format("Can't remove \"%s\": there is no such card.", term));
        }
    }

    public void askForCards() {
        if (deck.getCards().size() == 0) {
            log.print("The deck is empty.");
            return;
        }
        log.print("How many times to ask?");
        String number = scanner.nextLine();
        log.print(number, true);
        if (!number.matches("^[1-9]\\d*$")) {
            return;
        }
        for (int i = 0; i < Integer.parseInt(number); i++) {
            askForCard();
        }
    }

    private void askForCard() {
        Flashcard card = deck.getRandomCard();
        log.print(String.format("Print the definition of \"%s\":", card.getTerm()));
        String answer = scanner.nextLine();
        log.print(answer, true);
        answer = answer.trim();
        if (card.checkAnswer(answer)) {
            log.print("Correct!");
        } else if (deck.isDefinitionPresent(answer)) {
            log.print(String.format("Wrong. The right answer is \"%s\", " +
                            "but your definition is correct for \"%s\".",
                    card.getDefinition(), deck.getByDefinition(answer).getTerm()));
        } else {
            log.print(String.format("Wrong. The right answer is \"%s\".", card.getDefinition()));
        }
    }

    public void importCards() {
        String fileName;
        if (importTxt == null) {
            log.print("File name:");
            fileName = scanner.nextLine();
        } else {
            fileName = importTxt;
        }
        log.print(fileName, true);
        fileName = fileName.trim().toLowerCase();
        int loadedCards = 0;
        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            while (fileScanner.hasNext()) {
                String nextRow = fileScanner.nextLine();
                String[] cardData = nextRow.split("::");
                if (cardData.length < 2) {
                    continue;
                }
                String term = cardData[0];
                String definition = cardData[1];
                int mistakes;
                try {
                    mistakes = Integer.parseInt(cardData[2]);
                } catch (IndexOutOfBoundsException e) {
                    mistakes = 0;
                }
                if (deck.isTermPresent(term)) {
                    deck.remove(term);
                }
                deck.add(term, definition, mistakes);
                loadedCards++;
            }
        } catch (IOException e) {
            log.print("File not found");
            return;
        }
        log.print(String.format("%d cards have been loaded.", loadedCards));
    }

    public void exportCards() {
        String fileName;
        if (exportTxt == null) {
            log.print("File name:");
            fileName = scanner.nextLine();
        } else {
            fileName = exportTxt;
        }
        log.print(fileName, true);
        fileName = fileName.trim();
        int savedCards = 0;
        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (Flashcard card : deck.getCards()) {
                writer.printf("%s::%s::%S%n", card.getTerm(), card.getDefinition(), card.getMistake());
                savedCards++;
            }
        } catch (IOException e) {
            log.print("Failed to save to the file.");
            return;
        }
        log.print(String.format("%d cards have been saved.", savedCards));
    }

    public void findHardestCard() {
        List<String> hardestTerms = new ArrayList<>();
        int maxMistakes = 0;
        for (Flashcard card : deck.getCards()) {
            if (card.getMistake() == maxMistakes) {
                hardestTerms.add(card.getTerm());
            } else if (card.getMistake() > maxMistakes) {
                maxMistakes = card.getMistake();
                hardestTerms.clear();
                hardestTerms.add(card.getTerm());
            }
        }
        printHardestTerms(hardestTerms, maxMistakes);
    }

    public void printHardestTerms(List<String> terms, int mistakes) {
        if (mistakes == 0) {
            log.print("There are no cards with errors.");
        } else if (terms.size() == 1) {
            log.print(String.format("The hardest card is \"%s\". You have %d errors answering it.",
                    terms.get(0), mistakes));
        } else {
            log.print(String.format("The hardest cards are \"%s\". You have %d errors answering them.",
                    String.join("\", \"", terms), mistakes));
        }
    }

    public void resetStats() {
        for (Flashcard card : deck.getCards()) {
            card.setMistake(0);
        }
        log.print("Card statistics have been reset.");
    }
}