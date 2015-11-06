package org.example

import grails.plugin.mail.MailService
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Shared
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@Mock([Course, Faculty, Email, Student])
@TestFor(CourseController)
class CourseControllerSpec extends Specification {

    void "test register uses the StudentRegistrationService to register a Student on a Course"() {
        given: "an existing Student attached to the session"
        def name = "Tina Test"
        def email = "t@test.com"
        def student = new Student([name: name, email: email]).save(flush: true)
        session.putValue('user', student)
        and: "a mock instance of the StudentRegistrationService"
        controller.studentRegistrationService = Mock(StudentRegistrationService)
        when: "the register action is called on the controller"
        controller.register()
        then: "the service's registerStudent method is called once"
        1 * controller.studentRegistrationService.registerStudent(_, _)
        and: "the response is redirected accordintly"
        assert response.redirectedUrl == "/student/show/${student.id}"
    }

    void "test contactHead"() {
        given: "A Faculty and a Course"
        def faculty = new Faculty([name: "Visual Arts"]).save()
        def course = new Course([code: "WAT", title: "Watercolours", description: "Painting with watercolours."])
        faculty.addToCourses(course)
        faculty.save(flush: true)
        def messageDetails = [fromEmail: 't.vergilio@leedsbeckett.ac.uk', body: 'Is the tutor for this course any good?']

        and: "A mock implementation for the CourseController's AskAQuestionService"
        def askAQuestionService = Mock(AskAQuestionService)
        controller.askAQuestionService = askAQuestionService

        when: "The contactHead() action is called on the controller"
        controller.contactHead(messageDetails.fromEmail, messageDetails.body, course.id)

        then: "The askAQuestion method on AskAQuestionService is called once and only once"
        1 * askAQuestionService.askAQuestion(_, _, _, _)
    }
}
