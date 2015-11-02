import groovy.json.JsonSlurper

class BootStrap {

    def init = { servletContext ->
        def slurper = new JsonSlurper()
        def resourcesJson = slurper.parseText(getClass().getResource("initialData.json").getText("UTF-8"))
        resourcesJson.faculties.each { facultyLazyMap ->
            def faculty = new org.example.Faculty(facultyLazyMap).save(flush: true)
        }
        resourcesJson.courses.each { courseLazyMap ->
            def course = new org.example.Course([code: courseLazyMap.code, description: courseLazyMap.description, title: courseLazyMap.title])
            def faculty = org.example.Faculty.findByName(courseLazyMap.faculty)
            faculty?.addToCourses(course)
            faculty?.save(flush: true)
        }
        resourcesJson.students.each { studentLazyMap ->
            def student = new org.example.Student([name: studentLazyMap.name, email: studentLazyMap.email])
            studentLazyMap.courses.each { courseCode ->
                def course = org.example.Course.findByCode(courseCode)
                student.addToCourses(course)
            }
            student?.save(flush: true)
        }
    }
    def destroy = {
    }
}
