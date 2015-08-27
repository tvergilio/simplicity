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
}
