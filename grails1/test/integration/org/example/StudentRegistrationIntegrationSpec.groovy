package org.example

import grails.test.spock.IntegrationSpec
import spock.lang.Shared

/**
 * Created by Thalita on 13/11/2015.
 */
class StudentRegistrationIntegrationSpec extends IntegrationSpec {

    @Shared
    def studentRegistrationService

    void "test createStudent inserts a record in the database"() {
        when: "a Student is created"
        def student = studentRegistrationService.createStudent('Thalita Vergilio', 't.vergilio@leedsbeckett.ac.uk')
        then: "a record is inserted in the database"
        assert Student.get(student.id)
    }

    void "test registerStudent persists the association between Course and Student"() {
        given: "an existing Course"
        def student = new Student(name: 'Thalita Vergilio', email: 't.vergilio@leedsbeckett.ac.uk')
        def faculty = new Faculty([name: "Visual Arts"]).save()
        def course = new Course([code: "WAT1", title: "Introduction to Watercolours", description: "An introduction to painting with watercolours."])
        faculty.addToCourses(course)
        faculty.save(flush: true)
        when: "the registerStudent action is invoked"
        studentRegistrationService.registerStudent(student, course)
        then: "the association is peristed"
        assert Student.get(student.id).courses.contains(course)
    }

}
