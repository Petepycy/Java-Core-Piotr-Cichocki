package EncryptDecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileManagement {
    private static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));

    }

    public static String openFile(String inputTxt) {
        String pathToFile = "./" + inputTxt;
        String fileCon = "";
        try {
            fileCon = readFileAsString(pathToFile);
        } catch (IOException e) {
            System.out.println("Cannot read file: " + e.getMessage());
        }
        return fileCon;
    }
    public static void writeFile(String outputTxt, String message) {
        File file = new File("./" + outputTxt);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(message);
        } catch (IOException e) {
            System.out.printf("An exception occurred %s", e.getMessage());
        }
    }
}