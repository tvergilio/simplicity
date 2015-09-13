def foo = "Hello There!"
def metaClass = foo.metaClass













/*
// print the method and property names
//metaClass.methods.each { println it.name }
//metaClass.properties.each { println it.name }
println "MetaClass type: ${metaClass.class}"

// Add method via EMC
class Dog {
    def name
}

println "Dog MetaClass type before: ${Dog.metaClass.class}"
Dog.metaClass.bark = { "woof!" }
println "Dog MetaClass type after: ${Dog.metaClass.class}"

def dog = new Dog()
println dog.bark()

// Add property via EMC
Dog.metaClass.getBreed = { "Poodle" }
println dog.breed

// Add a static method
Dog.metaClass.static.create = { new Dog() }
println Dog.create().bark()

// Even add a constructor!
Dog.metaClass.constructor = { String name ->
    new Dog(name: name)
}
println new Dog('Buster').name

// Cache and invoke with methodMissing
Dog.metaClass.methodMissing = { String name, args ->
    println ">> Uncached version"
    Dog.metaClass."${name}" = { Object[] varArgs ->
        println ">> Cached version"
         name
    }
    name
}
assert "hello" == dog.hello()
assert "hello" == dog.hello()
assert "hello" == dog.hello()
assert "goodbye" == dog.goodbye()

*/