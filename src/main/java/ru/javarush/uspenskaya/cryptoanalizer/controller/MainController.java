package ru.javarush.uspenskaya.cryptoanalizer.controller;

import ru.javarush.uspenskaya.cryptoanalizer.commands.Action;
import ru.javarush.uspenskaya.cryptoanalizer.entity.Result;

public class MainController {
    public Result doAction(String actionName, String[] parameters){
        //action==encode
        //parameters = [text.txt encode.txt 12]
        Action action = Actions.find(actionName);
        Result result= action.execute(parameters);
        return result;
    }
}
