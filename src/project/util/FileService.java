package project.util;

import project.CommandType;
import project.exceptions.InvalidFileContentException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class FileService {

    public void writeFile(CommandType commandType, String fileName, String content) {
        Path filePath = Path.of(getNewFileName(fileName, commandType));
        try {
            Files.createFile(filePath);
            Files.writeString(filePath, content);
        } catch (IOException e) {
            throw new InvalidFileContentException("Error creating or writing file!");
        }
    }

    private static String getNewFileName(String oldFileName, CommandType commandType) {
        int dotIndex = oldFileName.lastIndexOf(".");
        return oldFileName.substring(0, dotIndex) + "[" + commandType.toString() + "]" + oldFileName.substring(dotIndex);
    }

}
