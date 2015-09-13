// Common closure usage
3.times {
    println 'The Closure Is Executing...'
}












/*
// Assign to variable and pass as argument
def myClosure = {
    println 'myClosure Is Executing...'
}
3.times(myClosure)
1.times myClosure

// Closure with an argument
myClosure = { firstArg ->
    println "Argument Value: ${firstArg}"
}
2.times(myClosure)

// The implicit argument 'it'
myClosure = {
    println "Implicit Argument Value: ${it}"
}
2.times(myClosure)

// Multiple arguments
def area = { x, y ->
    x * y
}
println area(4, 9)
println area(6, 7)


println "Closure parameter count: ${ area.maximumNumberOfParameters }"
println "Closure parameter types: ${ area.parameterTypes }"
*/
