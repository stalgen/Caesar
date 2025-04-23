package project.cipher;

import static project.CommandType.DECRYPT;
import static project.Constants.*;
import static project.Constants.ALPHABET_EN;


public class BruteForceCaesar extends CaesarCipherAction {
    private final CaesarCipher cipher = new CaesarCipher();

    @Override
    public String execute(String text) {
        int key = decryptKey(text);
        return cipher.shiftText(text, -key, DECRYPT);
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
