package com.simplicityitself.training

/**
 *  <p>These exercises give you a chance to work with the Java collections in
 * Groovy. If you would like a gentle introduction beyond the Groovy quick
 * reference, read the
 * <a href="http://pledbrook.github.io/practical-groovy-public/#_collections_ranges_and_maps">Collections,
 * ranges, and maps</a> section of the in-progress Practical Groovy book.
 * You should also take a look at the <a href="http://groovy-lang.org/gdk.html">Groovy JDK</a>
 * extensions as you may find some useful methods and properties there.</p>
 */
class GroovyCollections {

    /**
     * <p>TODO #12: Calculate the mean average of a collection of numbers.
     * All you need to do is add all the numbers together and then divide
     * the result by the number of integers in the collection.</p>
     */
    BigDecimal mean(Collection<Integer> numbers) {
        return numbers.sum() / numbers.size()
//        return -1
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
    BigDecimal median(Collection<Integer> numbers) {
        if (numbers.size() % 2 == 0) {
            // Even number of values
            def firstIndex = numbers.size().intdiv(2) - 1
            return mean(numbers.sort()[firstIndex..(firstIndex + 1)])
        }
        else {
            def index = numbers.size().intdiv(2)
            return numbers.sort()[index]
        }
//        return -1
    }

    /**
     * <p>TODO #14: Create an ordered list of <tt>n</tt> even numbers, starting
     * from 0 and then incrementing by two each time, i.e. 0, 2, 4, 6, ...</p>
     */
    List<Integer> evens(int count) {
        def result = []
        for (i in 0..<count) {
            result << i * 2
        }
        return result
//        return []
    }

    /**
     * <p>TODO #15: Reverse the order of the given list of numbers. You should
     * do this manually rather than using the <tt>reverse()</tt> method that
     * Groovy adds to lists. You might want to use
     * <a href="http://mrhaki.blogspot.co.uk/2009/03/use-negative-index-in-groovy-lists-to.html">negative
     * indexes</a> in this exercise, although they're not required.</p>
     */
    List<Integer> reverse(List<Integer> numbers) {
        def result = []
        for (i in 0..<numbers.size()) {
            result << numbers[-(i + 1)]
        }
        return result
//        return []
    }

    /**
     * <p>TODO #16: Convert a number word ('one', 'two', etc.) to the equivalent
     * integer. You only need to handle the numbers 1 to 10. The easiest way to
     * do this is to create a map of words to their corresponding values. Return
     * {@code null} if the word is not recognised. Incoming words will be all
     * lower case.</p>
     */
    Integer wordToNumber(String numberWord) {
        def map = [one: 1, two: 2, three: 3, four: 4, five: 5, six: 6, seven: 7, eight: 8, nine: 9, ten: 10]
        return map[numberWord]
//        return 0
    }

    /**
     * <p>TODO #17: Given a collection of strings, create a map in which the
     * keys are those strings and the map values are the string lengths.</p>
     */
    Map<String, Integer> stringSizes(Collection<String> strings) {
        def map = [:]
        for (str in strings) {
            map[str] = str.size()
        }
        return map
//        return [:]
    }

    /**
     * <p>TODO #18: Extract all the values from the given map whose key length is
     * less than or equal to <tt>keyLength</tt>. The matching keys should be
     * returned as a collection, be that a list or a set.</p>
     */
    Collection<String> filterKeys(Map<String, String> map, int keyLength) {
        def result = []
        for (entry in map) {
            if (entry.key.size() <= keyLength) result << entry.value
        }
        return result
//        return [:]
    }
}
