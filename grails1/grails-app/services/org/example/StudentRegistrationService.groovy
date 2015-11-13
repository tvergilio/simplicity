package org.example

import grails.transaction.Transactional
import uk.ac.leedsbeckett.*

@Transactional
class StudentRegistrationService {
    def auditService

    //create new Student objects for the login action on request
    Student createStudent(String name, String email) {
        Student student = new Student([name: name, email: email]).save(flush: true)
        auditService.recordEvent(AuditEventImpl, [origin: Student.getName(), event: AuditEvent.CREATED, recordId: student.id])
        return student
    }

    //link students to courses
    Student registerStudent(Student student, Course course) {
        student.addToCourses(course)
        student.save(flush: true)
        auditService.recordEvent(AuditEventImpl, [origin: Student.getName(), event: AuditEvent.UPDATED, recordId: student.id])
        return student
    }
}
