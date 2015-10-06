package com.simplicityitself.training

/**
 * Created by Thalita on 05/10/2015.
 */
class GroovyNumbers2 {

    def getPositiveNumbers(List<Integer> numberList) {
        return numberList?.findAll { it > 0 }
    }

    def getMagnitudeGreaterThanTen(List<Integer> numberList) {
        return numberList?.findAll { it.abs() > 10 }
    }

    def getFirstMagnitudeGreaterThanTen(List<Integer> numberList) {
        return numberList?.find { it.abs() > 10 }
    }

    def getSquares(List<Integer> numberList) {
        return numberList?.collect { it**2 }
    }

    def getCountMagnitudeGreaterThanTen(List<Integer> numberList) {
        return numberList?.count { it.abs() > 10 }
    }

    def getEvenNumbersBetweenZeroAndTwenty() {
        return (0..20).findAll { it % 2 == 0 }
    }
}
