package com.simplicityitself.training;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>These exercises give you a chance to work with exception-based error
 * handling.
 */
public class JavaExceptions {
    /**
     * <p>TODO #26: Calculate the length of a right-angled triangle using the
     * Pythagorean Theorem. This time, check that the arguments both have
     * values greater than zero. If either of them is zero or negative, then
     * throw an {@code IllegalArgumentException} with the message "Sides must
     * have a length greater than zero". </p>
     */
    public double hypotenuseLength(double side1, double side2) throws IllegalArgumentException {
        if (side1 <= 0 || side2 <= 0) {
            throw new IllegalArgumentException("Sides must have a length greater than zero");
        }
        return Math.sqrt(side1 * side1 + side2 * side2);
    }

    /**
     * <p>TODO #27: Calculate the number of characters in a file, handling different
     * types of error:</p>
     * <ul>
     * <li>If the given path is null or empty, throw an {@code IllegalArgumentException}
     * with the message "Path is null or empty: '${&lt;valueOfPath&gt;}'"</li>
     * <li>If the path doesn't represent a file that exists, return -1</li>
     * </ul>
     * <p>In the second case, you should ideally catch the {@code FileNotFoundException}
     * that's thrown by the <tt>getText()</tt> method, just to practice exception
     * handling. In the real world, you would normally check for the existence of the
     * file first (unless you're sure it's supposed to be there).</p>
     */
    public long characterCount(final String path) {
        long count = 0L;
        if (path == null || path.isEmpty()) {
            throw new IllegalArgumentException("Path is null or empty: \'" + path + "\'");
        }
        Path pathInstance = Paths.get(path);

        try {
            count = Files.lines(pathInstance)
                    .collect(ArrayList<Character>::new, (c, s) -> s.chars().forEach(e -> c.add((char) e)), List::addAll)
                    .size();
        } catch (NoSuchFileException e) {
            return -1;
        } catch (IOException io) {
            io.printStackTrace();
        }
        return count;
    }
}
