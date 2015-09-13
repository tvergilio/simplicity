def str1 = 'This is a string'
def str2 = "This is another string"

println str1 + " (" + str1.class + ")"
println str2 + " (" + str2.class + ")"











/*
// GString
def name = "Gary"
str1 = 'Hello ${name}'
str2 = "Hello ${name}"

println str1 + " (" + str1.class + ")"
println str2 + " (" + str2.class + ")"

// GString is an instance of CharSequence (Java 5)
assert str2 instanceof CharSequence

// GStrings automatically coerced to Strings
String str3 = str2
println "Coerced string: ${str3}"
assert str3 instanceof String

// No curly braces
str2 = "Hello $name"
println str2 + " (" + str2.class + ")"

// size() == length()
str1 = "Hello world!"
assert str1.size() == str1.length()

// Character literal
char ch1 = 'h'
def ch2 = 'h' as char
assert ch1 instanceof Character
assert ch2 instanceof Character

// Individual characters
def message = "Groovy Is Cool"
println message[0]
println message[-4]

// Sub-strings
println message[0..5]
println message[-4..-1]

// Reversed!
println message[-1..-4]


// Appending to strings
message << ", so is Grails!"
println message

// ..PS Add <<= !
assert message != "Groovy Is Cool, so is Grails!"
*/
