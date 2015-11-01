package org.example

class Student {

    String name
    String email

    static hasMany = [courses: Course]

    static constraints = {
        name nullable: false, blank: false
        email email: true, nullable: false, blank: false
    }
}
