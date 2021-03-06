package com.simplicityitself.training

import spock.lang.Specification
import spock.lang.Unroll

/**
 * TODO #18: Create a JavaFiles2 class under src/main/groovy in the same
 * package as this test case.
 */
class JavaFiles2Spec extends Specification {
    final String encoding = "UTF-8"
    final String testFilePath = resolveFilePath("src/test/resources/README.txt")

    /**
     * TODO #19: Add a {@code firstChars ( )} method to {@code JavaFiles2} that
     * only reads as many characters as requested, i.e. by creating a Reader.
     * See the Java API docs to see how readers work.
     */
    @Unroll
    def "Fetch first #count characters of a text file"() {
        given: "The files exercise"
        def exercise = new JavaFiles2()

        expect: "The first n characters to be returned as a string"
        exercise.firstChars(testFilePath, count) == expected

        where:
        count | expected
        0     | ""
        1     | "L"
        20    | "Lorem ipsum dolor si"
    }

    /**
     * TODO #20: Add a {@code writeBytes ( )} method to {@code JavaFiles2} that
     * uses an {@code OutputStream} to write the given bytes to a file.
     */
    def "Write binary data to a file"() {
        given: "The files exercise and a temporary file location"
        def exercise = new JavaFiles2()
        def destFile = File.createTempFile("training-", "")
        destFile.deleteOnExit()

        and: "Some test text"
        def text = "To be or not to be, that is the question."

        when: "I write the bytes of that test string to a file"
        exercise.writeBytes(destFile.absolutePath, text.getBytes(encoding))

        then: "The file contains the original text"
        destFile.getText(encoding) == text
    }

    private String resolveFilePath(String path) {
        def parentDir = System.getProperty("project.root.dir")
        if (parentDir) return new File(parentDir, path).path
        else return path
    }
}
