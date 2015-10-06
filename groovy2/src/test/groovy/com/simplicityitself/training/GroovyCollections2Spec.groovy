package com.simplicityitself.training

import spock.lang.Specification
import spock.lang.Unroll

/**
 * TODO #25: Create a GroovyCollections2 class under src/main/groovy in the same
 * package as this test case.
 */
class GroovyCollections2Spec extends Specification {

    /**
     * <p>TODO #26: Create a method in GroovyCollections2 that returns the product
     * of a list of numbers, i.e. the value you get if you multiply all the
     * numbers together. Although Groovy has a {@code sum ( )} method, it does
     * not have an equivalent for product. However, you can use the
     * {@code inject ( )} method ({@code foldLeft ( )} in the Java 8 Streams API)
     * to perform the operation.</p>
     * <p>For a technical explanation of what folding/injection is, you can
     * take a look at the
     * <a href="https://en.wikipedia.org/wiki/Fold_%28higher-order_function%29">Wikipedia</a>
     * article. Look at the Groovy JDK API docs for
     * <a href="http://docs.groovy-lang.org/docs/next/html/groovy-jdk/?java/util/Collection.html">{@code inject ( )}</a>
     * first (search for it in the page!).</p>
     */
    @Unroll
    def "Test that getProduct() returns the product of a list of numbers"() {
        given: "an instance of groovyCollections2"
        def groovyCollections2 = new GroovyCollections2()

        expect: "The result #expected to be returned for #initialist"
        groovyCollections2.getProduct(initialList) == expected

        where:
        initialList  | expected
        [2, 2, 3, 4] | 48
        [1, 1, 1, 1] | 1
        []           | null
        null         | null
    }

    /**
     * TODO #27: Create a method in GroovyCollections2 that returns the sum
     * of the squares of a list of numbers, i.e. the value you get if you square
     * each of the numbers and add the results together. As with the previous
     * exercise, {@code inject ( )} is your friend.
     */
    @Unroll
    def "Test that getSumOfSquares() returns the sum of squares of a list of numbers"() {
        given: "an instance of groovyCollections2"
        def groovyCollections2 = new GroovyCollections2()

        expect: "The result #expected to be returned for #initialist"
        groovyCollections2.getSumOfSquares(initialList) == expected

        where:
        initialList  | expected
        [2, 2, 3, 4] | 33
        [1, 1, 1, 1] | 4
        []           | 0
        null         | null
    }
    /**
     * TODO #28: Create a method in GroovyCollections2 that takes a list of numbers
     * and separates them into positive, negative and zero values. A useful way
     * to do this is with the {@code groupBy ( )} method, which you can find in the
     * Groovy JDK.
     */
    def "Test that getGroupedNumbers() returns the list of numbers separated into positive, negative and zero values"() {
        given: "an instance of groovyCollections2"
        def groovyCollections2 = new GroovyCollections2()

        expect: "The result #expected to be returned for #initialist"
        groovyCollections2.getGroupedNumbers(initialList) == expected

        where:
        initialList   | expected
        [2, -2, 3, 0] | [positive: [2, 3], negative: [-2], zero: [0]]
        [-1, -2, -10] | [negative: [-1, -2, -10]]
        []            | [:]
        null          | null
    }
}
