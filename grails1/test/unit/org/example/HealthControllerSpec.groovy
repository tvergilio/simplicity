package org.example

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(HealthController)
class HealthControllerSpec extends Specification {

    void "test status"() {
        given: "A request for text/plain"
        controller.request.contentType='text/plain'

        when: "The controller's status action is called"
        controller.status()

        then: "The ok string is rendered as plain text"
        response.text == 'ok'
        response.contentType.startsWith('text/plain')
    }
}
