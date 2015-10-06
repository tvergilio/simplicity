package com.simplicityitself.training

/**
 * Created by Thalita on 06/10/2015.
 */
class GroovyCollections2 {

    def getProduct(List<Integer> numbers) {
        if (!numbers) {
            return 0
        } else {
            return numbers?.inject { a, b -> a * b }
        }
    }

    def getSumOfSquares(List<Integer> numbers) {
        return numbers?.inject(0) { a, b -> a + b**2 }
    }

    def getGroupedNumbers(List<Integer> numbers) {
        def groupByClosure = {
            if (it == 0) {
                return "zero"
            } else if (it > 0) {
                return "positive"
            } else {
                return "negative"
            }
        }
        return numbers?.groupBy(groupByClosure)
    }
}
