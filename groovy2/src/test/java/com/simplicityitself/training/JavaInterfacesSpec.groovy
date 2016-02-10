package com.simplicityitself.training

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 * <p>TODO #15: Create a JavaInterfaces class under src/main/java in the same
 * package as this test case. Also create two other classes (either in the same
 * file or use the standard class per file approach):</p>
 */
class JavaInterfacesSpec extends Specification {
    @Shared
            strings = [
                    "oranges",
                    "Lemons",
                    "pears",
                    "Figs",
                    "pineapples"]

    /**
     * TODO #16: Create a method in JavaInterfaces that returns a list of the
     * words in {@code strings} sorted by word length. In the implementation,
     * use the {@code sort ( boolean , Comparator )} method added to lists by the
     * Groovy JDK and pass in the {@code Comparator} implementation you created
     * that matches the required behaviour.
     */
    @Unroll
    def "Test that getWordsSortedByLength() returns the words sorted by length"() {
        given: "an instance of groovyInterfaces"
        def exercise = new JavaInterfaces()

        expect: "A list to be returned with the all the words sorted by length ascending"
        exercise.getWordsSortedByLength(initialList) == expected

        where:
        initialList | expected
        strings     | ["Figs", "pears", "Lemons", "oranges", "pineapples"]
        []          | []
        null        | null
    }

    /**
     * TODO #17: Create a method in GroovyInterfaces that returns a list of the
     * words in {@code strings} sorted alphabetically, ignoring case. In the
     * implementation, use the {@code sort ( boolean , Comparator )} method as in
     * the previous exercise.
     */
    @Unroll
    def "Test that getWordsSortedAlphabetically() returns the words sorted alphabetically, ignoring case"() {
        given: "an instance of groovyInterfaces"
        def exercise = new JavaInterfaces() //= new groovyInterfaces()

        expect: "A list to be returned with the all the words sorted alphabetically, ignoring case"
        exercise.getWordsSortedAlphabetically(initialList) == expected

        where:
        initialList              | expected
        strings                  | ["Figs", "Lemons", "oranges", "pears", "pineapples"]
        ["CHERRIES", "apricots"] | ["apricots", "CHERRIES"]
        []                       | []
        null                     | null
    }
}
