package EncryptDecrypt;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class FileManagementTest {

    @Test
    void openNonExistingFile() {
        var result = FileManagement.openFile("protected.txt");
        assertEquals("", result, "Opening file that not exist");
    }

    @Test
    void openNonExistingFileWithWrongExtension() {
        var result = FileManagement.openFile("protected.rar");
        assertEquals("", result, "Opening file that have wrong extension");
    }

    @Test
    void openFile() {
        var result = FileManagement.openFile("input.txt");
        assertEquals("", result, "Opening file with nothing inside");
    }

}