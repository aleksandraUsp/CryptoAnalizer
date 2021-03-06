package ru.javarush.uspenskaya.cryptoanalizer.commands;

import java.util.TreeMap;

import static ru.javarush.uspenskaya.cryptoanalizer.constants.Constants.getALPHABET;
import static ru.javarush.uspenskaya.cryptoanalizer.constants.Constants.getAlphabetLength;

public class TableEncodeOrDecode {
    public static TreeMap<Character, Character> getTableEncodeChar(int key) {
        String ALPHABET = getALPHABET();
        char[] chars = ALPHABET.toCharArray();
        var tableEncodeChar = new TreeMap<Character, Character>();
        for (int i = 0; i < chars.length; i++) {
        tableEncodeChar.put(chars[i], chars[(i+key) % getAlphabetLength()]);
        }
        return tableEncodeChar;
    }
    public static TreeMap<Character, Character> getTableDecodeChar(int key) {
        String ALPHABET = getALPHABET();
        char[] chars = ALPHABET.toCharArray();
        var tableDecodeChar = new TreeMap<Character, Character>();
        for (int i = 0; i < chars.length; i++) {
            tableDecodeChar.put(chars[i], chars[(i - key+getAlphabetLength()) % getAlphabetLength()]);
        }
        return tableDecodeChar;
    }
}
