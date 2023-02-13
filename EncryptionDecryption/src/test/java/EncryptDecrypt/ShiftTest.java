package EncryptDecrypt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ShiftTest {

    private ArrayList<Character> msg;
    private Shift shift;

    @BeforeEach
    void init() {
        msg = new ArrayList<>();
        shift = new Shift();
    }

    @Test
    void encodeSingleArrayWithShift() {
        msg.add('a');
        var result = shift.encode(msg, 1);
        assertEquals("[b]", result.toString(), "Checks encoding a single character with shift algorithm");
    }

    @Test
    void encodeSingleWordWithShift() {
        msg.add('a');
        msg.add('b');
        msg.add('c');
        var result = shift.encode(msg, 2);
        assertEquals("[c, d, e]", result.toString(), "Checks encoding a single word with unicode algorithm");
    }

    @Test
    void encodeIllegalCharactersWithShift() {
        msg.add('!');
        msg.add('z');
        msg.add('%');
        var result = shift.encode(msg, 2);
        assertEquals("[!, b, %]", result.toString(), "Checks encoding illegal character among one correct with shift algorithm");
    }

    @Test
    void decodeSingleCharWithShift() {
        msg.add('b');
        var result = shift.decode(msg, 1);
        assertEquals("[a]", result.toString(), "Checks decoding a single character with shift algorithm");
    }

    @Test
    void decodeSingleWordWithShift() {
        msg.add('w');
        msg.add('o');
        msg.add('w');
        var result = shift.decode(msg, 2);
        assertEquals("[u, m, u]", result.toString(), "Checks decoding a single word with shift algorithm");
    }

    @Test
    void decodeIllegalCharactersWithShift() {
        msg.add('!');
        msg.add('b');
        msg.add('%');
        var result = shift.decode(msg, 2);
        assertEquals("[!, z, %]", result.toString(), "Checks decoding illegal character among one correct with shift algorithm");
    }

}