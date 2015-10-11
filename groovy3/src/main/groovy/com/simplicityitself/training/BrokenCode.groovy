package com.simplicityitself.training

import groovy.transform.TypeChecked

import java.math.RoundingMode

/**
 * <p>TODO #4: This class contains several errors that can be picked up by
 * static type checking. Uncomment the {@code @TypeChecked} annotation and then
 * fix the errors. Note that parameterised types usually need to be explicitly
 * declared as such.</p>
 */
//@TypeChecked
//This annotation doesn't seem to work with Spock. It causes the compilation to fail.

class BrokenCode {

    int sumNumbers(Collection<Integer> numbers) {
        def result = 0
        for (int i in numbers) {
            result += i
        }
        return result
    }

    BigDecimal calculateVat(BigDecimal value) {
        return (value * 0.2).setScale(2, RoundingMode.HALF_UP)
    }

    def mean(Collection<Integer> numbers) {
        return ((Integer) numbers.sum()) / numbers.size()
    }

    BigDecimal median(Collection<Integer> numbers) {
        if (numbers.size() % 2 == 0) {
            // Even number of values
            def firstIndex = Math.floorDiv(numbers.size(), 2) - 1
            return (BigDecimal) mean(numbers.sort()[firstIndex..(firstIndex + 1)])
        } else {
            def index = Math.floorDiv(numbers.size(), 2)
            return numbers.sort().get(index)
        }
    }

    List<String> reverseStrings(Collection<String> strings) {
        def result = []
        for (str in strings) {
            result << str.reverse()
        }
        return result
    }
}
