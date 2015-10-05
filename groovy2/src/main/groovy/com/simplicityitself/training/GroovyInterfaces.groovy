package com.simplicityitself.training

/**
 * Created by Thalita on 05/10/2015.
 */
class GroovyInterfaces {

    def getWordsSortedByLength(List<String> words) {
        return words?.sort(false, new Comparator<String>() {
            @Override
            int compare(String o1, String o2) {
                o1?.length() <=> o2?.length()
            }
        })
    }

    def getWordsSortedAlphabetically(List<String> words) {
        return words?.sort(false, new Comparator<String>() {
            @Override
            int compare(String o1, String o2) {
                o1?.toUpperCase() <=> o2?.toUpperCase()
            }
        })
    }
}
