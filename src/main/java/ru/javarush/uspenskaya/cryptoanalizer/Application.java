package ru.javarush.uspenskaya.cryptoanalizer;
import ru.javarush.uspenskaya.cryptoanalizer.controller.MainController;
import ru.javarush.uspenskaya.cryptoanalizer.entity.Result;
import ru.javarush.uspenskaya.exeptions.AppException;


import java.util.Arrays;

public class Application {
    private MainController mainController;

    public Application() {
        mainController = new MainController();
        //кодер, декодер,

    }

    public Result run(String[] args) {
        //encode text.txt encode.txt 12
        if (args.length>0) {
            String action = args[0]; //encode
            String[] parameters = Arrays.copyOfRange(args, 1, args.length);   //text.txt encode.txt 12
            return mainController.doAction(action, parameters);
        }
        throw new AppException();
    }
}
