package org.example

class StudentController {

    def show(Long id) {
        def student = Student.get(id)
        if (student) {
            return [student: student]
        } else {
            redirect action: 'studentNotFoundError', id: id
            return
        }
    }

    def studentNotFoundError(Long id){
        return [id: id]
    }
}
