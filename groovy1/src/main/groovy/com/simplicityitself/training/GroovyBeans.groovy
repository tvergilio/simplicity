package com.simplicityitself.training

/**
 * <p>These exercises give you a chance to work with the Java collections in
 * Groovy. If you would like a gentle introduction beyond the Groovy quick
 * reference, read the
 * <a href="http://pledbrook.github.io/practical-groovy-public/#_collections_ranges_and_maps">Collections,
 * ranges, and maps</a> section of the in-progress Practical Groovy book.
 * You should also take a look at the <a href="http://groovy-lang.org/gdk.html">Groovy JDK</a>
 * extensions as you may find some useful methods and properties there.</p>
 */
class GroovyBeans {

    /**
     * <p>TODO #n: Return a list containing just the first names of the people
     * in the given list. The names should be in the same order as the original
     * list of {@code Person} objects.</p>
     * <p><b>Note</b> The test will pass whether you use <tt>person.firstName</tt>
     * or <tt>person.getFirstName()</tt>. Try it!</p>
     */
    List<String> firstNames(List<Person> people) {
        def result = []
        for (p in people) {
            result << p.firstName  // or p.getFirstName()
        }
        return result
//        return -1
    }

    /**
     * <p>TODO #n: Return a list containing the full names of the people
     * in the given list. The names should be in the same order as the original
     * list of {@code Person} objects. In this case, the {@code fullName}
     * property is read-only because only a getter method is defined.</p>
     * <p><b>Note</b> The test will pass whether you use <tt>person.fullName</tt>
     * or <tt>person.getFullName()</tt>. Try it!</p>
     */
    List<String> fullNames(List<Person> people) {
        def result = []
        for (p in people) {
            result << p.fullName  // or p.getFullName()
        }
        return result
//        return -1
    }

    /**
     * <p>TODO #n: Modify the <tt>firstName</tt> and <tt>lastName</tt> properties
     * of the given <tt>Person</tt> by making all the letters upper case. Note
     * that Groovy adds a useful method to strings that converts them to upper
     * case, so check out the <a href="http://groovy-lang.org/gdk.html">Groovy JDK</a>.</p>
     * <p><b>Note</b> The test will pass whether you use <tt>person.firstName = ...</tt>
     * or <tt>person.setFullName(...)</tt>. Try it!</p>
     */
    void namesToUpperCase(Person person) {
        person.firstName = person.firstName.toUpperCase()   // or person.setFirstName(...toUpperCase())
        person.lastName = person.lastName.toUpperCase()     // or person.setLastName(...toUpperCase())
//
    }

    /**
     * <p>TODO #n: Create a list of {@code Person} objects that have the given
     * full names. You will need to split each full name yourself (at the space
     * character) and then initialise a new {@code Person} instance with the
     * resulting two values (first name and last name).</p>
     */
    List<Person> createPeople(List<String> names) {
        def result = []
        for (name in names) {
            def (first, last) = name.split(/\s+/)
            result << new Person(firstName: first, lastName: last)
        }
        return result
//        return -1
    }

    /**
     * <p>TODO #n: Return a list containing the heights of the people
     * in the given list. The heights should be in the same order as the original
     * list of {@code Person} objects. In this case, {@code height}
     * is a field, <em>not</em> a property. That's because it's declared with
     * a visibility scope (<tt>public</tt>).</p>
     * <p><b>Note</b> The test will pass if you use <tt>person.height</tt>
     * but you'll notice that it fails with <tt>person.getHeight()</tt>. Try it!
     * Even the IDE underlines that method name because it doesn't see it. So
     * be careful using visibility scopes on fields.</p>
     */
    List<Integer> heights(List<Person> people) {
        def result = []
        for (p in people) {
            result << p.height  // p.getHeight() doesn't work!
        }
        return result
//        return -1
    }
}

class Person {
    public int height

    String firstName
    String lastName

    String getFullName() { return "$firstName $lastName" }
}
