package EncryptDecrypt;

import java.util.ArrayList;

public abstract class Algorithm {
    public abstract ArrayList<Character> encode(ArrayList<Character> msg, int key);
    public abstract ArrayList<Character> decode(ArrayList<Character> msg, int key);
}
