import groovy.transform.TypeChecked

class TypeExamples {
    String name
    
    String getDoubleName() {
        return nme * 2
    }
    
    def method() {
        def num = 123 // num is an int
        int i = num
        num = "123" // num is now a String
        i = num.toInteger() // no error
        i = num // error
    }
    
    int truth() {
        if (true) return "The Truth"
        else return 42
    }
}

println "Done"