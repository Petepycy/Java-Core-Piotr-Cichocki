package flashcards;

public class Main {

    public static void main(String[] args) {

        final DeckHandler deckHandler = new DeckHandler();

        for (int i = 0; i < args.length; i++) {
            if (args[i] != null && args[i].equalsIgnoreCase("-import")) {
                deckHandler.importTxt = args[i+1];
                deckHandler.importCards();
            }
            if (args[i] != null && args[i].equalsIgnoreCase("-export")) {
                deckHandler.exportTxt = args[i + 1];
                deckHandler.isExportTrue = true;
            }
        }
        Menu.MenuChoice();
    }
}
