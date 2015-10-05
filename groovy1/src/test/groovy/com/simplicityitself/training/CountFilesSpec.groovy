package com.simplicityitself.training

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by vergil01 on 21/09/2015.
 */
class CountFilesSpec extends Specification {
    final String absolutePath = new File("").getAbsolutePath()

    @Unroll
    def "Number of files in #directory with suffix #suffix"() {
        given: "the CountFiles exercise"
        def exercise = new CountFiles()

        expect: "The number of files with the given suffix is calculated correctly"
        exercise.countFiles("${absolutePath}\\${directory}", suffix) == expected

        where:
        directory            | suffix   | expected
        "files"              | "txt"    | 2
        "files/subdirectory" | "js"     | 1
        "nowhere"            | "txt"    | 0
        "nowhere/nosub"      | "txt"    | 0
        "files"              | ""       | 0
        null                 | "txt"    | 0
    }

    def "Number of files with a given suffix in a directory when the directory passed in is null"() {
        given: "the CountFiles exercise"
        def exercise = new CountFiles()

        and: "a given suffix"
        def suffix = "txt"

        expect: "The number of files with the given suffix is the number of files in the user's current directory"
        exercise.countFiles(null, suffix) == 0

    }
}
