def testString = "The rain in Spain falls mainly in the plain"

// Matching
assert testString =~ /ain/
assert !(testString ==~ /ain/)
assert testString ==~ "The rain in Spain falls mainly in the plain"

// Regex groups
def m = testString =~ /(\w*)ain(\w*)/
assert m instanceof java.util.regex.Matcher

if (m) {
    for (match in m) {
        println "New match:"
        println match[0]
        println match[1]
        println match[2]
    }
}

// Literal patterns
def pattern = ~/(\w*)ain(\w*)/
assert pattern instanceof java.util.regex.Pattern