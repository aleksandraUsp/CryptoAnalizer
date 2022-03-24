package ru.javarush.uspenskaya.cryptoanalizer.constants;

import java.io.File;

public class Constants {
    private static final String RUS = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String CYFER = "0123456789";
    private static final String ZNAK = ".,«»:;!?{}[]()@№/\"\\";
    private static final String ALPHABET = RUS + RUS.toLowerCase() + CYFER + ZNAK + " ";
    //+RUS.toLowerCase()

    public static final String TXT_FOLDER = System.getProperty("user.dir") + File.separator + "text" + File.separator;


    public static String getALPHABET() {
        return ALPHABET;
    }

    public static int getAlphabetLength() {
        return ALPHABET.length();
    }

    public static int getKeyMax() {
        return ALPHABET.length() - 1;
    }
    public static String menu = "Программа криптоанализатор\n "+
            "Режимы работы:\n" +
            "1.Шифровка текста (введите \"encode\")\n" +
            "2.Расшифровка текста с помощью ключа (введите \"decode\")\n" +
            "3.Расшифровка текста с помощью brute force (введите \"bruteforce\")\n" +
           // "4.Режим статистического анализа (введите \"analysis\") \n" +
            "4.Выход (введите \"exit\")";

}
