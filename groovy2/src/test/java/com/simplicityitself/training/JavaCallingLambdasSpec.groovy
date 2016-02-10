package com.simplicityitself.training

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll
import java.time.LocalDate
import java.time.Month

/**
 * TODO #29: Create a JavaCallingLambdas class under src/main/java in the
 * same package as this test case. Compile static.
 */
class JavaCallingLambdasSpec extends Specification {

    @Shared
    def date1 = LocalDate.of(1980, Month.JULY, 9);
    @Shared
    def date2 = LocalDate.of(2015, Month.JUNE, 10);
    @Shared
    def date1Plus1Day = LocalDate.of(1980, Month.JULY, 10);
    @Shared
    def date2Plus1Day = LocalDate.of(2015, Month.JUNE, 11);

    /**
     * <p>TODO #30: Create a method in JavaCallingLambdas that does exactly
     * the same as the {@code collect ( )} method provided by the Groovy JDK.
     * It's fine (even expected) to use a loop within the method. See the
     * closure introduction for an example of calling a closure. Simply pass
     * each list element as an argument to {@code call ( )}.
     */
    @Unroll
    def "Test manualCollect()"() {
        given: "an instance of JavaCallingLambdas"
        def javaCallingLambdas = new JavaCallingLambdas()

        expect: "The result #expected to be returned for #initialist and #lambdaToApply"
        javaCallingLambdas.manualCollect(initialList, lambdaToApply) == expected

        where:
        initialList        | lambdaToApply          | expected
        [2, 2, 3, 4]       | { it * 2 }             | [4, 4, 6, 8]
        ["black", "white"] | { it.substring(0, 1) } | ["b", "w"]
        [date1, date2]     | { it.plusDays(1L) }    | [date1Plus1Day, date2Plus1Day]
        [1, 1, 1, 1]       | { it + 1 }             | [2, 2, 2, 2]
        []                 | { it**3 }              | []
        []                 | null                   | []
        null               | null                   | []
    }

    /**
     * TODO #31: Create a method in JavaCallingLambdas that returns {@code true}
     * if every element in a list of strings matches the criteria specified in
     * a given lambda. For example, the method should look something like
     * {@code ifAllSatisfy ( List strings , Predicate criteria )}.
     */
    @Unroll
    def "Test that ifAllSatisfy() returns true if every element in a list of strings matches the criteria specified in the predicate"() {
        given: "an instance of JavaCallingLambdas"
        def javaCallingLambdas = new JavaCallingLambdas()

        expect: "#expected to be returned for #initialist and #lambdaToApply"
        javaCallingLambdas.ifAllSatisfy(initialList, lambdaToApply) == expected

        where:
        initialList                              | lambdaToApply          | expected
        ["apple", "cherry", "kiwi"]              | { it.length() < 8 }    | true
        ["apple", "cherry", "kiwi", "pineapple"] | { it.length() < 8 }    | false
        ["apple", "apricot", "peach"]            | { it.startsWith('a') } | false
        []                                       | null                   | false
        null                                     | null                   | false
    }
}
