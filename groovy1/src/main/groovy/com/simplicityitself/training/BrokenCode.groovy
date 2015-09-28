package com.simplicityitself.training

/**
 * <p>Each of the methods in this class has a bug in it that you need to fix.
 * Simply run the tests and see the error messages from those tests to diagnose
 * the problems. The information provided on the training day about diagnosing
 * problems should help.</p>
 */
class BrokenCode {
    /**
     * <p>TODO #1: The test for this method throws an exception because there
     * is an error in the code. Identify and fix that error. Use the information
     * provided on the training day for diagnosing problems. The key is to
     * understand the exception message and stack trace.
     */
    int sumNumbers(numbers) {
        def result = 0
        for (int i in numbers) {
            result += i
        }
        return result
    }

    /**
     * <p>TODO #2: The test for this method throws an exception because there
     * is an error in the code. Identify and fix that error. Use the information
     * provided on the training day for diagnosing problems. The key is to
     * understand the exception message and stack trace.
     */
    Collection<String> reverseStrings(Collection<String> strings) {
        def result = []
        for (str in strings) {
            result << str.reverse()
        }
        return result
    }

    /**
     * <p>TODO #3: The test for this method throws an exception because there
     * is an error in the code. Identify and fix that error. Use the information
     * provided on the training day for diagnosing problems. The key is to
     * understand the exception message and stack trace.
     */
    Collection<String> altReverseStrings(Collection<String> strings) {
        def result = new ArrayList<String>()
        if (strings != null && !strings.isEmpty()) {
            for (str in strings) {
                result << str.reverse()
            }
        }
        return result
    }
}
