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

    def contactHead(String from, String body, int id) {
        def course = Course.findById(id) //the unit test fails with Course.get(), it returns null
        askAQuestionService.askAQuestion('tvergilio@gmail.com', from, "${course.title}", body)
        return
    }
}
