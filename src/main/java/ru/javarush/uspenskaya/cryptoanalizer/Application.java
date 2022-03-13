package ru.javarush.uspenskaya.cryptoanalizer;

import ru.javarush.uspenskaya.cryptoanalizer.controller.MainController;
import ru.javarush.uspenskaya.cryptoanalizer.entity.Result;
import ru.javarush.uspenskaya.exeptions.AppExeption;

import java.util.Arrays;

public class Application {
    private MainController mainController;

    public Application() {
        mainController = new MainController();
        //кодер, декодер,

    }

    public Result run(String[] args) {
        if (args.length>0) {
            String action = args[0];
            String[] parameters = Arrays.copyOfRange(args, 1, args.length);
            mainController.doAction(action, parameters);
        }
        throw new AppExeption();
    }
}
