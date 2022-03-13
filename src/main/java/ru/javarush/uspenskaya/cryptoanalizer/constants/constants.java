package ru.javarush.uspenskaya.cryptoanalizer.constants;

public class constants {
    private static final char[] RUS = new char[] {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
    private static final char[] CYPHER = new char[] {'0', '1', '2', '3', '4', '5', '6', '7','8', '9'};
    private static final char[] ZNAK = new char[] {'.', ',', '«', '»', ':', '!', '?', ' ', '{', '}',
            '[', ']', '(', ')', '@','№', ';'};
    public static final char[] ALPHABET = new char[2* RUS.length + CYPHER.length + ZNAK.length];
    //ALPHABET =RUS + (RUS.toString().toUpperCase(Locale.ROOT)).toCharArray();
}
