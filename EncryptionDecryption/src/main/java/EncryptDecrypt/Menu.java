package EncryptDecrypt;

import java.util.ArrayList;

public class Menu {

    private String action = "enc";
    private String input = "";
    private int number = 0;
    private String inputTxt = "";
    private String outputTxt = "";
    private String algorithm = "shift";
    private boolean isIn = false;
    private boolean isOut = false;
    private boolean isData = false;
    private ArrayList<Character> msg = new ArrayList<>();

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getInputTxt() {
        return inputTxt;
    }

    public void setInputTxt(String inputTxt) {
        this.inputTxt = inputTxt;
    }

    public String getOutputTxt() {
        return outputTxt;
    }

    public void setOutputTxt(String outputTxt) {
        this.outputTxt = outputTxt;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public boolean isIn() {
        return isIn;
    }

    public void setIn(boolean in) {
        isIn = in;
    }

    public boolean isOut() {
        return isOut;
    }

    public void setOut(boolean out) {
        isOut = out;
    }

    public boolean isData() {
        return isData;
    }

    public void setData(boolean data) {
        isData = data;
    }

    public ArrayList<Character> getMsg() {
        return msg;
    }

    public void setMsg(ArrayList<Character> msg) {
        this.msg = msg;
    }

    public ArrayList<Character> add(String input, ArrayList<Character> msg) {
        for (int i = 0; i < input.length(); i++) {
            msg.add(input.charAt(i));
        }
        return msg;
    }
}
