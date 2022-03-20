package ru.javarush.uspenskaya.cryptoanalizer.commands;

import ru.javarush.uspenskaya.cryptoanalizer.constants.Constants;
import ru.javarush.uspenskaya.cryptoanalizer.entity.Result;
import ru.javarush.uspenskaya.cryptoanalizer.entity.ResultCode;
import ru.javarush.uspenskaya.exeptions.AppException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.TreeMap;

import static ru.javarush.uspenskaya.cryptoanalizer.commands.TableEncodeOrDecode.getTableEncodeChar;


public class Decoder implements Action {
    @Override
    public Result execute(String[] parameters) { //parameters = [encode.txt text.txt  12]
        Path pathIn;
        if (parameters[0].equals("n")) pathIn = Path.of(Constants.TXT_FOLDER + "encode.txt");
        if ((Path.of(parameters[0])).isAbsolute()) {
            pathIn = Path.of(parameters[0]);
        } else if (!(Path.of(parameters[0])).isAbsolute()) {
            pathIn = Path.of(Constants.TXT_FOLDER + parameters[0]);
        } else pathIn = Path.of(Constants.TXT_FOLDER + "encode.txt");

        Path pathOut;
        if (parameters[1].equals("n")) pathOut = Path.of(Constants.TXT_FOLDER + "text.txt");
        if ((Path.of(parameters[1])).isAbsolute()) {
            pathOut = Path.of(parameters[1]);
        } else if (!(Path.of(parameters[1])).isAbsolute()) {
            pathOut = Path.of(Constants.TXT_FOLDER + parameters[1]);
        } else pathOut = Path.of(Constants.TXT_FOLDER + "text.txt");
        if (!Files.exists(pathOut))
            try {
                Files.createFile(pathOut);
            } catch (IOException io) {
                throw new AppException("Ошибка ввода-вывода" + io.getCause());
            }

        int key;
        try {
            if (parameters[2].equals("n")) key = 12;
            else key = Integer.parseInt(parameters[2]);
        } catch (NumberFormatException n) {
            throw new AppException("некорректный ввод ключа" + n.getCause());
        }

        TreeMap<Character, Character> tableEncodeChar = getTableEncodeChar(-key);

        try (BufferedReader reader = new BufferedReader(new FileReader(pathIn.toFile()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(pathOut.toFile()))) {
            int charIn = reader.read();
            char charOut;
            while (charIn != -1) {
                charOut = tableEncodeChar.getOrDefault((char) charIn, '☮');
                writer.write(charOut);
                charIn = reader.read();
            }
            return new Result("Раскодировано.", ResultCode.ОК);
        } catch (FileNotFoundException e) {
            throw new AppException("Не найден файл\n" + e.getCause());
        } catch (IOException io) {
            throw new AppException("Ошибка ввода/вывода\n" + io.getCause());
        }

    }
}
