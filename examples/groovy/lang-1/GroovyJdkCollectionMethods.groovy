def languages = ['Groovy', 'Haskell', 'Java']
languages.each { langName ->
    println "Language Name: ${langName}"
}












/*
def myMap = [company: 'SpringSource', instructor: 'Peter Ledbrook']
myMap.each { key, value ->
    println "${key} is ${value}"
}

myMap.each { entry ->
    println "${entry.key} is ${entry.value}"
}

def l = [ 3, 6, 23, -10, 9, -1, -34, 3, 14 ]
println l.find { it > 10 }
println l.findAll { it > 10 }
println l.findAll { it > 0 }

// Using inject() to calculate the sum of integers
def sum(list) {
    list.inject(0) { sum, i -> sum + i }
}
println "Sum of list items : ${sum(l)}"

// The very useful collect() method
println l.collect { it - 3 }
*/
