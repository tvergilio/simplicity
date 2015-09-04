package com.simplicityitself.training

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class GroovyCommonsCodecSpec extends Specification {

    def "Calculate MD5 hash of a string"() {
        given: "The commons codec exercise"
        def exercise = new GroovyCommonsCodec()

        expect: "The correct MD5 hash"
        exercise.toMD5("Hello world!") == "86fb269d190d2c85f6e0468ceca42a20"
    }

    def "Calculate MD5 hash of byte data"() {
        given: "The commons codec exercise"
        def exercise = new GroovyCommonsCodec()

        expect: "The correct MD5 hash"
        exercise.toMD5("Hello world!".getBytes("UTF-8")) == "86fb269d190d2c85f6e0468ceca42a20"
    }
}
