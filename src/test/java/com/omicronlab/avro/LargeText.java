package com.omicronlab.avro;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LargeText {
    public static String text;

    static {
        try {
            text = new String(Files.readAllBytes(Path.of("src/test/java/com/omicronlab/avro/test.txt")));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
