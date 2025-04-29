package project.cipher;

import static project.CommandType.DECRYPT;

public class DecryptCaesar extends CaesarCipherAction {
    private final int key;
    private final CaesarCipher chiper = new CaesarCipher();

    public DecryptCaesar(int key) {
        this.key = key;
    }


    @Override
    public String execute(String text) {
        return chiper.shiftText(text, -key, DECRYPT);
    }
}
