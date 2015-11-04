package org.example

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Shared
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */

@Mock([Course, Faculty])
@TestFor(MainController)
class MainControllerSpec extends Specification {

    @Shared
    def course1

    @Shared
    def course2

    @Shared
    def faculty

    def setup() {
        faculty = new Faculty([name: "Visual Arts"]).save()
        course1 = new Course([code: "WAT1", title: "Introduction to Watercolours", description: "An introduction to painting with watercolours."])
        course2 = new Course([code: "SCUL", title: "Ceramic Sculpture", description: "A practical approach to producing ceramic artwork."])
        faculty.addToCourses(course1)
        faculty.addToCourses(course2)
        faculty.save()
    }

    void "test index() returns a list of Courses"() {
        when: "the index() method is called on the controller"
        def model = controller.index()

        then: "the index view is displayed and the two expected Course are returned, with their associated faculty"
//        view == '/main/index'
        model.courses.size() == 2
        model.courses[0].id == course1.id
        model.courses[1].id == course2.id
        model.courses[0].faculty.id == faculty.id
        model.courses[1].faculty.id == faculty.id
    }

    void "test show() returns the expected Course"() {
        when: "the show() method is called on the controller passing the id of the expected Course"
        def model = controller.show(course1.id as int)

        then: "the show view is displayed and the expected Course is returned, with its associated faculty"
//        view == '/main/show'
        model.course.id == course1.id
        model.course.title == course1.title
        model.course.description == course1.description
        model.course.faculty.id == course1.faculty.id
    }
}
