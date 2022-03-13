package ru.javarush.uspenskaya.cryptoanalizer;

import ru.javarush.uspenskaya.cryptoanalizer.entity.Result;

public class ConsoleRunner {
    public static void main(String[] args) {
        Application application = new Application();
        Result result = application.run(args);
        System.out.println(result); //оформить вывод рез-та

    }
}
// int key;
//String text;
//String textEncoding;