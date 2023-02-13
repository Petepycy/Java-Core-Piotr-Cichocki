package flashcards;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Log {

    private final StringBuilder stringBuilder = new StringBuilder();
    final Scanner scanner = CommonScanner.getScanner();
    private static final Log log = new Log();

    private Log() {}

    public static Log getInstance() {
        return log;
    }

    public void print(String text) {
        print(text, false);
    }

    public void print(String text, boolean onlyLog) {
        if (!onlyLog) {
            System.out.println(text);
        }
        stringBuilder.append(text).append("\n");
    }

    public void saveToFile() {
        print("File name:");
        String fileName = scanner.nextLine();
        print(fileName, true);
        try (PrintWriter writer = new PrintWriter(fileName)) {
            writer.write(stringBuilder.toString());
        } catch (IOException e) {
            print("Failed to save the log to the file.");
            return;
        }
        print("The log has been saved.");
    }
}