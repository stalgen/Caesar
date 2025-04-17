package project.cipher;

import static project.CommandType.BRUTE_FORCE;

public class BruteForceCeasar extends CaesarCipherAction {
    private final CaesarCipher cipher = new CaesarCipher();

    @Override
    public String execute(String text) {
        return cipher.shiftText(text, 0, BRUTE_FORCE);
    }
}
