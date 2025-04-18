package project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Constants {
    public static List<String> ALLOWED_KEY = List.of("ENCRYPT", "DECRYPT", "BRUTE_FORCE");

    public static final int COMMAND_TYPE_ARG_POSITION = 0;
    public static final int FILE_ARG_POSITION = 1;
    public static final int KEY_ARG_POSITION = 2;
    public static final int MAX_ALLOWED_ARGS_COUNT = 3;
    public static final int MAX_ALLOWED_ARGS_COUNT_FOR_BRUTE_FORCE = 2;
    public static final int SHIFT_FOR_KEY_CODING = 20;
    public static final int MAX_KEY_LENGTH = 2;
    public static final int NUM_CHAR_LANGUAGE_DETERMINATION = 20;


    public static final ArrayList<Character> ALPHABET_EN = new ArrayList<>(
            Arrays.asList(
                    'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                    'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
                    'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7',
                    '8', '9', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '
            )
    );

    public static final ArrayList<Character> ALPHABET_UA = new ArrayList<>(
            Arrays.asList(
                    'а', 'б', 'в', 'г', 'ґ', 'д', 'е', 'є', 'ж', 'з', 'и', 'і', 'ї', 'й', 'к', 'л', 'м', 'н', 'о', 'п',
                    'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ю', 'я', 'А', 'Б', 'В', 'Г', 'Ґ', 'Д', 'Е',
                    'Є', 'Ж', 'З', 'И', 'і', 'Ї', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц',
                    'Ч', 'Ш', 'Щ', 'Ь', 'Ю', 'Я', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', ',', '«', '»',
                    '"', '\'', ':', '!', '?', ' '
            )
    );
}
