// Lists
def names = ['Jeff']
names << 'Betsy'
names += ['Jake', 'Zack']

println "${names} (${names.class})"

// Maps
def myMap = [company: 'SpringSource']
myMap['favoriteLanguage'] = 'Groovy'
myMap.favoriteFramework = 'Grails'

assert myMap['company'] == 'SpringSource'
assert myMap.favoriteLanguage == 'Groovy'
assert myMap['favoriteFramework'] == 'Grails'

println "${myMap} (${myMap.getClass()})"

// Useful Groovy JDK method!
println([ "Oranges", "Apples", "Lemons", "Pears" ].join("::"))

// Want an array or a set?
def array = names as String[]
println "${array} (${array.class})"

def set = names as Set
println "${set} (${set.class})"

// Ranges
def r = 0..10
println "${r} (${r.class})"
assert r instanceof List

// Exclusive range
r = 0..<10
println "${r} (${r.class})"

assert 5 in r
assert !(10 in r)

// Loop
for (int i in r) {
    print i
    print ' '
}
println()
