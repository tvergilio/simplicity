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

    void "test which returns all Faculties associated with Courses PHYS, CHEM and FRCH"() {
        given: "The criteria for the Course query"
        def courseQuery = Course.where {
            code in (['PHYS', 'CHEM', 'FRCH'])
        }
        when: "A query is executed for Faculties with Courses which fulfil the criteria"
        def faculties = courseQuery.list()?.faculty?.toSet() //interesting! is this messy?
        then: "The expected Faculties are returned"
        assert faculties.size() == 2
        assert faculties.name.contains('Physical Sciences')
        assert faculties.name.contains('Modern Foreign Languages')
    }

    void "test that finds all courses in the Humanities Faculty"() {
        when: "A query is submitted for Courses with the criteria specified"
        def c = Course.createCriteria()
        def results = c.list {
            faculty {
                eq('name','Humanities')
            }
        }
        then: "The expected Courses are returned"
        assert results.size() == 2
        assert results.title.contains("English BA")
        assert results.title.contains("History BA")
    }
}
