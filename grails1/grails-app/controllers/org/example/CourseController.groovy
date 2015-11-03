package org.example

class CourseController {
    static scaffold = true
    def mailSender
    def studentRegistrationService

    def register() {
        def student = session.user
        if (!student.isAttached()) {
            student.attach()
        }
        def course = Course.findById(params.id)
        studentRegistrationService.registerStudent(student, course)
        redirect([controller: 'student', action: 'show', params: [id: student.id]])
    }

    def contactHead(String from, String body, int id) {
        def course = Course.findById(id)
        mailSender.sendEmail('head@department.leedsbeckett.ac.uk', from, "${course.title}", body)
        return
    }
}
