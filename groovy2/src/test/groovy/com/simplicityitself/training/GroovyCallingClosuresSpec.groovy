package com.simplicityitself.training

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 * TODO #29: Create a GroovyCallingClosures class under src/main/groovy in the
 * same package as this test case.
 */
class GroovyCallingClosuresSpec extends Specification {

    @Shared
    def date1 = new Date().parse('yyyy/MM/dd', '1980/07/09');
    @Shared
    def date2 = new Date().parse('yyyy/MM/dd', '2015/06/10');
    @Shared
    def date1Plus1Day = new Date().parse('yyyy/MM/dd', '1980/07/10');
    @Shared
    def date2Plus1Day = new Date().parse('yyyy/MM/dd', '2015/06/11');

    /**
     * <p>TODO #30: Create a method in GroovyCallingClosures that does exactly
     * the same as the {@code collect ( )} method provided by the Groovy JDK.
     * It's fine (even expected) to use a loop within the method. See the
     * closure introduction for an example of calling a closure. Simply pass
     * each list element as an argument to {@code call ( )}.
     */
    @Unroll
    def "Test that manualCollect() returns the same as collect() from the Groovy JDK"() {
        given: "an instance of GroovyCallingClosures"
        def groovyCallingClosures = new GroovyCallingClosures()

        expect: "The result #expected to be returned for #initialist and #closureToApply"
        groovyCallingClosures.manualCollect(initialList, closureToApply) == expected

        where:
        initialList        | closureToApply         | expected
        [2, 2, 3, 4]       | { it * 2 }             | [4, 4, 6, 8]
        ["black", "white"] | { it.substring(0, 1) } | ["b", "w"]
        [date1, date2]     | { it + 1 }             | [date1Plus1Day, date2Plus1Day]
        [1, 1, 1, 1]       | { it + 1 }             | [2, 2, 2, 2]
        []                 | { it**3 }              | []
        []                 | null                   | []
        null               | null                   | []
    }

    /**
     * TODO #31: Create a method in GroovyCallingClosures that returns {@code true}
     * if every element in a list of strings matches the criteria specified in
     * a given closure. For example, the method should look something like
     * {@code ifAllSatisfy ( List strings , Closure criteria )}.
     */
    @Unroll
    def "Test that ifAllSatisfy() returns true if every element in a list of strings matches the criteria specified in the closure"() {
        given: "an instance of GroovyCallingClosures"
        def groovyCallingClosures = new GroovyCallingClosures()

        expect: "#expected to be returned for #initialist and #closureToApply"
        groovyCallingClosures.ifAllSatisfy(initialList, closureToApply) == expected

        where:
        initialList                              | closureToApply         | expected
        ["apple", "cherry", "kiwi"]              | { it.length() < 8 }    | true
        ["apple", "cherry", "kiwi", "pineapple"] | { it.length() < 8 }    | false
        ["apple", "apricot", "peach"]            | { it.startsWith('a') } | false
        []                                       | null                   | false
        null                                     | null                   | false
    }
}
