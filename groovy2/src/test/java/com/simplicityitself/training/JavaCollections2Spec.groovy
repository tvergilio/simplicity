package com.simplicityitself.training

import spock.lang.Specification
import spock.lang.Unroll

/**
 * TODO #25: Create a JavaCollections2 class under src/main/groovy in the same
 * package as this test case.
 */
class JavaCollections2Spec extends Specification {

    /**
     * <p>TODO #26: Create a method in GroovyCollections2 that returns the product
     * of a list of numbers, i.e. the value you get if you multiply all the
     * numbers together.</p>
     */
    @Unroll
    def "Test that getProduct() returns the product of a list of numbers"() {
        given: "an instance of JavaCollections2"
        def exercise = new JavaCollections2()

        expect: "The result #expected to be returned for #initialist"
        exercise.getProduct(initialList) == expected

        where:
        initialList  | expected
        [2, 2, 3, 4] | 48
        [1, 1, 1, 1] | 1
        []           | null
        null         | null
    }

    /**
     * TODO #27: Create a method in JavaCollections2 that returns the sum
     * of the squares of a list of numbers, i.e. the value you get if you square
     * each of the numbers and add the results together.
     */
    @Unroll
    def "Test that getSumOfSquares() returns the sum of squares of a list of numbers"() {
        given: "an instance of JavaCollections2"
        def exercise = new JavaCollections2()

        expect: "The result #expected to be returned for #initialist"
        exercise.getSumOfSquares(initialList) == expected

        where:
        initialList  | expected
        [2, 2, 3, 4] | 33
        [1, 1, 1, 1] | 4
        []           | 0
        null         | null
    }
    /**
     * TODO #28: Create a method in JavaCollections2 that takes a list of numbers
     * and separates them into positive, negative and zero values.
     */
    def "Test that getGroupedNumbers() returns the list of numbers separated into positive, negative and zero values"() {
        given: "an instance of JavaCollections2"
        def exercise = new JavaCollections2()

        expect: "The result #expected to be returned for #initialist"
        exercise.getGroupedNumbers(initialList) == expected

        where:
        initialList   | expected
        [2, -2, 3, 0] | [positive: [2, 3], negative: [-2], zero: [0]]
        [-1, -2, -10] | [negative: [-1, -2, -10]]
        []            | [:]
        null          | null
    }
}
