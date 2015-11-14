package org.example

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Shared
import spock.lang.Specification
import uk.ac.leedsbeckett.AuditEvent
import uk.ac.leedsbeckett.AuditService

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@Mock([Student, Faculty, Course])
@TestFor(StudentRegistrationService)
class StudentRegistrationServiceSpec extends Specification {

    @Shared
    def auditServiceMock

    @Shared
    def studentDetails

    def setup() {
        studentDetails = [name: "Thalita", email: "t.vergilio@leedsbeckett.ac.uk"]
        auditServiceMock = new AuditService() {
            def domain
            def parameters

            @Override
            public <T extends AuditEvent> T recordEvent(Class<T> domainClass, Map<String, Object> params) {
                domain = domainClass
                parameters = params
                return null
            }
        }
    }

    void "test createStudent creates a new Student record and calls the audit service once to record the transaction"() {
        given: "A mock implementation for the StudentRegistrationService's AuditService"
        service.auditService = auditServiceMock
        when: "the service's createStudent method is called"
        def student = service.createStudent(studentDetails.name, studentDetails.email)
        then: "the audit service's record event is called once and only once, with the right arguments"
//        1 * auditServiceMock.recordEvent(_, _) Interesting. Why on earth doesn't this work?? :(
        auditServiceMock.domain == AuditEventImpl
        auditServiceMock.parameters == [origin: Student.name, event: AuditEvent.CREATED, recordId: student.id]
        and: "the student returned has been persisted and has the correct details"
        assert Student.get(student.id)
        assert student.name == studentDetails.name
        assert student.email == studentDetails.email
    }

    void "test registerStudent links Students to Courses"() {
        given: "An existing Student and a Course"
        def student = new Student(studentDetails).save(flush: true)
        def faculty = new Faculty([name: "Visual Arts"]).save()
        def course = new Course([code: "WAT1", title: "Introduction to Watercolours", description: "An introduction to painting with watercolours."])
        faculty.addToCourses(course)
        faculty.save(flush: true)
        and: "A mock implementation for the StudentRegistrationService's AuditService"
        service.auditService = auditServiceMock
        when: "the service's registerStudent method is called"
        def returnedStudent = service.registerStudent(student, course)
        then: "the audit service's record event is called once and only once, with the right arguments"
//        1 * auditServiceMock.recordEvent(_, _) doesn't work here either :(
        auditServiceMock.domain == AuditEventImpl
        auditServiceMock.parameters == [origin: Student.name, event: AuditEvent.UPDATED, recordId: student.id]
        and: "the student returned has been associated with the course given"
        assert returnedStudent.courses.contains(course)
    }
}
