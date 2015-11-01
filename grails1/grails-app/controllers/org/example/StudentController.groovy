package org.example

class StudentController {

    def show() {
        render([view: 'show', model: [student: Student.findById(params.id)]])
        return
    }
}
