package project.cipher;

import project.CommandType;

import static project.CommandType.*;
import static project.Constants.*;

public class CaesarCipher {
    public String shiftText(String text, int key, CommandType commandType) {
        int shift = key;
        StringBuilder result = new StringBuilder();

        int index = 0;

        if (commandType == ENCRYPT) {
            encryptKey(result, shift);
        }
        if (commandType == BRUTE_FORCE) {
            shift = decryptKey(text);
        }

        for (char c : text.toCharArray()) {
            if (commandType != ENCRYPT && index < MAX_KEY_LENGTH) {
                index++;
                continue;
            }
            int indexInAlphabet = ALPHABET_EN.indexOf(c);
            char resultSymbol;
            if (indexInAlphabet == -1) {
                resultSymbol = c;
            } else {
                resultSymbol = ALPHABET_EN.get((ALPHABET_EN.size() + indexInAlphabet + shift) % ALPHABET_EN.size());
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

    private int decryptKey(String text) {
        String keyStr = text.substring(0, MAX_KEY_LENGTH);
        String decryptKey = "";
        for (char c : keyStr.toCharArray()) {
            int indexInAlphabet = ALPHABET_EN.indexOf(c);
            decryptKey = decryptKey + ALPHABET_EN.get((ALPHABET_EN.size() + indexInAlphabet - SHIFT_FOR_KEY_CODING) % ALPHABET_EN.size());

        }
        return Integer.parseInt(decryptKey);
    }
}


