package org.example

class MainController {

    def index() {
        return [courses: Course.list()]
    }

    def show(Long id) {
        def course = Course.get(id)
        if (course) {
            return [course: Course.get(id)]
        } else {
            redirect action: 'courseNotFoundError', id: id
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

    def courseNotFoundError(Long id) {
        return [id: id]
    }
}
