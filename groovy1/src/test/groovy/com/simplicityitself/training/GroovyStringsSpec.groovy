package com.simplicityitself.training

import spock.lang.Specification
import spock.lang.Unroll

class GroovyStringsSpec extends Specification {
    @Unroll
    def "Generate greeting for #name"() {
        given: "The strings exercise"
        def exercise = new GroovyStrings()

        expect: "The correct greeting for a given name"
        exercise.hello(name) == expected

        where:
        name    | expected
        "Peter" | "Hello Peter!"
        ""      | "Who are you?"
        "A"     | "Hello A!"
        "习近平" | "Hello 习近平!"
    }

    @Unroll
    def "Reverse the string '#input'"() {
        given: "The strings exercise"
        def exercise = new GroovyStrings()

        expect: "The reversed string"
        exercise.reverse(input) == expected

        where:
        input   | expected
        "essay" | "yasse"
        ""      | ""
        "A bat" | "tab A"
        "eye"   | "eye"
        "习近平" | "平近习"
    }

    @Unroll
    def "Extract first #n characters of '#input'"() {
        given: "The strings exercise"
        def exercise = new GroovyStrings()

        expect: "The requested number of characters from the beginning of the string"
        exercise.leadingChars(input, n) == expected

        where:
        input       | n  | expected
        "essay"     | 3  | "ess"
        "A bat"     | 0  | ""
        "conundrum" | 1  | "c"
        "A bat"     | 10 | "A bat"
        ""          | 0  | ""
    }

    @Unroll
    def "Replace vowels in '#input' with a *"() {
        given: "The strings exercise"
        def exercise = new GroovyStrings()

        expect: "Vowels to be replaced by *"
        exercise.replaceVowels(input) == expected

        where:
        input   | expected
        "essay" | "*ss*y"
        "uoiea" | "*****"
        "cnhsj" | "cnhsj"
        "A bat" | "* b*t"
        ""      | ""
    }

    @Unroll
    def "Calculate word-related statistics about a string"() {
        given: "The strings exercise"
        def exercise = new GroovyStrings()

        when: "I calculate the word statistics for some string"
        def result = exercise.wordStats(input)

        then: "I get the appropriate counts for the various word types"
        result == expected

        where:
        input   | expected
        "" | [charCount: 0, lineCount: 0, singleLetterCount: 0, hyphenatedCount: 0, allCapsCount: 0]
        "Hello world" | [charCount: 11, lineCount: 1, singleLetterCount: 0, hyphenatedCount: 0, allCapsCount: 0]
        """\
GROOVY is a language that is based on the JVM
and super-powers the standard Java class library.
If I were to write a new app, I would choose
GROOVY. It has many features that are
really useful and lots of sugar-coated syntax.
I am sold.""" | [charCount: 236, lineCount: 6, singleLetterCount: 5,
                 hyphenatedCount: 2, allCapsCount: 6]
    }
}
