class PersonWithClosures {
    String name
    int age

//  boolean isYoungerThan(int years) {
    def isYoungerThan = { int years ->
        return age < years
    }
    
//  def machineReadableString() {    
    def machineReadableString = {->
        return "${name}:${age}".toString()
    }
    
    String toString() {
        return "${name} (${age})"
    }
}

def p = new PersonWithClosures(name: "Jake", age: 24)
println p.machineReadableString()
println p.toString()
println p.isYoungerThan.call()

p.class.methods.findAll { it.name.endsWith("String") }.each {
    println it
}