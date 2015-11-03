package org.example

import grails.test.spock.IntegrationSpec
import grails.transaction.Rollback
import spock.lang.Shared

/**
 * Created by vergil01 on 03/11/2015.
 */
@Rollback
class AuditIntegrationSpec extends IntegrationSpec {
    
    @Shared
    def studentRegistrationService

    void "test an audit record is created when a Student is created"() {
        when: "a Student is created"
        def student = studentRegistrationService.createStudent('Thalita Vergilio', 't.vergilio@leedsbeckett.ac.uk')
        then: "an AuditEvent record is created"
        def auditEvent = AuditEvent.findByOriginAndRecordId(Student.class.getName(), student.id as Integer)
        assert auditEvent
        assert auditEvent.event == AuditEvent.CREATED
    }

    void "test an audit record is created when a Student is linked to a Course"() {
        given: "an existing Course and Student"
        def existingCourse = Course.findByCode("ENG")
        def existingStudent = Student.findByEmail("jill.peel@nowhere.net")
        when: "a Student is linked to the Course"
        studentRegistrationService.registerStudent(existingStudent, existingCourse)
        then: "an AuditEvent record is created"
        def auditEvent = AuditEvent.findByOriginAndRecordId(Student.class.getName(), existingStudent.id as Integer)
        assert auditEvent
        assert auditEvent.event == AuditEvent.UPDATED
    }
}