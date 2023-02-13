package EncryptDecrypt;

import java.util.ArrayList;

public class Shift extends Algorithm{

    @Override
    public ArrayList<Character> encode(ArrayList<Character> msg, int key) {
        int charNumber;
        for (int i = 0; i < msg.size(); i++) {
            if (msg.get(i) == ' '){
                continue;
            }
            charNumber = ((msg.get(i) + key));
            if ((msg.get(i) >= 65 && msg.get(i) <= 90) || (msg.get(i) >= 97 && msg.get(i) <= 122)) {
                if (msg.get(i) >= 65 && msg.get(i) <= 90) {
                    if (charNumber >= 90) {
                        charNumber = charNumber - 90 + 64;
                    } else if (charNumber <= 65) {
                        charNumber = charNumber - 64 + 90;
                    }
                } else if (msg.get(i) >= 97 && msg.get(i) <= 122) {
                    if (charNumber >= 122) {
                        charNumber = charNumber - 122 + 96;
                    } else if (charNumber <= 96) {
                        charNumber = charNumber - 96 + 122;
                    }
                }
            } else { charNumber = msg.get(i); }
            msg.set(i, (char) charNumber);
        }
        return msg;
    }

    @Override
    public ArrayList<Character> decode(ArrayList<Character> msg, int key) {
        int charNumber;
        for (int i = 0; i < msg.size(); i++) {
            if (msg.get(i) == ' ') {
                continue;
            }
            charNumber = (msg.get(i) - key);
            if ((msg.get(i) >= 65 && msg.get(i) <= 90) || (msg.get(i) >= 97 && msg.get(i) <= 122)) {
                if (msg.get(i) >= 65 && msg.get(i) <= 90) {
                    if (charNumber >= 90) {
                        charNumber = charNumber - 90 + 64;
                    } else if (charNumber <= 65) {
                        charNumber = charNumber - 64 + 90;
                    }
                } else if (msg.get(i) >= 97 && msg.get(i) <= 122) {
                    if (charNumber >= 122) {
                        charNumber = charNumber - 122 + 96;
                    } else if (charNumber <= 96) {
                        charNumber = charNumber - 96 + 122;
                    }
                }
            } else {
                charNumber = msg.get(i);
            }
            msg.set(i, (char) charNumber);
        }
        return msg;
    }

}