package org.example

class Course {

    String code
    String title
    String description

    static belongsTo = [faculty: Faculty]

    static constraints = {
        code size: 3..4, unique: true
        title nullable: false, blank: false
        description nullable: false, blank: false, maxSize: 2000
    }
}
