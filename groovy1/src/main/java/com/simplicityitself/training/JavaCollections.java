package com.simplicityitself.training;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class JavaCollections {

    /**
     * <p>TODO #12: Calculate the mean average of a collection of numbers.
     * All you need to do is add all the numbers together and then divide
     * the result by the number of integers in the collection.</p>
     */
    Double mean(Collection<Integer> numbers) {
        Double result = 0.0;
        if (numbers != null && !numbers.isEmpty()) {
            int sum = numbers.stream().mapToInt(x -> x).sum();
            result = (double) sum / (numbers.size());
        }
        return result;
    }

    /**
     * <p>TODO #13: Calculate the median of a collection of numbers. This
     * involves ordering the numbers by value and then:</p>
     * <ul>
     * <li>Picking the middle value if there are an odd number of values.</li>
     * <li>Calculating the mean of the middle <em>two</em> values otherwise.</li>
     * </ul>
     * <p>You can of course use {@link #mean(Collection)} to handle
     * the second case. And don't forget to check out the modulo operator shown
     * in the Groovy syntax quick reference as that will be useful here.</p>
     */
    Number median(List<Integer> numbers) {
        if (numbers != null && !numbers.isEmpty()) {
            final Integer size = numbers.size();
            Collections.sort(numbers);
            if (size == 1) {
                return numbers.get(0);
            } else if (size % 2 == 0) {
                return mean(Arrays.asList(numbers.get(size / 2), numbers.get(size / 2 - 1)));
            } else {
                return numbers.get(size / 2);
            }
        }
        return 0;
    }

    /**
     * <p>TODO #14: Create an ordered list of <tt>n</tt> even numbers, starting
     * from 0 and then incrementing by two each time, i.e. 0, 2, 4, 6, ...</p>
     */
    List<Integer> evens(int count) {
        return Stream.iterate(0, n -> n + 2).limit(count).collect(Collectors.toList());
    }

    /**
     * <p>TODO #15: Reverse the order of the given list of numbers. You should
     * do this manually rather than using the <tt>reverse()</tt> method
     */
    List<Integer> reverse(List<Integer> numbers) {
        ArrayDeque<Integer> queue = numbers.stream().collect(ArrayDeque::new, (n, q) -> n.offerFirst(q), (n, p) -> n.addAll(p));
        return new ArrayList<Integer>(queue);
    }

    /**
     * <p>TODO #16: Convert a number word ('one', 'two', etc.) to the equivalent
     * integer. You only need to handle the numbers 1 to 10. The easiest way to
     * do this is to create a map of words to their corresponding values. Return
     * {@code null} if the word is not recognised. Incoming words will be all
     * lower case.</p>
     */
    Integer wordToNumber(String numberWord) {
        Integer results = null;
        Map<String, Integer> numbers = new HashMap<>();
        numbers.put("one", 1);
        numbers.put("two", 2);
        numbers.put("three", 3);
        numbers.put("four", 4);
        numbers.put("five", 5);
        numbers.put("six", 6);
        numbers.put("seven", 7);
        numbers.put("eight", 8);
        numbers.put("nine", 9);
        numbers.put("ten", 10);

        if (numbers.containsKey(numberWord)) {
            results = numbers.get(numberWord);
        }
        return results;
    }

    /**
     * <p>TODO #17: Given a collection of strings, create a map in which the
     * keys are those strings and the map values are the string lengths.</p>
     */
    Map<String, Integer> stringSizes(Collection<String> strings) {
        return strings.stream().collect(Collectors.toMap(Function.identity(), String::length));
    }

    /**
     * <p>TODO #18: Extract all the values from the given map whose key length is
     * less than or equal to <tt>keyLength</tt>. The matching keys should be
     * returned as a collection, be that a list or a set.</p>
     */
    Collection<String> filterKeys(Map<String, String> map, int keyLength) {
        return map.keySet()
                .stream()
                .filter(k -> k.length() <= keyLength)
                .map(map::get)
                .collect(Collectors.toSet());
    }
}
