package com.simplicityitself.training

import spock.lang.Specification
import spock.lang.Unroll

class GroovyBeansSpec extends Specification {

    def "Get the first names of people"() {
        given: "The beans exercise"
        def exercise = new GroovyBeans()

        and: "An initial list of people"
        def people = [
                new Person(firstName: "Joe", lastName: "Bloggs"),
                new Person(firstName: "Jill", lastName: "Dash"),
                new Person(firstName: "Arthur", lastName: "Dent"),
                new Person(firstName: "Selina", lastName: "Kyle"),
                new Person(firstName: null, lastName: "Cormier"),
                new Person(firstName: "Daniel", lastName: null),
                new Person(firstName: null, lastName: null)]

        expect: "A list of the first names of given Person objects"
        exercise.firstNames(people) == ["Joe", "Jill", "Arthur", "Selina", "Daniel"]
    }

    def "Get the full names of people"() {
        given: "The beans exercise"
        def exercise = new GroovyBeans()

        and: "An initial list of people"
        def people = [
                new Person(firstName: "Joe", lastName: "Bloggs"),
                new Person(firstName: "Jill", lastName: "Dash"),
                new Person(firstName: "Arthur", lastName: "Dent"),
                new Person(firstName: "Selina", lastName: "Kyle")]

        expect: "A list of the full names of given Person objects"
        exercise.fullNames(people) == ["Joe Bloggs", "Jill Dash", "Arthur Dent", "Selina Kyle"]
    }

    def "Make names all upper case"() {
        given: "The beans exercise"
        def exercise = new GroovyBeans()

        and: "An initial person"
        def person = new Person(firstName: "Joe", lastName: "Bloggs")

        when: "I try to upper cast the names of a given person"
        exercise.namesToUpperCase(person)

        then: "The first and last names are updated appropriately"
        person.firstName == "JOE"
        person.lastName == "BLOGGS"
    }

    def "Make names all upper case when first name is null"() {
        given: "The beans exercise"
        def exercise = new GroovyBeans()

        and: "An initial person"
        def person = new Person(firstName: null, lastName: "Bloggs")

        when: "I try to upper cast the names of a given person"
        exercise.namesToUpperCase(person)

        then: "Only the last name is updated appropriately"
        person.firstName == null
        person.lastName == "BLOGGS"
    }

    def "Make names all upper case when last name is null"() {
        given: "The beans exercise"
        def exercise = new GroovyBeans()

        and: "An initial person"
        def person = new Person(firstName: "Mary", lastName: null)

        when: "I try to upper cast the names of a given person"
        exercise.namesToUpperCase(person)

        then: "Only the first name is updated appropriately"
        person.firstName == "MARY"
        person.lastName == null
    }

    def "namesToUppercase() does not change the names when they are both null"() {
        given: "The beans exercise"
        def exercise = new GroovyBeans()

        and: "An initial person"
        def person = new Person(firstName: null, lastName: null)

        when: "I try to upper cast the names of a given person"
        exercise.namesToUpperCase(person)

        then: "The names are still null"
        person.firstName == null
        person.lastName == null
    }

    def "Create a list of people from full names"() {
        given: "The beans exercise"
        def exercise = new GroovyBeans()

        and: "An initial list of names"
        def names = ["Joe Bloggs", "Jill Dash", "Arthur Dent", "Selina Kyle"]

        when: "I create a list of people from those names"
        def people = exercise.createPeople(names)

        then: "I get a list of Person objects with the correct names"
        people.every { it instanceof Person }
        people.size() == names.size()
        people.find { it.firstName == "Joe" && it.lastName == "Bloggs" }
        people.find { it.firstName == "Selina" && it.lastName == "Kyle" }
    }

    def "Get the heights of people"() {
        given: "The beans exercise"
        def exercise = new GroovyBeans()

        and: "An initial list of people"
        def people = [
                new Person(firstName: "Joe", lastName: "Bloggs", height: 185),
                new Person(firstName: "Jill", lastName: "Dash", height: 176),
                new Person(firstName: "Arthur", lastName: "Dent", height: 163),
                new Person(firstName: "Selina", lastName: "Kyle", height: 170) ]

        expect: "A list of the full names of given Person objects"
        exercise.heights(people) == [185, 176, 163, 170]
    }
}
