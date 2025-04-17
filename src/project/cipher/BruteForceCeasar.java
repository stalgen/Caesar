package project.cipher;

public class BruteForceCeasar extends CaesarCipherAction {
    private final CaesarCipher cipher = new CaesarCipher();

    @Override
    public String execute(String text) {

        return cipher.shiftText(text, 1);
    }
}
