package com.simplicityitself.training;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Thalita on 05/10/2015.
 */
class JavaInterfaces {

    List<String> getWordsSortedByLength(List<String> words) {
        if (words != null) {
            words.sort(Comparator.comparing(String::length));
        }
        return words;
    }

    List<String> getWordsSortedAlphabetically(List<String> words) {
        if (words != null) {
            words.sort(Comparator.comparing(String::toUpperCase));
        }
        return words;
    }
}
