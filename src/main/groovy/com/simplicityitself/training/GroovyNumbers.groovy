package com.simplicityitself.training

/**
 * <p>These exercises give you a chance to work with various types of number in
 * Groovy. If you would like a gentle introduction beyond the Groovy quick
 * reference, read the
 * <a href="http://pledbrook.github.io/practical-groovy-public/#_groovy_as_a_calculator">Groovy
 * as a calculator</a> section of the in-progress Practical Groovy book.</p>
 */
class GroovyNumbers {
    /**
     * <p>TODO #1: Calculate the VAT to be applied to the given value, with a
     * VAT rate of 20%. The result should ideally be rounded to two decimal
     * places, although you can skip this if you want.</p>
     *
     * <p>If you want to attempt the rounding, first read the API documentation
     * for <a href="https://docs.oracle.com/javase/8/docs/api/?java/math/BigDecimal.html">BigDecimal</a>.
     * Note that "scale" effectively refers to the number of decimal places,
     * so you can a scale of 2 means the number has two decimal places.</p>
     */
    BigDecimal calculateVat(BigDecimal value) {
//        return (value * 0.2).setScale(2, RoundingMode.HALF_UP)
        return -1
    }

    /**
     * <p>TODO #2: Calculate the length of a right-angled triangle using the
     * Pythagorean Theorem: the square of the hypotenuse is the sum of the
     * squares of the other two sides. In other words, h(squared) = a(squared)
     * + b(squared).</p>
     *
     * <p>You will want to look at the API docs for the
     * <a href="https://docs.oracle.com/javase/8/docs/api/?java/lang/Math.html">Math</a>
     * class for this exercise. Also check the Groovy quick reference for
     * the available operators.</p>
     */
    double hypotenuseLength(double side1, double side2) {
        return -1
//        return Math.sqrt(side1 ** 2 + side2 ** 2)
    }


    /**
     * <p>TODO #3: (Advanced) Calculate the number at a given position in the
     * Fibonnaci sequence. This sequence is formed by each number being the sum
     * of the previous two numbers in the sequence. The first two numbers are
     * 1 and 1. Hence the third number is 2 (1 + 1) and the next is 3 (1 + 2).
     * </p>
     *
     * <p>You can use any approach you want, including creating extra methods
     * in this class (particularly useful if you want to use recursion). If
     * you do want to use recursion and fancy a challenge, try making the
     * method tail recursive so it's fast and doesn't break for larger numbers.
     * See <a href="http://mrhaki.blogspot.co.uk/2014/05/groovy-goodness-more-efficient-tail.html">this
     * article</a> for a quick primer.</p>
     *
     * <p>Also, beware of integer overflows if you want to handle large Fibonacci
     * numbers. Remember that <tt>int</tt> is only 32 bits, so can only hold
     * numbers up to and including 2,147,483,647. You'll have to change the
     * method signature to BigInteger to handle really large numbers.
     * See the Practical Groovy link mentioned in the class javadoc.</p>
     */
    int fibonacci(int n) {
//        if (n == 1) return 1
//        else if (n == 2) return 1
//        else return fibonacci(n - 1) + fibonacci(n - 2)
//        else return fastFib(1, 1, n)

        return -1
    }

//    @TailRecursive
//    int fastFib(int a, int b, int n) {
//        return n > 1 ? fastFib(b, a + b, n - 1) : a
//    }
}
