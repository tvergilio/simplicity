package org.example

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@Mock([Student, Course])
@TestFor(StudentController)
class StudentControllerSpec extends Specification {

    void "test show() returns the expected Student"() {
        given: "an existing Student with Courses"
        def student = new Student(name: 'Carolina Vergilio', email: 'cvergilio@email.com').save()
        def course1 = new Course(code: "WAT1", title: "Introduction to Watercolours", description: "An introduction to painting with watercolours.")
        def course2 = new Course(code: "SCUL", title: "Ceramic Sculpture", description: "A practical approach to producing ceramic artwork.")
        student.addToCourses(course1)
        student.addToCourses(course2)
        student.save(flush: true)

        when: "the show() method is called on the controller passing the id of the expected Student"
        def model = controller.show(student.id)

        then: "the expected Student is returned, with its associated Courses"
        model.student.id == student.id
        model.student.name == student.name
        model.student.email == student.email
        model.student.courses.size() == 2
        model.student.courses.contains(course1)
        model.student.courses.contains(course2)
    }
}
