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
     * <p>TODO #4: Calculate the VAT to be applied to the given value, with a
     * VAT rate of 20%. The result should ideally be rounded to two decimal
     * places, although you can skip this if you want.</p>
     *
     * <p>If you want to attempt the rounding, first read the API documentation
     * for <a href="https://docs.oracle.com/javase/8/docs/api/?java/math/BigDecimal.html">BigDecimal</a>.
     * Note that "scale" effectively refers to the number of decimal places,
     * so a scale of 2 means the number has two decimal places.</p>
     */
    BigDecimal calculateVat(BigDecimal value) {
        def absolute = value*0.20
        return absolute.setScale(2, BigDecimal.ROUND_UP)
    }

    /**
     * <p>TODO #5: Calculate the length of a right-angled triangle using the
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
        return Math.sqrt(side1*side1 + side2*side2)
    }


    /**
     * <p>TODO #6: (Advanced) Calculate the number at a given position in the
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
     *
     * <p>To verify that your implementation can handle very large Fibonacci
     * numbers, uncomment the fib(20,000) data set from the <tt>GroovyNumbersSpec</tt>
     * test case.</p>
     */
    int fibonacci(int n) {
        assert n >= 0;
        if (n == 0 || n == 1) {
            return n;
        } else {
//            ​recurrence - get result of one above in the sequence plus result of two above in the sequence
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
