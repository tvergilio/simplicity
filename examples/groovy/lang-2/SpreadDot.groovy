def l = [
    new Person(name: "Jake", age: 24),
    new Person(name: "Jane", age: 21),
    new Person(name: "Mark", age: 44),
    new Person(name: "Anne", age: 32),
    new Person(name: "Chris", age: 28) ]

println l.collect { it.name }
println l*.name
println l.name
println l*.displayName()
//println l.displayName()