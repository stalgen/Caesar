package project.cipher;

import project.CommandType;
import java.util.ArrayList;
import static project.CommandType.*;
import static project.Constants.*;

public class CaesarCipher {
    public String shiftText(String text, int key, CommandType commandType) {

        StringBuilder result = new StringBuilder();

        int index = 0;

        if (commandType == ENCRYPT) {
            encryptKey(result, key);
        }

        ArrayList<Character> ALPHABET = defineLanguage(text);

        for (char c : text.toCharArray()) {
            if (commandType != ENCRYPT && index < MAX_KEY_LENGTH) {
                index++;
                continue;
            }
            int indexInAlphabet = ALPHABET.indexOf(c);
            char resultSymbol;
            if (indexInAlphabet == -1) {
                resultSymbol = c;
            } else {
                resultSymbol = ALPHABET.get((ALPHABET.size() + indexInAlphabet + key) % ALPHABET.size());
            }
            result.append(resultSymbol);
        }
        return result.toString();
    }

    private void encryptKey(StringBuilder result, int shift) {
        String shiftStr = shift % ALPHABET_EN.size() < MAX_KEY_LENGTH ? "0" + shift % ALPHABET_EN.size() : "" + shift % ALPHABET_EN.size();
        for (char c : shiftStr.toCharArray()) {
            int indexInAlphabet = ALPHABET_EN.indexOf(c);
            char resultSymbol = ALPHABET_EN.get((ALPHABET_EN.size() + indexInAlphabet + SHIFT_FOR_KEY_CODING) % ALPHABET_EN.size());
            result.append(resultSymbol);
        }
    }

    private ArrayList<Character> defineLanguage(String text) {
        int numberOfCharacters = 0;
        int maxNumber = Math.min(NUM_CHAR_LANGUAGE_DETERMINATION, text.length());
        int entryIntoALPHABET_EN = 0;
        int entryIntoALPHABET_UA = 0;
        for (char c : text.toCharArray()) {
            if (numberOfCharacters > maxNumber) {
                break;
            }
            if (ALPHABET_EN.contains(c)) {
                entryIntoALPHABET_EN++;
            }
            if (ALPHABET_UA.contains(c)) {
                entryIntoALPHABET_UA++;
            }
            numberOfCharacters++;
        }

        return entryIntoALPHABET_EN >= entryIntoALPHABET_UA ? ALPHABET_EN : ALPHABET_UA;
    }
}


