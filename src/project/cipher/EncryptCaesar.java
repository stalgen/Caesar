package project.cipher;

import static project.CommandType.ENCRYPT;

public class EncryptCaesar extends CaesarCipherAction {
    private final int key;
    private final CaesarCipher cipher = new CaesarCipher();

    public EncryptCaesar(int key) {
        this.key = key;
    }


    @Override
    public String execute(String text) {
        return cipher.shiftText(text, key, ENCRYPT);
    }
}
