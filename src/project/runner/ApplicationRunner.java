package project.runner;

import project.CommandType;
import project.cipher.BruteForceCeasar;
import project.cipher.CaesarCipherAction;
import project.cipher.DecryptCaesar;
import project.cipher.EncryptCaesar;
import project.exceptions.InvalidArgumentsException;
import project.exceptions.InvalidFileContentException;
import project.exceptions.WrongFilePathException;
import project.util.FileService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Collectors;

import static project.CommandType.*;
import static project.Constants.*;
import static project.util.CipherKeyValidatorUtil.isArgumentsValid;

public class ApplicationRunner {
    public void run(String[] args) {

        CommandType commandType = isArgumentsValid(args[COMMAND_TYPE_ARG_POSITION]);

        if (commandType != BRUTE_FORCE) {
            if (args.length < MAX_ALLOWED_ARGS_COUNT) {
                throw new InvalidArgumentsException("Invalid arguments count!");
            }
        } else {
            if (args.length < MAX_ALLOWED_ARGS_COUNT_FOR_BRUTE_FORCE) {
                throw new InvalidArgumentsException("Invalid arguments count!");
            }
        }

        String filePath = args[FILE_ARG_POSITION];
        Path path = Path.of(filePath);
        isFileExist(path);

        String content = getFileContent(path);

        int key = 0;
        if (commandType != BRUTE_FORCE) {
            key = Integer.parseInt(args[KEY_ARG_POSITION]);
        }

        Map<CommandType, CaesarCipherAction> operations = Map.of(
                ENCRYPT, new EncryptCaesar(key),
                DECRYPT, new DecryptCaesar(key),
                BRUTE_FORCE, new BruteForceCeasar());

        String resultContent = operations.get(commandType).execute(content);

        FileService fileService = new FileService();
        fileService.writeFile(commandType, filePath, resultContent);

    }

    private String getFileContent(Path path) {
        try {
            return Files.lines(path).collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new InvalidFileContentException("Wrong file content");
        }
    }

    private void isFileExist(Path path) {
        if (Files.notExists(path)) {
            throw new WrongFilePathException("Invalid path");
        }
    }
}
