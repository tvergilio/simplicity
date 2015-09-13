def builder = new groovy.json.JsonBuilder()
def root = builder.people { 
   person {
       firstName 'Guillame'
       lastName 'Laforge'
       married true
   }
}
    
// Builder methods return a Map (in this case) of the data passed into 'builder' 
assert root instanceof Map
assert builder.toString() == 
   '{"people":{"person":{"firstName":"Guillame","lastName":"Laforge","married":true}}}'





/*
class Person {
  def firstName
  def lastName
}
def persons = [new Person(firstName:'Guillame',lastName:'Laforge'),
                         new Person(firstName:'Dierk',lastName:'Konig')]
def builder = new groovy.json.JsonBuilder(people:persons)
*/