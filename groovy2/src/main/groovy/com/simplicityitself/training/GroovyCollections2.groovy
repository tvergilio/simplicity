package com.simplicityitself.training

/**
 * Created by Thalita on 06/10/2015.
 */
class GroovyCollections2 {

    Integer getProduct(List<Integer> numbers) {
        if (!numbers) {
            return null
        } else {
            return numbers?.inject { a, b -> a * b }
        }
    }

    Integer getSumOfSquares(List<Integer> numbers) {
        return numbers?.inject(0) { a, b -> a + b**2 }
    }

    Map<String, List<Integer>> getGroupedNumbers(List<Integer> numbers) {
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
