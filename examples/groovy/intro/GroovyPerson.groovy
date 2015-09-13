class GroovyPerson {
    // dynamically typed property
    def age

    // statically typed property
    String name

    def printName() {
        println name
    }

    static void main(String[] args) {
        def person = new GroovyPerson(age: 8,
                                      name: 'Jake')
        person.printName()
    }
}
