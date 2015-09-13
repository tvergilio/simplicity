package org.example

import spock.lang.Specification

class NumberHelperSpec extends spock.lang.Specification {
    def "Some test"() {
        given: "An initial value"
        def i = 100

        expect: "Dividing by 2 results in half that value"
        i / 2 == 50
    }
	
	def "Test the findPositives with #data "() {
		given: "A number helper"
		def helper = new GroovyNumberHelper()
		
	}
		
		
		
		
		
		
		
		
		
	/*
    def "Test the findPositives() method"() {
        given: "A number helper"
        def helper = new JavaNumberHelper()
        
        when: "findPositives() is called"
        def result = helper.findPositives(data as int[])

        then: "it should return a list of all numbers in the given data that are greater than or equals to zero"
        result == expected

        where:
        data              | expected
        []                | []
        [-1]              | []
        [0]               | [0]
        [5]               | [5]
        [1, -2, 4, 7, -3] | [1, 4, 7]
    }
*/
}
