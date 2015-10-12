package com.simplicityitself.training

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 * <p>The {@link DuckTyping} class doesn't declare any types, which means that
 * you can pass any objects into the methods as long as they have the required
 * properties and methods. Make use of {@code Expando} or maps to mimic the
 * objects expected by the methods under test.</p>
 * <p>You can find a useful article on duck typing in Groovy
 * <a href="https://objectpartners.com/2013/08/19/optional-typing-in-groovy/">here</a>
 * .</p>
 */
class DuckTypingSpec extends Specification {
    @Shared
    def joe = new Expando([firstName: "Joe", lastName: "Bloggs", fullName: "Joe Bloggs"])
    @Shared
    def jill = new Expando([fullName: "Jill Dash"])
    @Shared
    def arthur = new Expando([fullName: "Arthur Dent"])
    @Shared
    def selina = new Expando([fullName: "Selina Kyle"])

    def "Get the full names of people"() {
        given: "The exercise"
        def exercise = new DuckTyping()

        and: "An initial list of people"
        // TODO #6: create a list of objects (Expando or Map is good here) that
        // satisfy the requirements of the method under test and the test data.
        // Have a look at the method to see what it does with its argument.
        def people = [joe, jill, arthur, selina]

        expect: "A list of the full names of given Person objects"
        exercise.fullNames(people) == ["Joe Bloggs", "Jill Dash", "Arthur Dent", "Selina Kyle"]
    }

    def "Make names all upper case"() {
        given: "The exercise"
        def exercise = new DuckTyping()

        and: "An initial person"
        // TODO #7: create any object that satisfies the requirements of the
        // method under test and the test data.
        def person = joe

        when: "I try to upper cast the names of a given person"
        exercise.namesToUpperCase(person)

        then: "The first and last names are updated appropriately"
        person.firstName == "JOE"
        person.lastName == "BLOGGS"
    }

    @Unroll
    def "Fetch first #count characters of a text file"() {
        given: "The exercise"
        def exercise = new DuckTyping()

        and: "The Lorem Ipsum String"
        def lipsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."

        and: "The objects that satisfy the requirements of the test"
        def path = new Expando()
        def reader = new Expando()
        reader.read = { char[] cbuf, int off, int len ->
            def result = lipsum?.substring(off, len)
            result.eachWithIndex { c, index -> cbuf[index] = c }
        }
        path.withReader = { String charSet, Closure<String> closure ->
            closure.call(reader)
        }

        expect: "The correct size of the test file to be returned"
        // TODO #8: create any object that satisfies the requirements of the
        // method under test and the test data. However, the object shouldn't
        // interact with the file system (so that rules out File)!

        exercise.firstChars(path, count) == expected

        where:
        count | expected
        0     | ""
        1     | "L"
        20    | "Lorem ipsum dolor si"
    }
}
