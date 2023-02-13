package EncryptDecrypt;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmFactoryTest {

    @Test
    void getAlgorithmShift() {
        var result = AlgorithmFactory.getAlgorithm("shift");
        assertTrue(result instanceof Shift);
    }

    @Test
    void getAlgorithmUnicode() {
        var result = AlgorithmFactory.getAlgorithm("unicode");
        assertTrue(result instanceof Unicode);
    }

    @Test
    void getWrongAlgorithmUnicode() {
        var result = AlgorithmFactory.getAlgorithm("unicode");
        assertFalse(result instanceof Shift);
    }
}