package com.simplicityitself.training
/**
 * <p>Dates and times are an important part of any language. Unfortunately the
 * old API of {@code java.util.Date} and {@code java.util.Calendar} are quite
 * poor when it comes to working with historic dates and date calculations. In
 * these exercises we'll simply focus on the very basics of the <tt>Date</tt>
 * class.</p>
 * <p>In essence, a <tt>Date</tt> represents a fixed instant in time, recorded
 * as the number of milliseconds since January 1, 1970, 00:00:00 UTC. It's an
 * abstraction of the value returned by
 * <a href="https://docs.oracle.com/javase/8/docs/api/?java/lang/System.html">
 * <tt>System.currentTimeMillis()</tt></a>.</p>
 * <p>It's common to want to convert dates into textual representations. Java
 * has the {@code java.text.DateFormat} and {@code java.text.SimpleDateFormat}
 * classes for this, but as you'll discover in
 * <a href="http://mrhaki.blogspot.co.uk/2009/08/groovy-goodness-working-with-dates.html">MrHaki's blog</a>,
 * Groovy adds some convenience methods to bypass those classes.</p>
 * <p><b>Note</b> If you are planning to do any serious date and/or time work,
 * then either use the new Java Date &amp; Time API (Java 8 and above) or Joda
 * Time (a third-party library). They both provide a much better API overall
 * that is easy to use for both simple and complex requirements. If you're
 * interested in giving the new Java 8 API a try, check out the official
 * <a href="https://docs.oracle.com/javase/tutorial/datetime/">Java tutorial</a>
 * which introduces the topic in several chunks.</p>
 */
class GroovyDates {

    /**
     * <p>TODO #19: Add a given number of days to a date to create a new date.
     * You'll find just the methods you need in the
     * <a href="http://docs.groovy-lang.org/docs/next/html/groovy-jdk/?java/util/Date.html">Groovy
     * JDK for {@code Date}</a>. You should also take a look at the operator
     * overloading table that's in the Groovy syntax quick reference.</p>
     */
    Date addDays(Date start, int numDays) {
        return start + numDays
    }

    /**
     * <p>TODO #20: Calculate the difference between two time instants in days.
     * Again, you'll find just the method you need in the
     * <a href="http://docs.groovy-lang.org/docs/next/html/groovy-jdk/?java/util/Date.html">Groovy
     * JDK for {@code Date}</a>. You'll have to convert the time instants to
     * dates first, though. <b>Note</b> return a positive number if <tt>time2</tt>
     * is later than <tt>time1</tt>, i.e. the number is bigger.</p>
     */
    int diffDays(long time1, long time2) {
        def d1 = new Date(time1)
        def d2 = new Date(time2)
        return d1 > d2 ? d1 - d2 : d2 - d1
    }

    /**
     * <p>TODO #21: Format a date using the pattern "dd MMM yyyy". You can either
     * use the traditional Java approach of <tt>SimpleDateFormat</tt> or look
     * at the Groovy JDK to find an appropriate method.</p>
     */
    String formattedDate(Date date) {
        return date.format('dd MMM yyyy')
    }
}
