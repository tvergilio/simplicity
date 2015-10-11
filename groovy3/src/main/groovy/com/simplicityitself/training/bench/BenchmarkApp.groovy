package com.simplicityitself.training.bench

import groovyx.gbench.BenchmarkList

/**
 * <p>TODO #5: This exercise doesn't require any coding on your part. Simply run
 * this class and look at the output. You'll be able to compare how much time
 * Groovy spends performing a quicksort relative to the same algorithm in Java.
 * Once you've done that, uncomment the {@code @CompileStatic} annotation from
 * {@link GroovyQuickSort} and run the exercise again. Notice a difference?
 * Finally, replace {@code @CompileStatic} with {@code @TypeChecked} and run
 * the exercise again.</p>
 * <p>Performance is the main reason to use {@code @CompileStatic}, but do be
 * aware that the behaviour of the underlying code is different from normal
 * Groovy in a few edge cases. It's also worth bearing in mind that this kind
 * of performance boost is only apparent in computationally expensive tasks.
 * {@code @TypeChecked} has the same behaviour and performance characteristics
 * of dynamic Groovy at runtime. That's because it generates exactly the same
 * bytecode. The only difference is the compile-time type checking.</p>
 */

/**
 * @TypeChecked takes as long to run as normal Groovy because the compiler check doesn't change the compiled code.
 * @CompileStatic, on the other hand, changes the compiled Groovy code so it runs pretty much the same speed as compiled Java.
 * Results:
 *
 * without anything:
 *                        user        system      cpu         real
 * Groovy quicksort       86667300    0           86667300    86667300
 * Java   quicksort       11116610    214         11116824    11217712
 *
 *
 * with @CompileStatic:
 *                        user        system       cpu        real
 * Groovy quicksort       12275297    0            12275297   12444040
 * Java quicksort         11586424    0            11586424   11586424
 *
 * with @TypeChecked:
 *                        user        system       cpu        real
 * Groovy quicksort       84630410    0            84630410   84630410
 * Java quicksort         11625961    0            11625961   11625961
 */

class BenchmarkApp {

    static void main(String[] args) {
        def arraySize = args.size() == 1 ? args[0] as int : 100_000

        benchmark(generateRandomNumbers(arraySize) as int[]).prettyPrint()
    }

    static BenchmarkList benchmark(int[] numbers) {
        return benchmark {
            'Groovy quicksort' {
                GroovyQuickSort.quickSort(numbers.clone())
            }
            'Java quicksort' {
                JavaQuickSort.quickSort(numbers.clone())
            }
        }
    }

    private static List<Integer> generateRandomNumbers(int length) {
        List<Integer> result = new ArrayList(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            result.add(random.nextInt(length));
        }

        return result;
    }
}
