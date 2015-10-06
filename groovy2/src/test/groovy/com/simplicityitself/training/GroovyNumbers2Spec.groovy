package com.simplicityitself.training

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 * <p>TODO #1: Create a GroovyNumbers2 class under src/main/groovy in the same
 * package as this test case. You should try to use closure-based methods
 * to implement the methods under test. You will only need to use the ones
 * in the introduction to closures provided as part of the course. The methods
 * you add to {@code GroovyNumbers2} may be one-liners.</p>
 * <p>If you're already familiar with the Groovy JDK methods for collections
 * and maps that use closures, try using the
 * <a href="http://www.oracle.com/technetwork/articles/java/ma14-java-se-8-streams-2177646.html">Java 8 Streams API</a>
 * instead. Closures can be used in place of Java 8 lambda functions without
 * any special syntax, so it's easy. Note that the Java 8 methods are named
 * differently (I'd argue more appropriately) than the corresponding Groovy
 * ones.</p>
 */
class GroovyNumbers2Spec extends Specification {
    @Shared
            numberList = [1, 5, -8, 10, 15, 34, -12]

    /**
     * TODO #2: Create a method in GroovyNumbers2 that returns a list of the
     * positive numbers (> 0) in {@code numberList}. Don't forget to write
     * the test feature method for it first! Once you have the code working
     * for {@code numberList}, add data sets for an empty list, a list with
     * only negative numbers and a list with only positive numbers.
     */

    @Unroll
    def "Test that getPositiveNumbers() returns only positive numbers"() {
        given: "an instance of GroovyNumbers2"
        def groovyNumbers = new GroovyNumbers2() //= new GroovyNumbers2()

        expect: "A list to be returned with only the positive numbers"
        groovyNumbers.getPositiveNumbers(initialList) == expected

        where:
        initialList      | expected
        numberList       | [1, 5, 10, 15, 34]
        []               | []
        [-1, -2, -4, -9] | []
        null             | null
    }

    /**
     * TODO #3: Create a method in GroovyNumbers2 that returns a list of the
     * numbers whose magnitude is greater than 10 (numbers have an {@code abs ( )}
     * method that gives you the magnitude).
     */
    @Unroll
    def "Test that getMagnitudeGreaterThanTen() returns only numbers with magnitude greater than 10"() {
        given: "an instance of GroovyNumbers2"
        def groovyNumbers = new GroovyNumbers2() //= new GroovyNumbers2()

        expect: "A list to be returned with only the numbers with magnitude greater than 10"
        groovyNumbers.getMagnitudeGreaterThanTen(initialList) == expected

        where:
        initialList    | expected
        numberList     | [15, 34, -12]
        []             | []
        [1, -2, 4, -9] | []
        null           | null
    }

    /**
     * TODO #4: Create a method in GroovyNumbers2 that returns the first number
     * in {@code numberList} that has a magnitude greater than 10.
     */
    @Unroll
    def "Test that getFirstMagnitudeGreaterThanTen() returns the first number with magnitude greater than 10"() {
        given: "an instance of GroovyNumbers2"
        def groovyNumbers = new GroovyNumbers2() //= new GroovyNumbers2()

        expect: "The first number with magnitude greater than 10 to be returned"
        groovyNumbers.getFirstMagnitudeGreaterThanTen(initialList) == expected

        where:
        initialList    | expected
        numberList     | 15
        []             | null
        [1, -2, 4, -9] | null
        [10, -11, 20]  | -11
        null           | null
    }

    /**
     * TODO #5: Create a method in GroovyNumbers2 that returns a list of the
     * squares (x ** 2) of the numbers in {@code numberList}.
     */
    @Unroll
    def "Test that getSquares() returns the squares of the numbers in the list"() {
        given: "an instance of GroovyNumbers2"
        def groovyNumbers = new GroovyNumbers2() //= new GroovyNumbers2()

        expect: "The squares of each element in the list to be returned"
        groovyNumbers.getSquares(initialList) == expected

        where:
        initialList | expected
        numberList  | [1, 25, 64, 100, 225, 1156, 144]
        []          | []
        [0, -1]     | [0, 1]
        null        | null
    }

    /**
     * TODO #6: Create a method in GroovyNumbers2 that calculates the number of
     * elements in {@code numberList} that have a magnitude greater than 10.
     * There's a {@code count ( )} method in the Groovy JDK that should help.
     */
    @Unroll
    def "Test that getCountMagnitudeGreaterThanTen() returns the number of elements with magnitude greater than 10"() {
        given: "an instance of GroovyNumbers2"
        def groovyNumbers = new GroovyNumbers2() //= new GroovyNumbers2()

        expect: "The number of elements with magnitude greater than 10 to be returned"
        groovyNumbers.getCountMagnitudeGreaterThanTen(initialList) == expected

        where:
        initialList    | expected
        numberList     | 3
        []             | 0
        [1, -2, 4, -9] | 0
        null           | null
    }

    /**
     * TODO #7: Create a method in GroovyNumbers2 that returns a list of the
     * even numbers between 0 and 20 inclusive. Note that the {@code collect ( )}
     * method can be applied to ranges.
     */
    @Unroll
    def "Test that getEvenNumbersBetweenZeroAndTwenty() returns the even numbers between 0 and 20 inclusive"() {
        given: "an instance of GroovyNumbers2"
        def groovyNumbers = new GroovyNumbers2() //= new GroovyNumbers2()

        when: "the  getEvenNumbersBetweenZeroAndTwenty() method is called"
        def result = groovyNumbers.getEvenNumbersBetweenZeroAndTwenty()

        then: "The expected result is returned"
        result == [0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20]
    }
}
