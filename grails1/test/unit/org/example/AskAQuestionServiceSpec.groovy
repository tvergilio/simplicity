package org.example

import grails.plugin.mail.MailService
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@Mock([Course, Faculty])
@TestFor(AskAQuestionService)
class AskAQuestionServiceSpec extends Specification {

    void "test contactHead"() {
        given: "The details for an e-mail message"
        def messageDetails = [toEmail: 'tvergilio@gmail.com', fromEmail: 't.vergilio@leedsbeckett.ac.uk', body: 'Is the tutor for this course any good?']

        and: "An existing Course" //although does it matter whether the Course exists? I don't think it does for this test...
        def faculty = new Faculty([name: "Visual Arts"]).save()
        def course = new Course([code: "WAT", title: "Watercolours", description: "Painting with watercolours."])
        faculty.addToCourses(course)
        faculty.save()

        and: "A mock implementation for the AskAQuestionService's MailService"
        def mailService = Mock(MailService)
        service.mailService = mailService

        when: "The askAQuestion() action is called on the service"
        service.askAQuestion(messageDetails.toEmail, messageDetails.fromEmail, messageDetails.body, course.id.toString())

        then: "The mailService's sendMail method is called once and only once"
        1 * mailService.sendMail(_)
    }
}
