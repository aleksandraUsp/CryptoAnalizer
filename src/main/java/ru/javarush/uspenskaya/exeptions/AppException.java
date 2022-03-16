package ru.javarush.uspenskaya.exeptions;

public class AppException extends RuntimeException{
    public AppException() {
    }

    public AppException(String message) {
        System.out.println(message);
    }
}
