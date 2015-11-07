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
            flash.message = "A course with id ${id} does not exist."
            response.sendError(404)
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
}
