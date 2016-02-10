package com.simplicityitself.training

import spock.lang.Specification
import spock.lang.Unroll

class JavaFilesSpec extends Specification {
    final String encoding = "UTF-8"
    final String testFilePath = resolveFilePath("src/test/resources/README.txt")

    def "Calculate the byte size of a file"() {
        given: "The files exercise"
        def exercise = new JavaFiles()

        expect: "The correct size of the test file to be returned"
        exercise.fileSize(testFilePath) == 6890
    }

    def "Calculate the number of characters in a text file"() {
        given: "The files exercise"
        def exercise = new JavaFiles()

        expect: "The correct size of the test file to be returned"
        exercise.characterCount(testFilePath) == 6874
    }

    @Unroll
    def "Fetch first #count characters of a text file"() {
        given: "The files exercise"
        def exercise = new JavaFiles()

        expect: "The correct size of the test file to be returned"
        exercise.firstChars(testFilePath, count) == expected

        where:
        count | expected
        0     | ""
        1     | "L"
        20    | "Lorem ipsum dolor si"
    }

    def "Write binary data to a file"() {
        given: "The files exercise and a temporary file location"
        def exercise = new JavaFiles()
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
