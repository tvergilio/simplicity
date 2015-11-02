package org.example

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Shared
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@Mock([Course, Faculty, Email])
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
    }

    void "test contactHead"() {
        given: "A mock implementation for the mailSender's sendEmail() method"
        def mailSender = Mock(DummyMailSender)
        1 * mailSender.sendEmail(_, _, _, _) >> { to, from, subject, body ->
            new Email([toEmail: to, fromEmail: from, subject: subject, body: body]).save()
        }
        controller.mailSender = mailSender

        when: "The contactHead() action is called on the controller"
        controller.contactHead(messageDetails.fromEmail, messageDetails.body, course.id as int)

        then: "The correct e-mail is sent once and only once"
        def emails = Email.findAllByFromEmailAndSubjectAndBody(messageDetails.fromEmail, course.title, messageDetails.body)
        assert emails.size() == 1
    }
}