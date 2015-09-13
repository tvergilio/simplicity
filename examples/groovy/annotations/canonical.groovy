import groovy.transform.Immutable
import groovy.transform.Canonical

//@Canonical
class Person {
    String name
    int age
    
    List<Person> children = []
}

def p = new Person("Peter", 25, [new Person("Jerry", 2, [])])

println p

println "Done!"