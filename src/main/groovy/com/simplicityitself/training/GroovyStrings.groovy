package com.simplicityitself.training

/**
 * Created by pledbrook on 27/08/15.
 */
class GroovyStrings {

    /**
     * <p>TODO #4: Return a greeting of the form "Hello <name>!". If no name
     * is given (the argument is {@code null} or blank), then this method
     * should return "Who are you?".</p>
     */
    String hello(String name) {
        return name?.trim() ? "Hello ${name.trim()}!" : "Who are you?"
//        return ""
    }

    /**
     * <p>TODO #5: Reverse the incoming strings. Be sure to check out the
     * <a href="http://groovy-lang.org/gdk.html">Groovy JDK documentation</a>
     * for strings! There is more than one way to do this.</p>
     */
    String reverse(String str) {
        return str.reverse()
//        return ""
    }

    /**
     * <p>TODO #6: Return the first <tt>n</tt> characters of the given string.
     * The Practical Groovy book should help here.</p>
     */
    String leadingChars(String str, int n) {
        if (n == 0) return ""
        else if (str.size() < n) return str
        else return str[0..(n-1)]
//        return ""
    }

    /**
     * <p>TODO #7: Replace all vowels in the given string with the * character.
     * There are a few ways to implement this method. If you wish to try it
     * using regular expressions, take a look at some regex examples from
     * <a href="http://mrhaki.blogspot.co.uk/2009/09/groovy-goodness-matchers-for-regular.html">MrHaki</a>.
     * </p>
     *
     * <p>If you're used to the Java regular expression classes, then read
     * <a href="http://naleid.com/blog/2008/05/19/dont-fear-the-regexp">this article</a>
     * by Ted Naleid to get an introduction to the Groovy way of using them.</p>
     */
    String replaceVowels(String str) {
        return str.replaceAll(/(?i)[aeiou]/, '*')
//        return ""
    }

    /**
     * <p>TODO #8: (Advanced) Calculate the number of characters, number of words,
     * and number of lines in a given string and return a text report of the form:</p>
     * <pre>
     *     There are:
     *
     *     * 1342 characters
     *     * 320 words
     *     * 50 lines
     *
     *     in the given text.
     * </pre>
     *
     * <p>Treat any sequence of word characters as a word. Ignore contractions,
     * such as "there's". There won't be any in the sample text. Line endings
     * will always be Unix-style, i.e. '\n'.</p>
     *
     * <p><p>
     */
    String wordStats(String str) {

    }
}
