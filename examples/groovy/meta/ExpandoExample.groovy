// Dynamic object. This one looks like a Person.
def p = new Expando(name: "Jake", age: 24)
println p

// Add properties.
p.gender = "Male"
println p
println p.name

// Add methods.
p.toString = {-> "${name} (${age})" }
println p

p.addYears = { years -> age += years }
p.addYears(25)
println p