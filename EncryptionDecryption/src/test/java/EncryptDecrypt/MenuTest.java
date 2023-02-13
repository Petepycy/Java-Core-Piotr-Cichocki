package EncryptDecrypt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    Menu menu;
    ArrayList<Character> msg;

    @BeforeEach
    void init() {
        menu = new Menu();
        msg = new ArrayList<>();
    }

    @Test
    void addStringToArray() {
        var result = menu.add("Text", msg);
        assertEquals("[T, e, x, t]", result.toString(), "Checks if " +
                "add function adds string input to char arrayList");
    }

    @Test
    void addStringWithNumbersToArray() {
        var result = menu.add("T1e2x3", msg);
        assertEquals("[T, 1, e, 2, x, 3]", result.toString(), "Checks if " +
                "add function adds string input to char arrayList");
    }

    @Test
    void getAction() {
        var result = menu.getAction();
        assertEquals("enc", result, "Checks if getAction return current action");
    }

    @Test
    void setAction() {
        menu.setAction("dec");
        var result = menu.getAction();
        assertEquals("dec", result, "Checks if setAction changes action");

    }

    @Test
    void getInput() {
        var result = menu.getInput();
        assertEquals("", result, "Checks if getInput return current input");
    }

    @Test
    void setInput() {
        menu.setInput("new");
        var result = menu.getInput();
        assertEquals("new", result, "Checks if setInput changes input");
    }

    @Test
    void getNumber() {
        var result = menu.getNumber();
        assertEquals(0, result, "Checks if getNumber return current number");
    }

    @Test
    void setNumber() {
        menu.setNumber(5);
        var result = menu.getNumber();
        assertEquals(5, result, "Checks if setNumber changes number");
    }

    @Test
    void getInputTxt() {
        var result = menu.getInputTxt();
        assertEquals("", result, "Checks if getInputTxt return current input");
    }

    @Test
    void setInputTxt() {
        menu.setInputTxt("new");
        var result = menu.getInputTxt();
        assertEquals("new", result, "Checks if getInputTxt changes input");
    }

    @Test
    void getOutputTxt() {
        var result = menu.getOutputTxt();
        assertEquals("", result, "Checks if getOutputTxt return current output");
    }

    @Test
    void setOutputTxt() {
        menu.setOutputTxt("new");
        var result = menu.getOutputTxt();
        assertEquals("new", result, "Checks if setOutputTxt changes output");
    }

    @Test
    void getAlgorithm() {
        var result = menu.getAlgorithm();
        assertEquals("shift", result, "Checks if getAlgorithm return current algorithm");
    }

    @Test
    void setAlgorithm() {
        menu.setAlgorithm("unicode");
        var result = menu.getAlgorithm();
        assertEquals("unicode", result, "Checks if setAlgorithm changes current algorithm");
    }

    @Test
    void isIn() {
        var result = menu.isIn();
        assertFalse( result, "Checks if there is any input from user");
    }

    @Test
    void isOut() {
        var result = menu.isOut();
        assertFalse( result, "Checks if there is any output from user");
    }


    @Test
    void isData() {
        var result = menu.isData();
        assertFalse( result, "Checks if there is any data from user");
    }


    @Test
    void getMsg() {
        var result = menu.getMsg();
        assertEquals("[]", result.toString(), "Checks if getMsg return current content of array");
    }

    @Test
    void setMsg() {
        msg.add('B');
        menu.setMsg(msg);
        var result = menu.getMsg();
        assertEquals("[B]", result.toString(), "Checks if setMsg changes current content of array");
    }
}