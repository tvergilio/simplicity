package com.simplicityitself.training

import spock.lang.Specification
import spock.lang.Unroll

class JavaExceptionsSpec extends Specification {

    @Unroll
    def "Handle invalid arguments when calculating hypotenuse for sides #sideA & #sideB"() {
        given: "The exceptions exercise"
        def exercise = new JavaExceptions()

        when: "I calculate the hypoteneuse with invalid side lengths"
        exercise.hypotenuseLength(sideA, sideB)

        then: "An IllegalArgumentException is thrown with the appropriate message"
        def ex = thrown(IllegalArgumentException)
        ex.message == "Sides must have a length greater than zero"

        where:
        sideA | sideB
        0     | 4
        4     | 0
        -1.23 | -2.67
    }

    def "Handle errors when calculating the byte size of a file"() {
        given: "The exceptions exercise"
        def exercise = new JavaExceptions()

        when: "I try to find the size of a null or empty path"
        exercise.characterCount(testFilePath)

        then: "The appropriate exception is thrown"
        def ex = thrown(IllegalArgumentException)
        ex.message == "Path is null or empty: '${value}'"

        where:
        testFilePath | value
        null         | 'null'
        ""           | ''
    }

    def "test the characterCount method to practice working with Streams"() {
        given: "The exceptions exercise"
        def exercise = new JavaExceptions()

        when: "I try to find the size of an existing path"
        def result = exercise.characterCount("files/testFile.txt")

        then: "The correct value is returned"
        result == 10
    }

    def "Calculate the byte size of a non-existent file"() {
        given: "The exceptions exercise"
        def exercise = new JavaExceptions()

        expect: "A result of -1 for a non-existent file"
        exercise.characterCount("path/to/README") == -1
    }
}
