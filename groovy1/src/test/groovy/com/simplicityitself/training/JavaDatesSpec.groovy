package com.simplicityitself.training

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import java.time.LocalDate
import java.time.Month

class JavaDatesSpec extends Specification {
    @Shared
    LocalDate start = LocalDate.of(2010, Month.NOVEMBER, 1);

    @Unroll
    def "Calculate a new date #n days from #start"() {
        given: "The date exercise"
        def exercise = new JavaDates()

        expect: "The correct date"
        exercise.addDays(start, n) == expected

        where:
        n  | expected
        0  | LocalDate.of(2010, Month.NOVEMBER, 1)
        1  | LocalDate.of(2010, Month.NOVEMBER, 2)
        40 | LocalDate.of(2010, Month.DECEMBER, 11)
    }

    @Unroll
    def "Calculate a the number of days between dates"() {
        given: "The date exercise"
        def exercise = new GroovyDates()

        expect: "The correct date"
        exercise.diffDays(Date.parse("yyyy-MM-dd", "2010-11-01").time, input.time) == expected

        where:
        input                                  | expected
        Date.parse("yyyy-MM-dd", "2010-11-01") | 0
        Date.parse("yyyy-MM-dd", "2010-11-02") | 1
        Date.parse("yyyy-MM-dd", "2010-12-11") | 40
    }

    @Unroll
    def "Format the date #formattedInput"() {
        given: "The date exercise"
        def exercise = new GroovyDates()

        expect: "The correctly formatted date"
        exercise.formattedDate(input) == expected

        where:
        input                                  | expected
        Date.parse("yyyy-MM-dd", "2010-11-01") | "01 Nov 2010"
        Date.parse("yyyy-MM-dd", "2016-06-02") | "02 Jun 2016"
        Date.parse("yyyy-MM-dd", "1666-09-02") | "02 Sep 1666"

        formattedInput = input.format("dd MMM yyyy")
    }
}
