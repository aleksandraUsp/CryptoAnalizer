package ru.javarush.uspenskaya.cryptoanalizer;

import ru.javarush.uspenskaya.cryptoanalizer.entity.Result;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {

        while (args.length == 0) {
            args = new String[4];
            Scanner scanner = new Scanner(System.in);
            boolean actionNormal;
            do {
                System.out.println("Программа криптоанализатор");
                System.out.println("Режимы работы:\n" +
                        "1.Режим шифрования текста (введите \"encode\")\n" +
                        "2.Режим дешифрования текста (введите \"decode\")\n" +
                        "3.Режим brute force (введите \"brute_force\")\n" +
                        "4.Режим статистического анализа (введите \"analysis\") \n" +
                        "5.Выход (введите \"exit\")");
                System.out.println("Выберите требуемый режим работы");
                args[0] = scanner.nextLine();                //encode
                actionNormal = (args[0].equals("encode")) || ("decode".equals(args[0])) || ("brute_force".equals(args[0])) ||
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
                    System.out.println("Введите используемый ключ:");
                    args[3] = scanner.nextLine();
                    break;

                case "decode":
                    System.out.println("Введите путь к файлу-источнику, иначе при нажатии \"Enter\" " +
                            "файлом-источником будет \\CryptoAnalizer\\text\\encode.txt");
                    args[1] = scanner.nextLine(); //encode.txt
                    System.out.println("Введите путь к файлу с результатом, иначе при нажатии \"Enter\" " +
                            "файлом с результатом работы будет \\CryptoAnalizer\\text\\text.txt");
                    args[2] = scanner.nextLine(); //text.txt
                    System.out.println("Введите используемый ключ:");
                    args[3] = scanner.nextLine();
                    break;
                case "brute_force":
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