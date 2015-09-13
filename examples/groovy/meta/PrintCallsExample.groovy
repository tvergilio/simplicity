class PrintCalls {
    void hi() {
        println "Hi!"
    }
    
    def invokeMethod(String name, args) {
        println "Calling invokeMethod(" + name + ", " + args + ")"
    }
    
    def getProperty(String name) {
        println "Calling getProperty(${name})"
    }
    
    void setProperty(String name, value) {
        println "Calling setProperty(${name}, ${value})"
    }
}

def p = new PrintCalls()
p.hi()
p.bark()
p.multiply(2, 6.0)
p.status
p.status = "Done"