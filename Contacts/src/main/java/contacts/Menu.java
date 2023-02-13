package contacts;

import java.util.Scanner;

public class Menu {

    private static final Scanner SC = new Scanner(System.in);
    private static final PhoneBook phoneBook = new PhoneBook();

    public static void start(String[] args) {
        if (args.length != 0) {
            SerializationUtils.createFile(args[0]);
        }
        menuOptions();
    }

    private static void menuOptions() {
        boolean isWorking = true;
        while (isWorking) {
            System.out.print("[menu] Enter action (add, list, search, count, exit): ");

            switch (SC.next()) {
                case "add" -> phoneBook.addContact();
                case "list" -> phoneBook.list();
                case "search" -> phoneBook.search();
                case "count" -> phoneBook.printCount();
                case "exit" -> isWorking = false;
                default -> System.out.println("Incorrect option. Try again!");
            }
        }
    }
}