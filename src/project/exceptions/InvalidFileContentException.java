package project.exceptions;

public class InvalidFileContentException extends RuntimeException {
    public InvalidFileContentException(String message) {
        super(message);
    }
}
