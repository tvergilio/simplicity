package com.simplicityitself.training

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 * <p>The {@link DuckTyping} class doesn't declare any types, which means that
 * you can pass any objects into the methods as long as they have the required
 * properties and methods. Make use of {@code Expando} or maps to mimic the
 * objects expected by the methods under test.</p>
 * <p>You can find a useful article on duck typing in Groovy
 * <a href="https://objectpartners.com/2013/08/19/optional-typing-in-groovy/">here</a>
 * .</p>
 */
class BrokenCode3Spec extends Specification {

    @Shared
    def numberList = [1, 5, -8, 10, 15, 34, -12]

    def "Test that sumNumbers() adds up the numbers"() {
        given: "an instance of BrokenCode3"
        def brokenCode3 = new BrokenCode3()

        expect: "The sum of all the numbers to be returned"
        brokenCode3.sumNumbers(initialList) == expected

        where:
        initialList      | expected
        numberList       | 45
        []               | 0
        [-1, -2, -4, -9] | -16
        null             | 0
    }

    @Unroll
    def "Calculate VAT for #value"() {
        given: "an instance of BrokenCode3"
        def brokenCode3 = new BrokenCode3()

        expect: "VAT is calculated correctly"
        brokenCode3.calculateVat(value) == expected

        where:
        value  | expected
        100.00 | 20.00
        150.00 | 30.00
        0.00   | 0.00
        123.49 | 24.70
    }

    @Unroll
    def "Calculate mean value of #nums"() {
        given: "an instance of BrokenCode3"
        def brokenCode3 = new BrokenCode3()

        expect: "The mean average of a collection of numbers is calculated correctly"
        brokenCode3.mean(nums) == expected

        where:
        nums             | expected
        [1]              | 1
        [1, 0, -1]       | 0
        [2, 4, 9, -2, 0] | 2.6
        [-1, -3, -6, -4] | -3.5
        [1, 1, 3, 3]     | 2
    }

    @Unroll
    def "Calculate median value of #nums"() {
        given: "an instance of BrokenCode3"
        def brokenCode3 = new BrokenCode3()

        expect: "The median of a collection of numbers is calculated correctly"
        brokenCode3.median(nums) == expected

        where:
        nums             | expected
        [1]              | 1
        [1, 0, -1]       | 0
        [2, 4, 9, -2, 0] | 2
        [-1, -3, -6, -2] | -2.5
        [1, 1, 3, 3]     | 2
    }

    @Unroll
    def "Reverse the strings in the collection '#input'"() {
        given: "an instance of BrokenCode3"
        def brokenCode3 = new BrokenCode3()

        expect: "The reversed string"
        brokenCode3.reverseStrings(input) == expected

        where:
        input                       | expected
        ["essay", "A bat"]          | ["yasse", "tab A"]
        [""]                        | [""]
        ["A bat", "eye", "???"]  | ["tab A", "eye", "???"]
        []                          | []
        null                        | []
    }
}
