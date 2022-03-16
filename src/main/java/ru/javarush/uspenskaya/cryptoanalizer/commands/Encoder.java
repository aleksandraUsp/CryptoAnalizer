package ru.javarush.uspenskaya.cryptoanalizer.commands;

import ru.javarush.uspenskaya.cryptoanalizer.entity.Result;
import ru.javarush.uspenskaya.cryptoanalizer.entity.ResultCode;

public class Encoder implements Action {
    @Override
    public Result execute(String[] parameters) {
        //TODO something do
        return new Result("Закодировано.", ResultCode.ОК);
    }
}
