package org.example

class StudentController {

    def show(Long id) {
        def student = Student.get(id)
        if (student) {
            return [student: student]
        } else {
            flash.message = "A student with id ${id} does not exist."
            response.sendError(404)
            return
        }
    }
}
