package com.simplicityitself.training;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class JavaDates {

    /**
     * <p>TODO #19: Add a given number of days to a date to create a new date.
     */
    LocalDate addDays(LocalDate start, int numDays) {
        return start.plusDays(numDays);
    }

    /**
     * <p>TODO #20: Calculate the difference between two time instants in days.
     */
    int diffDays(long time1, long time2) {
        return (int) Duration.between(Instant.ofEpochMilli(time1), Instant.ofEpochMilli(time2))
                .toDays();
    }

    /**
     * <p>TODO #21: Format a date using the pattern "dd MMM yyyy".
     */
    String formattedDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        return formatter.format(date);
    }
}
