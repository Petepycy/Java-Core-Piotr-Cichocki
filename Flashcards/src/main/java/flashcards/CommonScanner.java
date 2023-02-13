package flashcards;

import java.util.Scanner;

public class CommonScanner {

    private static final Scanner scanner = new Scanner(System.in);

    private CommonScanner() {}

    public static Scanner getScanner() {
        return scanner;
    }
}