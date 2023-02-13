package EncryptDecrypt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UnicodeTest {

    private Unicode unicode;

    private ArrayList<Character> msg;

    @BeforeEach
    void init() {
        msg = new ArrayList<>();
        unicode = new Unicode();
    }

    @Test
    void encodeSingleCharacterWithUnicode() {
        msg.add('z');
        var result = unicode.encode(msg, 1);
        assertEquals("[{]", result.toString(), "Checks encoding with unicode algorithm");
    }

    @Test
    void encodeSingleWordWithUnicode() {
        msg.add('m');
        msg.add('i');
        msg.add('n');
        msg.add('e');
        var result = unicode.encode(msg, 1);
        assertEquals("[n, j, o, f]", result.toString(), "Checks encoding a single word with unicode algorithm");
    }

    @Test
    void encodeNonLatinCharactersWithUnicode() {
        msg.add('!');
        msg.add('b');
        msg.add('%');
        var result = unicode.encode(msg, 2);
        assertEquals("[#, d, ']", result.toString(), "Checks encoding non latin character with unicode algorithm");
    }

    @Test
    void decodeSingleCharacterWithUnicode() {
        msg.add('{');
        var result = unicode.decode(msg, 1);
        assertEquals("[z]", result.toString(), "Checks decoding with unicode algorithm");
    }

    @Test
    void decodeSingleWordWithUnicode() {
        msg.add('n');
        msg.add('j');
        msg.add('o');
        msg.add('f');
        var result = unicode.decode(msg, 1);
        assertEquals("[m, i, n, e]", result.toString(), "Checks decoding a single word with unicode algorithm");
    }

    @Test
    void decodeNonLatinCharactersWithUnicode() {
        msg.add('#');
        msg.add('d');
        msg.add('\'');
        var result = unicode.decode(msg, 2);
        assertEquals("[!, b, %]", result.toString(), "Checks decoding non latin character with unicode algorithm");
    }
}