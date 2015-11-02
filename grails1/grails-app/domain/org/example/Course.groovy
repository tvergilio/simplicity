package org.example

class Course {

    String code
    String title
    String description
    Faculty faculty
    static hasMany = [students: Student]
    static belongsTo = Student

    static constraints = {
        code size: 3..4, unique: true
        title nullable: false, blank: false
        description nullable: false, blank: false, maxSize: 2000
    }

    static mapping = {
        table 'courses'
        code index: 'code_index'
    }
}
