package com.simplicityitself.training;

/**
 * Created by Thalita on 05/10/2015.
 */
public class GroovyFiles2 {

    def firstChars(String path, Integer totalCharacters) {
        def chars = new char[totalCharacters]
        new File(path)?.withReader { it.read(chars, 0, totalCharacters) }
        return chars.toString() ?: ""
    }

    def writeBytes(String path, byte[] bytes) {
        new File(path)?.withOutputStream { it?.write(bytes) }
    }
}
