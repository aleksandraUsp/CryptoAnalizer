package ru.javarush.uspenskaya.cryptoanalizer;

import ru.javarush.uspenskaya.cryptoanalizer.constants.Constants;
import ru.javarush.uspenskaya.cryptoanalizer.entity.Result;
import java.util.Scanner;

import static ru.javarush.uspenskaya.cryptoanalizer.constants.Constants.getAlphabetLength;
import static ru.javarush.uspenskaya.cryptoanalizer.constants.Constants.getKeyMax;

public class ConsoleRunner {
    public static void main(String[] args) {
        int key;

        while (args.length == 0) {
            args = new String[4];
            Scanner scanner = new Scanner(System.in);
            boolean actionNormal;
            do {
                System.out.println(Constants.menu);
                System.out.println("Выберите требуемый режим работы");
                args[0] = scanner.nextLine();                //encode
                actionNormal = (args[0].equals("encode")) || ("decode".equals(args[0])) || ("bruteforce".equals(args[0])) ||
                        ("analysis".equals(args[0])) || ("exit".equals(args[0]));
                if (!actionNormal) {
                    System.out.println("Неверный ввод. Выберите режим, введя нужное");
                    System.out.println();
                }
                if (args[0].equals("exit")) break;
            } while (!actionNormal);
            switch (args[0]) {
                case "encode":
                    System.out.println("Введите путь к файлу-источнику, иначе при нажатии \"Enter\" " +
                            "файлом-источником будет \\CryptoAnalizer\\text\\text.txt");
                    args[1] = scanner.nextLine(); //text.txt
                    System.out.println("Введите путь к файлу с результатом, иначе при нажатии \"Enter\" " +
                            "файлом с результатом работы будет \\CryptoAnalizer\\text\\encode.txt");
                    args[2] = scanner.nextLine(); //encode.txt
                    do
                    {System.out.println("Введите используемый ключ, не превышающий "
                            + getAlphabetLength()+"(1.."+getKeyMax()+"):");

                    args[3] = scanner.nextLine();
                    key = Integer.parseInt(args[3]);}
                    while ((key<1)||(key>getKeyMax()));
                    break;

                case "decode":
                    System.out.println("Введите путь к файлу-источнику, иначе при нажатии \"Enter\" " +
                            "файлом-источником будет \\CryptoAnalizer\\text\\encode.txt");
                    args[1] = scanner.nextLine(); //encode.txt
                    System.out.println("Введите путь к файлу с результатом, иначе при нажатии \"Enter\" " +
                            "файлом с результатом работы будет \\CryptoAnalizer\\text\\text.txt");
                    args[2] = scanner.nextLine(); //text.txt
                    do
                    {System.out.println("Введите используемый ключ, не превышающий "
                            + getAlphabetLength()+"(1.."+getKeyMax()+"):");

                        args[3] = scanner.nextLine();
                        key = Integer.parseInt(args[3]);}
                    while ((key<1)||(key>getKeyMax()));
                    break;
                case "bruteforce":
                    System.out.println("Введите путь к файлу-источнику, иначе при нажатии \"Enter\" " +
                            "файлом-источником будет \\CryptoAnalizer\\text\\encode.txt");
                    args[1] = scanner.nextLine(); //encode.txt
                    System.out.println("Введите путь к файлу с результатом, иначе при нажатии \"Enter\" " +
                            "файлом с результатом работы будет \\CryptoAnalizer\\text\\text.txt");
                    args[2] = scanner.nextLine(); //text.txt
                    break;
                case "analysis":
                    System.out.println("Введите путь к файлу-источнику, иначе при нажатии \"Enter\" " +
                            "файлом-источником будет \\CryptoAnalizer\\text\\encode.txt");
                    args[1] = scanner.nextLine(); //encode.txt
                    System.out.println("Введите путь к файлу с результатом, иначе при нажатии \"Enter\" " +
                            "файлом с результатом работы будет \\CryptoAnalizer\\text\\text.txt");
                    args[2] = scanner.nextLine(); //text.txt
                    break;
                default:
                    continue;
            }
            //encode text.txt encode.txt 12
            Application application = new Application();
            Result result = application.run(args); //encode text.txt encode.txt 12

            System.out.println(result);

        }
    }
}
// int key;
//String text;
//String textEncoding;