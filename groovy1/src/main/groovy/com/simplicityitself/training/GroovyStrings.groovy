package com.simplicityitself.training

import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * <p>These exercises give you a chance to work with strings in Groovy. If you
 * would like a gentle introduction beyond the Groovy quick reference, read the
 * <a href="http://pledbrook.github.io/practical-groovy-public/#_the_joy_of_strings">joy
 * of strings</a> section of the in-progress Practical Groovy book.</p>
 */
class GroovyStrings {

    /**
     * <p>TODO #7: Return a greeting of the form "Hello <name>!". If no name
     * is given (the argument is {@code null} or blank), then this method
     * should return "Who are you?".</p>
     */
    String hello(String name) {
        def greeting = "Who are you?"
        if (name != null && !name.isEmpty()) {
            greeting = "Hello ${name}!"
        }
        return greeting
    }

    /**
     * <p>TODO #8: Reverse the incoming strings. Be sure to check out the
     * <a href="http://groovy-lang.org/gdk.html">Groovy JDK documentation</a>
     * for strings! There is more than one way to do this.</p>
     */
    String reverse(String str) {
        return str.reverse()
    }

    /**
     * <p>TODO #9: Return the first <tt>n</tt> characters of the given string.
     * The Practical Groovy book should help here.</p>
     */
    String leadingChars(String str, int n) {
        def result = str
        if (str != null && n < str.length()) {
            result = str.substring(0, n)
        }
            return result
        }

    /**
     * <p>TODO #10: Replace all vowels in the given string with the * character.
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
        /* old Java way
        Matcher matcher = str =~ /[aeiouAEIOU]/
        def result = str
        def match
        while(matcher.find()) {
            match = matcher.group()
            result = result.replace(match, '*')
        }
        return result
        */
        return str.replaceAll(/[AaEeIiOoUu]/, '*')
    }

    /**
     * <p>TODO #11: (Advanced) Calculate the number of characters, number of
     * lines, number of single-letter words, number of hyphenated words and
     * the number of all caps words. Return the results in a map with the
     * keys:</p>
     * <ul>
     *     <li><em>charCount</em></li>
     *     <li><em>lineCount</em></li>
     *     <li><em>singleLetterCount</em></li>
     *     <li><em>hyphenatedCount</em></li>
     *     <li><em>allCapsCount</em></li>
     * </ul>
     * <p>You can do this in a number of ways, but the easiest is probably
     * through regular expressions. Ted Naleid wrote an
     * <a href="http://naleid.com/blog/2008/05/19/dont-fear-the-regexp">old
     * but still useful blog post</a> about how Groovy incorporates regex
     * support at the language level. If you're new to Java regular expressions,
     * take a look through the
     * <a href="https://docs.oracle.com/javase/tutorial/essential/regex/">Java
     * tutorial</a> first.
     *
     * <p>Ignore contractions, such as "there's". There won't be any in the
     * sample text. Line endings will always be Unix-style, i.e. '\n'.</p>
     */
    Map wordStats(String str) {
        /*
        def result = [:]
        if (str != null) {
            //Declare Regex patterns and matchers
            Matcher carriageReturn = str =~ /[\n\r]+/
            Matcher singleLetter = str =~ /\b[a-zA-Z]\b/
            Matcher hyphenated = str =~ /\b[a-zA-Z]+\-[a-zA-Z]+\b/
            Matcher allCaps = str =~ /\b[A-Z]+\b/

            //declare count variables
            int charCount = 0
            int lineCount = str.isEmpty() ? 0 : 1
            int singleLetterCount = 0
            int hyphCount = 0
            int capsCount = 0

            //find character count and add to map
            result.charCount = str.length()

            //find line count and add to map
            while (carriageReturn.find()) {
                lineCount ++
            }
            result.lineCount = lineCount

            //find single letter count and add to map
            while (singleLetter.find()) {
                singleLetterCount ++
            }
            result.singleLetterCount = singleLetterCount

            //find hyphenated count and add to map
            while (hyphenated.find()) {
                hyphCount ++
            }
            result.hyphenatedCount = hyphCount

            //find all caps count and add to map
            while (allCaps.find()) {
                capsCount ++
            }
            result.allCapsCount = capsCount
        }
        return result
        */
        def singleLetters = (str =~ /\b[a-zA-Z]\b/).count
        def hyphenated = (str =~ /\b[a-zA-Z]+\-[a-zA-Z]+\b/).count
        def allCaps = (str =~ /\b[A-Z]+\b/).count

        return [charCount: str.length(), lineCount: str.readLines().size(), singleLetterCount: singleLetters, hyphenatedCount: hyphenated, allCapsCount: allCaps]

    }
}
