package org.example

class MainController {

    def index() {
        render(view: 'index', model: [courses: Course.list()])
    }

    def show(int id) {
        render(view: 'show', model: [course: Course.findById(id)])
    }

    def search(String searchString) {
        if ("*".equals(searchString)) {
            redirect action: 'index'
            return
        } else {
            render(view: 'index', model: [courses: Course.findAllByCodeIlikeOrDescriptionIlike(searchString, searchString)])
        }
    }
}
