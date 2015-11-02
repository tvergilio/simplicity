package org.example

class Faculty {

    String name

    static hasMany = [courses: Course]

    static constraints = {
        name nullable: false, blank: false, maxSize: 25 //needs toEmail be a bit bigger
    }

    static mapping = {
        table 'faculties'
    }
}
