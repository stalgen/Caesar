package project.cipher;

import static project.Constants.ALPHABET_EN;

public class CaesarCipher {
    public String shiftText(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {

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
}
