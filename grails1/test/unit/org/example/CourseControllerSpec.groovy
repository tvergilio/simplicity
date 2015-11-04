package org.example

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
    @Shared
    def course

    @Shared
    def faculty

    @Shared
    def messageDetails

    def setup() {
        faculty = new Faculty([name: "Visual Arts"]).save()
        course = new Course([code: "WAT", title: "Watercolours", description: "Painting with watercolours."])
        faculty.addToCourses(course)
        faculty.save()
        messageDetails = [fromEmail: 't.vergilio@leedsbeckett.ac.uk', body: 'Is the tutor for this course any good?']
    }

    def cleanup() {
        faculty.delete()
    }

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
        given: "A mock implementation for the mailSender's sendEmail() method"
        def askAquestionService = Mock(AskAQuestionService)
        1 * askAquestionService.askAQuestion(_, _, _, _) >> { to, from, subject, body ->
            new Email([to: to, from: from, subject: subject, body: body]).save()
        }
        controller.askAQuestionService = askAquestionService

        when: "The contactHead() action is called on the controller"
        controller.contactHead(messageDetails.fromEmail, messageDetails.body, course.id as int)

        then: "The correct e-mail is sent once and only once"
        def emails = Email.findAllByFromAndSubjectAndBody(messageDetails.fromEmail, course.title, messageDetails.body)
        assert emails.size() == 1
    }
}
