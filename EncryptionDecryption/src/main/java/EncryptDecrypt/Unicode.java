package EncryptDecrypt;

import java.util.ArrayList;

public class Unicode extends Algorithm {

    @Override
    public ArrayList<Character> encode(ArrayList<Character> msg, int key) {
        int charNumber;
        for (int i = 0; i < msg.size(); i++) {
            charNumber = msg.get(i) + key;
            msg.set(i, (char) charNumber);
        }
        return msg;
    }


    @Override
    public ArrayList<Character> decode(ArrayList<Character> msg, int key) {
        int charNumber;
        StringBuilder decodedMessage = new StringBuilder();
        for (int i = 0; i < msg.size(); i++) {
            charNumber = msg.get(i) - key;
            decodedMessage.append((char) charNumber);
            msg.set(i, (char) charNumber);
        }
        return msg;
    }
}