package ru.javarush.uspenskaya.cryptoanalizer.commands;

import ru.javarush.uspenskaya.cryptoanalizer.constants.Constants;
import ru.javarush.uspenskaya.cryptoanalizer.entity.Result;
import ru.javarush.uspenskaya.cryptoanalizer.entity.ResultCode;
import ru.javarush.uspenskaya.exeptions.AppException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.TreeMap;

import static ru.javarush.uspenskaya.cryptoanalizer.commands.TableEncodeOrDecode.getTableDecodeChar;

public class BruteForce implements Action {
    TreeMap<Integer, Integer> tableBestKey = new TreeMap<>();

    @Override
    public Result execute(String[] parameters) { //parameters = [encode.txt text.txt]
        Path pathIn;
        if (parameters[0].isEmpty()) pathIn = Path.of(Constants.TXT_FOLDER + "encode.txt");
        else if ((Path.of(parameters[0])).isAbsolute()) {
            pathIn = Path.of(parameters[0]);
        } else pathIn = Path.of(Constants.TXT_FOLDER + parameters[0]);


        Path pathOut;
        if (parameters[1].isEmpty()) pathOut = Path.of(Constants.TXT_FOLDER + "text.txt");
        else if ((Path.of(parameters[1])).isAbsolute()) {
            pathOut = Path.of(parameters[1]);
        } else pathOut = Path.of(Constants.TXT_FOLDER + parameters[1]);

        if (!Files.exists(pathOut))
            try {
                Files.createFile(pathOut);
            } catch (IOException io) {
                throw new AppException("Ошибка ввода-вывода" + io.getCause());
            }



        char[] tempIn = new char[1000];
        char[] tempOut = new char[1000];


        try (BufferedReader reader = new BufferedReader(new FileReader(pathIn.toFile()))) {
            for (int key = 1; key < Constants.getAlphabetLength(); key++) { //1..95
                int numberOfGaps = 0;
                TreeMap<Character, Character> tableDecodeChar = getTableDecodeChar(key);
                int real;
                do
                {real = reader.read(tempIn, 0, tempIn.length);}
                while (real!=-1);

                for (int i = 0; i < tempIn.length; i++) {
                    tempOut[i] = tableDecodeChar.getOrDefault(tempIn[i], '☮');
                    if (tempOut[i] == ' ') numberOfGaps++;
                }
                tableBestKey.put(numberOfGaps, key);
            }
        } catch (FileNotFoundException f) {
            throw new AppException("Не найден файл\n" + f.getCause());
        } catch (IOException io) {
            throw new AppException("Ошибка ввода/вывода\n" + io.getCause());
        }
        return getResultDecode(pathIn, pathOut, getDecodeKey()); // return Result
    }


    private int getDecodeKey() {

       int maxNumberOfGaps = tableBestKey.lastKey(); //  lastKey = max numberOfGaps <numberOfGaps, key>
       return tableBestKey.get(maxNumberOfGaps); //== bestKey
    }

    private Result getResultDecode(Path pathIn, Path pathOut, int resultKey) {
        TreeMap<Character, Character> tableDecodeChar = getTableDecodeChar(resultKey);

        try (BufferedReader reader = new BufferedReader(new FileReader(pathIn.toFile()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(pathOut.toFile()))) {
            int charIn = reader.read();
            char charOut;
            while (charIn != -1) {
                charOut = tableDecodeChar.getOrDefault((char) charIn, '☮');
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
