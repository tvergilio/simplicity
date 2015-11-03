package org.example

import grails.test.spock.IntegrationSpec
import grails.transaction.*
import spock.lang.*

@Rollback
class QuerySpec extends IntegrationSpec {

    @Shared
    def course

    @Shared
    def faculty

    def setupSpec() {
        faculty = new Faculty([name: "Visual Arts"]).save(flush: true)
        course = new Course([code: "WAT", title: "Watercolours", description: "Painting with watercolours."])
        faculty.addToCourses(course)
        faculty.save(flush: true)
    }

    void "test a Course can be queried by its code"() {
        when: "The Course with code 'WAT' is queried"
        def result = Course.findByCode('WAT')
        then: "The expected Course is returned"
        assert result == course
    }

    void "test a Faculty can be queried by its name and has the appropriate Course attached"() {
        when: "The Faculty with name 'Visual Arts' is queried"
        def query = Faculty.where {
            name == "Visual Arts"
        }
        def result = query.get()
        then: "The expected Faculty with the associated Course is returned"
        assert result == faculty
        assert result.courses.contains(course)
    }
}
