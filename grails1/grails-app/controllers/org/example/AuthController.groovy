package org.example

class AuthController {

    def login(String name, String email) {
        def sessionStudent = Student.findByEmail(email)
        if (!sessionStudent) {
            sessionStudent = new Student([name: name, email: email]).save()
        } else if (sessionStudent.name != name) {
            redirect([action: 'error', view: 'error'])
            return
        }
        session.setAttribute('user', sessionStudent)
        redirect([controller: 'main', action: 'index'])
        return
    }

    def showLogin() {
        session.removeAttribute('user')
        return
    }

    def error() {
        return
    }
}
