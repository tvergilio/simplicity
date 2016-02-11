package com.simplicityitself.training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

class JavaFiles {

    /**
     * <p>TODO #22: Calculate the size of the file at the given path.</p>
     */
    long fileSize(String path) {
        long size = 0L;
        Path nioPath = Paths.get(path);
        try {
            BasicFileAttributes attributes = Files.readAttributes(nioPath, BasicFileAttributes.class);
            size = attributes.size();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return size;
    }

    /**
     * <p>TODO #23: Calculate the number of characters in the text file at the
     * given location. You will need to read the file in order to find out this
     * information. In addition, you should ideally load it using the "UTF-8"
     * character encoding.</p>
     */
    long characterCount(String path) throws IOException {
        Path nioPath = Paths.get(path);
        long count = 0;
        try (BufferedReader reader = Files.newBufferedReader(nioPath, StandardCharsets.UTF_8)) {
            while (reader.read() != -1) {
                count++;
            }
        }
        return count;
    }

    /**
     * <p>TODO #24: Return the first <tt>count</tt> characters of a text file as
     * a string. Remember that the text file is encoded as UTF-8.</p>
     */
    String firstChars(String path, int count) throws IOException {
        Path nioPath = Paths.get(path);
        StringBuilder chars = new StringBuilder();
        try (Stream<String> lines = Files.lines(nioPath)) {
            lines.collect(ArrayList<Character>::new, (a, s) -> s.chars().mapToObj(i -> (char) i).forEach(a::add), Collection::addAll)
                    .stream()
                    .limit(count)
                    .forEach(chars::append);
        }
        return chars.toString();
    }

    /**
     * <p>TODO #25: Write some binary (byte) data to a file. The data is
     * provided as the method's second argument.</p>
     */
    void writeBytes(String path, byte[] data) throws IOException {
        Path nioPath = Paths.get(path);
        try (OutputStream outputStream = Files.newOutputStream(nioPath)) {
            outputStream.write(data);
        }
    }
}
