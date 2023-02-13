package flashcards;

import java.util.Scanner;

public class Menu {

    final static Scanner scanner = CommonScanner.getScanner();

    final static Log log = Log.getInstance();

    final static DeckHandler deckHandler = new DeckHandler();


    public static void MenuChoice() {
        while (true) {
            log.print("Input the action (add, remove, import, export, ask, exit" +
                    ", log, hardest card, reset stats):");
            String command = scanner.nextLine();
            log.print(command, true);
            switch (command.trim()) {
                case "add" -> deckHandler.addCard();
                case "remove" -> deckHandler.removeCard();
                case "ask" -> deckHandler.askForCards();
                case "import" -> deckHandler.importCards();
                case "export" -> deckHandler.exportCards();
                case "hardest card" -> deckHandler.findHardestCard();
                case "reset stats" -> deckHandler.resetStats();
                case "log" -> log.saveToFile();
                case "exit" -> {
                    System.out.println("Bye bye!");
                    if (deckHandler.isExportTrue) {
                        deckHandler.exportCards();
                    }
                    return;
                }
            }
            log.print("");
        }
    }
}
