package com.simplicityitself.training

import spock.lang.Specification
import spock.lang.Unroll

class JavaCollectionsSpec extends Specification {
    @Unroll
    def "Calculate mean value of #nums"() {
        given: "The collections exercise"
        def exercise = new JavaCollections()

        expect: "The mean average of a collection of numbers is calculated correctly"
        exercise.mean(nums) == expected

        where:
        nums             | expected
        [1]              | 1
        [1, 0, -1]       | 0
        [2, 4, 9, -2, 0] | 2.6
        [-1, -3, -6, -4] | -3.5
        [1, 1, 3, 3]     | 2
        null             | 0
        []               | 0
    }

    @Unroll
    def "Calculate median value of #nums"() {
        given: "The collections exercise"
        def exercise = new JavaCollections()

        expect: "The median of a collection of numbers is calculated correctly"
        exercise.median(nums) == expected

        where:
        nums             | expected
        [1]              | 1
        [1, 0, -1]       | 0
        [2, 4, 9, -2, 0] | 2
        [-1, -3, -6, -2] | -2.5
        [1, 1, 3, 3]     | 2
    }

    @Unroll
    def "Create list of #n even numbers"() {
        given: "The collections exercise"
        def exercise = new JavaCollections()

        expect: "An order list of even numbers from 0"
        exercise.evens(n) == expected

        where:
        n | expected
        0 | []
        1 | [0]
        2 | [0, 2]
        5 | [0, 2, 4, 6, 8]
    }

    @Unroll
    def "Reverse the order of #nums"() {
        given: "The collections exercise"
        def exercise = new JavaCollections()

        expect: "The same numbers in reverse order"
        exercise.reverse(nums) == expected

        where:
        nums             | expected
        []               | []
        [1]              | [1]
        [1, 0, -1]       | [-1, 0, 1]
        [2, 4, 9, -2, 0] | [0, -2, 9, 4, 2]
    }

    @Unroll
    def "Convert number word #word to the corresponding number"() {
        given: "The collections exercise"
        def exercise = new JavaCollections()

        expect: "A correct conversion of word to number"
        exercise.wordToNumber(word) == expected

        where:
        word   | expected
        "zero" | null
        "one"  | 1
        "five" | 5
        "ten"  | 10
    }

    @Unroll
    def "Create map of strings to lengths for #input"() {
        given: "The collections exercise"
        def exercise = new JavaCollections()

        expect: "A correct conversion of word to number"
        exercise.stringSizes(input) == expected

        where:
        input                   | expected
        []                      | [:]
        ["one"]                 | ["one": 3]
        ["I", "am", "fabulous"] | [I: 1, am: 2, fabulous: 8]
    }

    @Unroll
    def "Extract values from #input where key length is less than or equal to #n"() {
        given: "The collections exercise"
        def exercise = new JavaCollections()

        expect: "The correct set of values for the given key length"
        exercise.filterKeys(input, n) as Set == expected as Set

        where:
        input                | n | expected
        [:]                  | 1 | []
        [a: "b", c: "D"]     | 0 | []
        [a: "A", bed: "BED"] | 1 | ["A"]
        [a: "A", bed: "BED"] | 2 | ["A"]
        [a: "A", bed: "BED"] | 3 | ["A", "BED"]
    }
}
