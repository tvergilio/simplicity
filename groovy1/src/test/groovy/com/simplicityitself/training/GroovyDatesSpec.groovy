package com.simplicityitself.training

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class GroovyDatesSpec extends Specification {
    @Shared Date start = Date.parse("yyyy-MM-dd", "2010-11-01")

    @Unroll
    def "Calculate a new date #n days from #input"() {
        given: "The date exercise"
        def exercise = new GroovyDates()

        expect: "The correct date"
        exercise.addDays(start, n) == expected

        where:
        n  | expected
        0  | Date.parse("yyyy-MM-dd", "2010-11-01")
        1  | Date.parse("yyyy-MM-dd", "2010-11-02")
        40 | Date.parse("yyyy-MM-dd", "2010-12-11")

        input = start.format("dd MMM yyyy")
    }

    @Unroll
    def "Calculate a the number of days between #from and #to"() {
        given: "The date exercise"
        def exercise = new GroovyDates()

        expect: "The correct date"
        exercise.diffDays(start.time, input.time) == expected

        where:
        input                                  | expected
        start                                  | 0
        Date.parse("yyyy-MM-dd", "2010-11-02") | 1
        Date.parse("yyyy-MM-dd", "2010-12-11") | 40

        from = start.format("dd MMM yyyy")
        to = input.format("dd MMM yyyy")
    }

    @Unroll
    def "Format the date #formattedInput"() {
        given: "The date exercise"
        def exercise = new GroovyDates()

        expect: "The correctly formatted date"
        exercise.formattedDate(input) == expected

        where:
        input                                  | expected
        start                                  | "01 Nov 2010"
        Date.parse("yyyy-MM-dd", "2016-06-02") | "02 Jun 2016"
        Date.parse("yyyy-MM-dd", "1666-09-02") | "02 Sep 1666"

        formattedInput = input.format("dd MMM yyyy")
    }

}
