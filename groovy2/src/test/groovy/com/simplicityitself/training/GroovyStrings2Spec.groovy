package com.simplicityitself.training

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 * TODO #8: Create a GroovyStrings class under src/main/groovy in the same
 * package as this test case.
 */
class GroovyStrings2Spec extends Specification {
    @Shared
            strings = [
                    "oranges",
                    "lemons",
                    "pears",
                    "figs",
                    "pineapples"]

    /**
     * TODO #9: Create a method in GroovyStrings that returns a list of the
     * words in {@code strings} that contain the letter 'a'.
     */
    @Unroll
    def "Test that getWordsContainingA() returns only words which contain the letter a"() {
        given: "an instance of groovyStrings2"
        def groovyStrings2 = new GroovyStrings2() //= new groovyStrings2()

        expect: "A list to be returned with all the words which contain the letter a"
        groovyStrings2.getWordsContainingA(initialList) == expected

        where:
        initialList         | expected
        strings             | ["oranges", "pears", "pineapples"]
        []                  | []
        ["cherry", "plums"] | []
        null                | null
    }

    /**
     * TODO #10: Create a method in GroovyStrings that returns a list of the
     * strings whose length is greater than 5.
     */
    @Unroll
    def "Test that getLongWords() returns only words whose length is greater than 5"() {
        given: "an instance of groovyStrings2"
        def groovyStrings2 = new GroovyStrings2() //= new groovyStrings2()

        expect: "A list to be returned with all the words whose length is greater than 5"
        groovyStrings2.getLongWords(initialList) == expected

        where:
        initialList       | expected
        strings           | ["oranges", "lemons", "pineapples"]
        []                | []
        ["figs", "plums"] | []
        null              | null
    }

    /**
     * TODO #11: Create a method in GroovyStrings that returns the first element
     * in {@code strings} that begins with the letter 'p'.
     */
   @Unroll
    def "Test that getFirstElementStartingWithP() returns the first element which starts with the letter p"() {
        given: "an instance of groovyStrings2"
        def groovyStrings2 = new GroovyStrings2() //= new groovyStrings2()

        expect: "The element #expected to be returned for #initialist"
        groovyStrings2.getFirstElementStartingWithP(initialList) == expected

        where:
        initialList         | expected
        strings             | "pears"
        []                  | null
        ["plums", "pears"]  | "plums"
        null                | null
    }


    /**
     * TODO #12: Create a method in GroovyStrings that returns a list of the
     * lengths of the words in {@code strings}.
     */
    @Unroll
    def "Test that getWordLengths() returns the lengths of words"() {
        given: "an instance of groovyStrings2"
        def groovyStrings2 = new GroovyStrings2() //= new groovyStrings2()

        expect: "A list to be returned with the lengths of all the words"
        groovyStrings2.getWordLengths(initialList) == expected

        where:
        initialList | expected
        strings     | [7, 6, 5, 4, 10]
        []          | []
        [""]        | [0]
        null        | null
    }

    /**
     * TODO #13: Create a method in GroovyStrings that returns a list of the
     * words in {@code strings} converted to all caps (you can use the
     * {@code toUpperCase ( )} method on strings).
     */
    @Unroll
    def "Test that getWordsInUppercase() returns the words in uppercase"() {
        given: "an instance of groovyStrings2"
        def groovyStrings2 = new GroovyStrings2() //= new groovyStrings2()

        expect: "A list to be returned with the all the words in uppercase"
        groovyStrings2.getWordsInUppercase(initialList) == expected

        where:
        initialList           | expected
        strings               | ["ORANGES", "LEMONS", "PEARS", "FIGS", "PINEAPPLES"]
        []                    | []
        ["ORANGES", "LeMoNS"] | ["ORANGES", "LEMONS"]
        null                  | null
    }

    /**
     * TODO #14: Create a method in GroovyStrings that returns a list of the
     * words in {@code strings} sorted by word length.
     */
    @Unroll
    def "Test that getWordsSortedByLength() returns the words sorted by length in ascending order, then alphabetically"() {
        given: "an instance of groovyStrings2"
        def groovyStrings2 = new GroovyStrings2() //= new groovyStrings2()

        expect: "A list to be returned with the all the words sorted by length ascending"
        groovyStrings2.getWordsSortedByLength(initialList) == expected

        where:
        initialList          | expected
        strings              | ["figs", "pears", "lemons", "oranges", "pineapples"]
        []                   | []
        ["melons", "lemons"] | ["lemons", "melons"]  //if same length, then sort alphabetically
        null                 | null
    }
}
