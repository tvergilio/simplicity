package org.example

class AuthController {

    def studentRegistrationService

    def login(String name, String email) {
        def sessionStudent = Student.findByEmail(email)
        if (!sessionStudent) {
            sessionStudent = studentRegistrationService.createStudent(name, email)
        } else if (sessionStudent.name != name) {
            redirect(action: 'error')
            return
        }
        session.setAttribute('user', sessionStudent)
        redirect(controller: 'main', action: 'index')
        return
    }

    def showLogin() {
        session.removeAttribute('user')
        return
    }

    def error() {
    }
}
