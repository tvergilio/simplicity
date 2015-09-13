def slurper = new groovy.json.JsonSlurper()
def result = 
  slurper.parseText('{"person":{"name":"Guillaume","age":33,"pets":["dog","cat"]}}')

assert result.person.name == "Guillaume"
assert result.person.age == 33
assert result.person.pets.size() == 2
assert result.person.pets[0] == "dog"
assert result.person.pets[1] == "cat"

// Iterating on the list of pets
result.person.pets.each { println it }