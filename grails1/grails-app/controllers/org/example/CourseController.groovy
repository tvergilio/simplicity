package org.example

class CourseController {
    static scaffold = true
    def askAQuestionService
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
        askAQuestionService.askAQuestion('tvergilio@gmail.com', from, "${course.title}", body)
        return
    }
}
