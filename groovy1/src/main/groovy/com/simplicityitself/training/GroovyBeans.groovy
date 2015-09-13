package com.simplicityitself.training

/**
 * <p>You'll practice property syntax with these exercises, with the purpose
 * of embedding the understanding that properties are defined by getters and
 * setters (or `is` methods in the case of boolean properties). Several examples
 * are given in MrHaki's
 * <a href="http://mrhaki.blogspot.co.uk/2009/08/groovy-goodness-groovybeans-simpler.html">
 * Groovy Goodness</a> blog.</p>
 */
class GroovyBeans {

    /**
     * <p>TODO #28: Return a list containing just the first names of the people
     * in the given list. The names should be in the same order as the original
     * list of {@code Person} objects.</p>
     * <p><b>Note</b> The test will pass whether you use <tt>person.firstName</tt>
     * or <tt>person.getFirstName()</tt>. Try it!</p>
     */
    List<String> firstNames(List<Person> people) {
        return []
    }

    /**
     * <p>TODO #29: Return a list containing the full names of the people
     * in the given list. The names should be in the same order as the original
     * list of {@code Person} objects. In this case, the {@code fullName}
     * property is read-only because only a getter method is defined.</p>
     * <p><b>Note</b> The test will pass whether you use <tt>person.fullName</tt>
     * or <tt>person.getFullName()</tt>. Try it!</p>
     */
    List<String> fullNames(List<Person> people) {
        return []
    }

    /**
     * <p>TODO #30: Modify the <tt>firstName</tt> and <tt>lastName</tt> properties
     * of the given <tt>Person</tt> by making all the letters upper case. Note
     * that Groovy adds a useful method to strings that converts them to upper
     * case, so check out the <a href="http://groovy-lang.org/gdk.html">Groovy JDK</a>.</p>
     * <p><b>Note</b> The test will pass whether you use <tt>person.firstName = ...</tt>
     * or <tt>person.setFullName(...)</tt>. Try it!</p>
     */
    void namesToUpperCase(Person person) {
    }

    /**
     * <p>TODO #31: Create a list of {@code Person} objects that have the given
     * full names. You will need to split each full name yourself (at the space
     * character) and then initialise a new {@code Person} instance with the
     * resulting two values (first name and last name).</p>
     */
    List<Person> createPeople(List<String> names) {
        return []
    }

    /**
     * <p>TODO #32: Return a list containing the heights of the people
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
        return []
    }
}

class Person {
    public int height

    String firstName
    String lastName

    String getFullName() { return "$firstName $lastName" }
}
