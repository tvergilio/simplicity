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
        def course = Course.get(params.id)
        studentRegistrationService.registerStudent(student, course)
        redirect([controller: 'student', action: 'show', params: [id: student.id]])
    }

    def contactHead(String from, String body, Long id) {
        def course = Course.get(id)
        askAQuestionService.askAQuestion(askAQuestionService.DEFAULT_SEND_TO, from, course.title, body)
        return
    }
}
