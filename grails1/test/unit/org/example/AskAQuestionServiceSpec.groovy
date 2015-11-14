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
        given: "A mock implementation for the MailService's sendMail method"
        def mailDomain = new MailDomain()
        def mailServiceMock = Mock(MailService)
        mailServiceMock.sendMail(_) >> { args ->
            def closure = args[0]
            closure.setDelegate(mailDomain)
            closure.call()
            return null
        }
        service.mailService = mailServiceMock

        and: "The details for an e-mail message"
        def messageDetails = [toEmail: 'tvergilio@gmail.com', fromEmail: 't.vergilio@leedsbeckett.ac.uk', body: 'Is the tutor for this course any good?']

        and: "An existing Course" //although does it matter whether the Course exists? I don't think it does for this test...
        def faculty = new Faculty([name: "Visual Arts"]).save()
        def course = new Course([code: "WAT", title: "Watercolours", description: "Painting with watercolours."])
        faculty.addToCourses(course)
        faculty.save()

        when: "The askAQuestion() action is called on the service"
        service.askAQuestion(messageDetails.toEmail, messageDetails.fromEmail, course.title, messageDetails.body)

        then: "The mailService's sendMail method is called once and only once and the arguments passed by the closure are correct"
        1 * mailServiceMock.sendMail(_)
        assert mailDomain.to == properties.sendTo
        assert mailDomain.from == properties.sentFrom
        assert mailDomain.subject == properties.emailSubject
        assert mailDomain.body == properties.emailBody
    }

    private class MailDomain {
        public to
        public from
        public subject
        public body

        public to(String to) {
            to = to
        }

        public from(String from) {
            from = from
        }

        public subject(String subject) {
            subject = subject
        }

        public body(String body) {
            body = body
        }
    }
}
