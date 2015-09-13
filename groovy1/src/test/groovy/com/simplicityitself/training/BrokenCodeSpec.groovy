package com.simplicityitself.training

import org.junit.Assert
import spock.lang.Specification
import spock.lang.Unroll

class BrokenCodeSpec extends Specification {
    @Unroll
    def "Sum numbers in #numbers"() {
        given: "The broken code exercise"
        def exercise = new BrokenCode()

        expect: "The sum is calculated correctly"
        exercise.sumNumbers(numbers) == expected

        where:
        numbers   | expected
        []        | 0
        [5]       | 5
        [1, 2, 3] | 6
    }

    @Unroll
    def "Reverse the strings #input"() {
        given: "The broken code exercise"
        def exercise = new BrokenCode()

        expect: "The given strings to all be reversed"
        exercise.reverseStrings(input) == expected

        where:
        input                   | expected
        []                      | []
        ["abc"]                 | ["cba"]
        ["abc", "eye", "dally"] | ["cba", "eye", "yllad"]
    }

    @Unroll
    def "Reverse the strings #input (alternate)"() {
        given: "The broken code exercise"
        def exercise = new BrokenCode()

        expect: "The given strings to all be reversed"
        exercise.altReverseStrings(input) == expected

        where:
        input                   | expected
        []                      | []
        ["abc"]                 | ["cba"]
        ["abc", "eye", "dally"] | ["cba", "eye", "yllad"]
    }
}
