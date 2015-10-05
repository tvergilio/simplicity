package com.simplicityitself.training

import groovy.transform.Immutable
import org.joda.time.DateTime
import org.joda.time.Years

/**
 * Created by Thalita on 05/10/2015.
 */
class GroovyClasses {

    def getNamesSortedByLength(List<Person> people) {
        if (people) {
            return people*.name?.sort { it.length() }
        } else {
            return []
        }
    }

    def getDOBMostRecentFirst(List<Person> people) {
        if (people) {
            return people*.dob?.sort { a, b -> b.compareTo(a) }
        } else {
            return []
        }
    }

    def getNamesAndAges(List<Person> people) {
        if (people) {
            return people*.getNameAge()
        } else {
            return []
        }
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
