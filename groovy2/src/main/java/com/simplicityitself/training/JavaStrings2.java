package com.simplicityitself.training;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Thalita on 05/10/2015.
 */
class JavaStrings2 {

    List<String> getWordsContainingA(List<String> words) {
        return words == null ? null : words.stream()
                .filter(s -> s.contains("a"))
                .collect(Collectors.toList());
    }

    List<String> getLongWords(List<String> words) {
        return words == null ? null : words.stream()
                .filter(s -> s.length() > 5)
                .collect(Collectors.toList());
    }

    List<Integer> getWordLengths(List<String> words) {
        return words == null ? null : words.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }

    List<String> getWordsInUppercase(List<String> words) {
        return words == null ? null : words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    List<String> getWordsSortedByLength(List<String> words) {
        return words == null ? null : words.stream()
                .sorted() //if same length, sort alphabetically, i.e. by natural order
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    String getFirstElementStartingWithP(List<String> words) {
        return words == null ? null : words.stream()
                .filter(s -> s.startsWith("p"))
                .findFirst()
                .orElse(null);
    }
}
