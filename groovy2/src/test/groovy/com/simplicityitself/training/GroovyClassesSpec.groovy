package com.simplicityitself.training

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 * TODO #21: Create a GroovyClasses class under src/main/groovy in the same
 * package as this test case.
 */
class GroovyClassesSpec extends Specification {
    @Shared
            people = [
                    new Person("Joe", Date.parse("yyyy-MM-dd", "1990-01-02")),
                    new Person("Anne", Date.parse("yyyy-MM-dd", "1985-05-27")),
                    new Person("Roberto", Date.parse("yyyy-MM-dd", "1960-11-23")),
                    new Person("Lizzy", Date.parse("yyyy-MM-dd", "1985-08-12")),
                    new Person("Edward", Date.parse("yyyy-MM-dd", "1978-02-28")),
                    new Person("Veronica", Date.parse("yyyy-MM-dd", "1964-12-25"))]

    /**
     * TODO #22: Create a method in GroovyClasses that returns a list of the
     * people's names in {@code people}, sorted by name length. Note that you
     * can use the
     * <a href="http://mrhaki.blogspot.co.uk/2009/08/groovy-goodness-spread-dot-operator.html">spread-dot operator</a>
     * in place of the {@code collect ( )} method. I do recommend always using
     * {@code *.} in place of a straight {@code .} though. The latter is too
     * confusing.
     */
    @Unroll
    def "Test that getNamesSortedByLength() returns the names of the persons sorted by length"() {
        given: "an instance of GroovyClasses"
        def groovyClasses = new GroovyClasses()

        expect: "A list to be returned with the names of the persons sorted by length"
        groovyClasses.getNamesSortedByLength(initialList) == expected

        where:
        initialList              | expected
        people                   | ["Joe", "Anne", "Lizzy", "Edward", "Roberto", "Veronica"]
        []                       | []
        [new Person([name: ""])] | [""]
        null                     | null
    }

    /**
     * TODO #23: Create a method in GroovyClasses that returns a list of the
     * dates of birth in {@code people}, sorted by most recent first.
     */
    @Unroll
    def "Test that getDOBMostRecentFirst() returns a list of DOBs sorted by most recent first"() {
        given: "an instance of GroovyClasses"
        def groovyClasses = new GroovyClasses()

        expect: "A list to be returned with the DOBs sorted by most recent first"
        groovyClasses.getDOBMostRecentFirst(initialList) == expected

        where:
        initialList                                                                 | expected
        people                                                                      | [Date.parse("yyyy-MM-dd", "1990-01-02"), Date.parse("yyyy-MM-dd", "1985-08-12"), Date.parse("yyyy-MM-dd", "1985-05-27"), Date.parse("yyyy-MM-dd", "1978-02-28"), Date.parse("yyyy-MM-dd", "1964-12-25"), Date.parse("yyyy-MM-dd", "1960-11-23")]
        []                                                                          | []
        [new Person([name: "Sergio", dob: Date.parse("yyyy-MM-dd", "1980-03-09")])] | [Date.parse("yyyy-MM-dd", "1980-03-09")]
        null                                                                        | null
    }

    /**
     * TODO #24: Create a method in GroovyClasses that returns a list of strings
     * of the form <tt>"$name ($age)"</tt>. You'll have to calculate the current
     * age from the date of birth.
     */
    @Unroll
    def "Test that getNamesAndAges() returns a list of names and ages"() {
        given: "an instance of GroovyClasses"
        def groovyClasses = new GroovyClasses()

        expect: "A list to be returned with the names and ages"
        groovyClasses.getNamesAndAges(initialList) == expected

        where:
        initialList                                                                 | expected
        people                                                                      | ["Joe 25", "Anne 30", "Roberto 54", "Lizzy 30", "Edward 37", "Veronica 50"]
        []                                                                          | []
        [new Person([name: "Sergio", dob: Date.parse("yyyy-MM-dd", "1980-03-09")])] | ["Sergio 35"]
        null                                                                        | null
    }
}

