package org.example

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@Mock([Student])
@TestFor(AuthController)
class AuthControllerSpec extends Specification {

    void "test login calls the registration service to create a new Student when one doesn't exist"() {
        given: "a name and e-mail"
        def name = "Tina Test"
        def email = "t@test.com"
        and: "a mock instance of the StudentRegistrationService"
        controller.studentRegistrationService = Mock(StudentRegistrationService)
        when: "the login action is invoked for a Student that doesn't exist"
        controller.login(name, email)
        then: "the service's createStudent method is called once"
        1 * controller.studentRegistrationService.createStudent(name, email) >> new Student([name: name, email: email])
        and: "the student is attached to the session and the response is redirected as expected"
        assert session.user
        assert response.redirectedUrl == '/main/index'
    }

    void "test login doesn't call the registration service when the Student already exists"() {
        given: "an existing Student"
        def name = "Tina Test"
        def email = "t@test.com"
        new Student([name: name, email: email]).save(flush: true)
        and: "a mock instance of the StudentRegistrationService"
        controller.studentRegistrationService = Mock(StudentRegistrationService)
        when: "the login action is invoked for the student"
        controller.login(name, email)
        then: "the service's createStudent method not called"
        0 * controller.studentRegistrationService.createStudent(name, email)
        and: "the student is attached to the session and the response is redirected as expected"
        assert session.user
        assert response.redirectedUrl == '/main/index'
    }

    void "test login doesn't call the registration service and redirects to error page when the Student's e-mail has been registered but the name is incorrect"() {
        given: "an existing Student"
        def name = "Tina Test"
        def email = "t@test.com"
        def wrongName = "Tom Test"
        def student = new Student([name: name, email: email]).save(flush: true)
        and: "a mock instance of the StudentRegistrationService"
        controller.studentRegistrationService = Mock(StudentRegistrationService)
        when: "the login action is invoked for the student with the wrong name"
        controller.login(wrongName, email)
        then: "the service's createStudent method not called"
        0 * controller.studentRegistrationService.createStudent(name, email)
        and: "the student is not attached to the session and the response is redirected as expected"
        assertNull(session.user)
        assert response.redirectedUrl == '/auth/error'
    }
}
