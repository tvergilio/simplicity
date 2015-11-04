package org.example

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class Faculty {

    String name

    static hasMany = [courses: Course]

    static constraints = {
        name nullable: false, blank: false, maxSize: 25 //needs to be a bit bigger
    }

    static mapping = {
        table 'faculties'
        courses lazy: false
    }
}
