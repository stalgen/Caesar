package project.util;

import project.CommandType;
import project.exceptions.InvalidKeyException;

import static project.Constants.ALLOWED_KEY;

public class CipherKeyValidatorUtil {

    public static CommandType isArgumentsValid(String commandStr) {
        if (!ALLOWED_KEY.contains(commandStr.toUpperCase())) {
            throw new InvalidKeyException("Invalid key!");
        } else {
            return CommandType.fromString(commandStr);
        }
    }
}
