package project.exceptions;


public class WrongFilePathException extends RuntimeException {
    public WrongFilePathException(String message) {
        super(message);
    }
}
