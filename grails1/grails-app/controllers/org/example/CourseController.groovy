package org.example

class CourseController {
    static scaffold = true

    def register() {
        def student = session.user
        if (!student.isAttached()) {
            student.attach()
        }
        def course = Course.findById(params.id)
        student.addToCourses(course)
        student.save(flush: true)
        redirect([controller: 'student', action: 'show', params: [id: student.id]])
    }
}
