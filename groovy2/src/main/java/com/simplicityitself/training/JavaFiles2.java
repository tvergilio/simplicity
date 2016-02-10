package com.simplicityitself.training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Thalita on 05/10/2015.
 */
public class JavaFiles2 {

    String firstChars(String path, Integer totalCharacters) {
        Path nioPath = Paths.get(path);
        StringBuilder result = new StringBuilder();
        int i = 0;
        try (BufferedReader reader = Files.newBufferedReader(nioPath, Charset.forName("UTF-8"))) {
            while ((i = reader.read()) > -1 && result.length() < totalCharacters) {
                result.append((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    void writeBytes(String path, byte[] bytes) {
        Path nioPath = Paths.get(path);
        try (OutputStream outputStream = Files.newOutputStream(nioPath)) {
            outputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
