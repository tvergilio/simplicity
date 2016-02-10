package com.simplicityitself.training;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Thalita on 05/10/2015.
 */
class JavaNumbers2 {

    List<Integer> getPositiveNumbers(List<Integer> numberList) {
        return numberList == null ? null : numberList
                .stream()
                .filter(x -> x > 0)
                .collect(Collectors.toList());
    }

    List<Integer> getMagnitudeGreaterThanTen(List<Integer> numberList) {
        return numberList == null ? null : numberList
                .stream()
                .filter(x -> Math.abs(x) > 10)
                .collect(Collectors.toList());
    }

    Integer getFirstMagnitudeGreaterThanTen(List<Integer> numberList) {
        Integer result = null;
        if (numberList != null) {
            Optional<Integer> optional = numberList
                    .stream()
                    .filter(x -> Math.abs(x) > 10)
                    .findFirst();
            result = optional.orElse(null);
        }
        return result;
    }

    List<Integer> getSquares(List<Integer> numberList) {
        return numberList == null ? null : numberList
                .stream()
                .map(x -> x * x)
                .collect(Collectors.toList());
    }

    Long getCountMagnitudeGreaterThanTen(List<Integer> numberList) {
        return numberList == null ? null : numberList
                .stream()
                .filter(x -> Math.abs(x) > 10)
                .mapToInt(p -> p)
                .count();
    }

    List<Integer> getEvenNumbersBetweenZeroAndTwenty() {
        return IntStream.rangeClosed(0, 20)
                .filter(x -> x % 2 == 0)
                .collect(ArrayList<Integer>::new, List::add, List::addAll);
    }
}
