package ru.javarush.uspenskaya.cryptoanalizer.commands;

import ru.javarush.uspenskaya.cryptoanalizer.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}
