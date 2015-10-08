package com.simplicityitself.training

import groovy.transform.Immutable
import org.joda.time.DateTime
import org.joda.time.Years

/**
 * Created by Thalita on 05/10/2015.
 */
class GroovyClasses {

    def getNamesSortedByLength(List<Person> people) {
        return people*.name?.sort { it.length() }
    }

    def getDOBMostRecentFirst(List<Person> people) {
        return people*.dob?.sort { a, b -> b.compareTo(a) }
    }

    def getNamesAndAges(List<Person> people) {
        return people*.getNameAge()
    }
}

@Immutable
class Person {
    String name
    Date dob

    def getNameAge() {
        return "${name} ${age}"
    }

    def getAge() {
        return Years.yearsBetween(new DateTime(dob.getTime()), new DateTime(System.currentTimeMillis())).getYears()
    }
}
