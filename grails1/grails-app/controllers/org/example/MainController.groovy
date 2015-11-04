package org.example

class MainController {

    def index() {
        return [courses: Course.list()]
    }

    def show(int id) {
        def course = Course.findById(id)
        if (course) {
            return [course: Course.findById(id)]
        } else {
            redirect action: 'courseNotFoundError', id: "${id}"
            return
        }
    }

    def search(String searchString) {
        if (searchString == "*") {
            redirect action: 'index'
            return
        } else {
            render(view: 'index', model: [courses: Course.findAllByCodeIlikeOrTitleIlike(searchString, searchString)])
        }
    }

    def courseNotFoundError(int id) {
        return [id: id]
    }
}
