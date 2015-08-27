package com.simplicityitself.training

import org.junit.Assert
import spock.lang.Specification
import spock.lang.Unroll

class GroovyNumbersSpec extends Specification {
    @Unroll
    def "Calculate VAT for #value"() {
        given: "The numbers exercise"
        def exercise = new GroovyNumbers()

        expect: "VAT is calculated correctly"
        exercise.calculateVat(value) == expected

        where:
        value  | expected
        100.00 | 20.00
        150.00 | 30.00
        0.00   | 0.00
        123.49 | 24.70
    }

    @Unroll
    def "Calculate hypotenuse for sides #sideA & #sideB"() {
        given: "The numbers exercise"
        def exercise = new GroovyNumbers()

        expect: "Hypotenuse length is calculated correctly"
        Assert.assertEquals(exercise.hypotenuseLength(sideA, sideB), expected, 0.001)

        where:
        sideA | sideB | expected
        3     | 4     | 5.0D
        4     | 2     | 4.472D
        1.23  | 2.67  | 2.940D
        0     | 6     | 6.0D
    }

    @Unroll
    def "Calculate the Fibonacci number at position #n"() {
        given: "The numbers exercise"
        def exercise = new GroovyNumbers()

        expect: "Fibonacci number is calculated correctly"
        exercise.fibonacci(n) == expected

        where:
        n  | expected
        1  | 1
        2  | 1
        5  | 5
        10 | 55
        17 | 1597
        20000 | 2000
    }
}
