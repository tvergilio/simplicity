package com.simplicityitself.training;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Thalita on 06/10/2015.
 */
class JavaCollections2 {

    Integer getProduct(List<Integer> numbers) {
        Integer result = null;
        if (numbers != null && !numbers.isEmpty()) {
            result = numbers.stream().reduce(1, (p, q) -> p * q);
        }
        return result;
    }

    Integer getSumOfSquares(List<Integer> numbers) {
        Integer result = null;
        if (numbers != null) {
            result = numbers.stream().mapToInt(x -> x * x).sum();
        }
        return result;
    }

    Map<String, List<Integer>> getGroupedNumbers(List<Integer> numbers) {
        if (numbers != null) {
            Function<Integer, String> groupByFunction = x -> {
                if (x == 0) {
                    return "zero";
                } else if (x > 0) {
                    return "positive";
                } else {
                    return "negative";
                }
            };
            return numbers.stream().collect(Collectors.groupingBy(groupByFunction));
        } else {
            return null;
        }
    }

}
