package org.nickb.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility class for file I/O operations.
 */
public class IOUtil {
    private static final Logger LOGGER = Logger.getLogger(IOUtil.class.getName());

    /**
     * Reads the contents of a file specified by the first argument.
     *
     * @param args
     *         the command line arguments, where the first argument is the file path
     *
     * @return a list of strings, each representing a line in the file
     * @throws RuntimeException
     *         if an I/O error occurs reading from the file
     * @throws IllegalArgumentException
     *         if no file path is provided
     * @throws FileReadException
     *         if the file cannot be read
     */
    public static String readFileAsString(String... args) throws RuntimeException {
        if (args.length == 0) {
            LOGGER.log(Level.SEVERE, "No file path provided");
            throw new IllegalArgumentException("File path must be provided as an argument");
        }
        Path filePath = null;
        try {
            filePath = Path.of(args[0]);
            return Files.readString(filePath);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "An error occurred while reading the file: " + filePath, e);
            throw new FileReadException("Failed to read the file at " + filePath, e);
        }
    }
}

/**
 * Custom exception class for file read errors.
 */
class FileReadException extends RuntimeException {
    /**
     * Constructs a new FileReadException with the specified detail message and cause.
     *
     * @param message
     *         the detail message
     * @param cause
     *         the cause of the exception
     */
    public FileReadException(String message, Throwable cause) {
        super(message, cause);
    }
}