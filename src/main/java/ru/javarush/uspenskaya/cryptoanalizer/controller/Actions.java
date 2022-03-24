package ru.javarush.uspenskaya.cryptoanalizer.controller;

import ru.javarush.uspenskaya.cryptoanalizer.commands.Action;
import ru.javarush.uspenskaya.cryptoanalizer.commands.BruteForce;
import ru.javarush.uspenskaya.cryptoanalizer.commands.Decoder;
import ru.javarush.uspenskaya.cryptoanalizer.commands.Encoder;
import ru.javarush.uspenskaya.exeptions.AppException;

public enum Actions {

    ENCODE (new Encoder()),
    DECODE (new Decoder()),
    BRUTEFORCE (new BruteForce());

    //ANALYSIS (new Analysis ());


    private final Action action;

    Actions(Action action) {
        this.action = action;
    }
    public static Action find(String actionName){
        try {
            Actions value = Actions.valueOf(actionName.toUpperCase()); //ищет по action команду
            return value.action;
        } catch (IllegalArgumentException e) {
            throw new AppException();
        }
    }
}
