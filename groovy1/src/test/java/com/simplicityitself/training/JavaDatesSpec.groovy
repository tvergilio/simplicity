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
        def exercise = new JavaDates()

        expect: "The correct date"
        exercise.diffDays(Date.parse("yyyy-MM-dd", "2010-11-01").time, input.time) == expected

        where:
        input                                  | expected
        Date.parse("yyyy-MM-dd", "2010-11-01") | 0
        Date.parse("yyyy-MM-dd", "2010-11-02") | 1
        Date.parse("yyyy-MM-dd", "2010-12-11") | 40
    }

    @Unroll
    def "Format the date"() {
        given: "The date exercise"
        def exercise = new JavaDates()

        expect: "The correctly formatted date"
        exercise.formattedDate(input) == expected

        where:
        input                                  | expected
        LocalDate.of(2010, Month.NOVEMBER, 1)  | "01 Nov 2010"
        LocalDate.of(2016, Month.JUNE, 2)      | "02 Jun 2016"
        LocalDate.of(1666, Month.SEPTEMBER, 2) | "02 Sep 1666"
    }
}
