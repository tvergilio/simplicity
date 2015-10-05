package com.simplicityitself.training

/**
 * Created by Thalita on 05/10/2015.
 */
class GroovyStrings2 {

    def getWordsContainingA(List<String> words) {
        return words?.findAll { it.contains('a') }
    }

    def getLongWords(List<String> words) {
        return words?.findAll { it.length() > 5 }
    }

    def getWordLengths(List<String> words) {
        return words?.collect { it.length() }
    }

    def getWordsInUppercase(List<String> words) {
        return words?.collect { it.toUpperCase() }
    }

    def getWordsSortedByLength(List<String> words) {
        return words?.sort { a, b ->
            a.length() <=> b.length() ?: a <=> b
        }
    }
}
