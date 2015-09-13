package com.simplicityitself.training

/**
 * <p>Working with the filesystem is an important part of much software
 * development and script writing. These exercises give you a chance to
 * familiarise yourself with the main Java classes involved. As with the
 * other exercises, the Practical Groovy book has a section on
 * <a href="http://pledbrook.github.io/practical-groovy-public/#_working_with_the_filesystem">working
 * with files</a>. You should also take a look at the
 * <a href="http://www.groovy-lang.org/groovy-dev-kit.html">Groovy reference
 * guide</a> to see what extensions Groovy adds to the Java IO classes.</p>
 * <p>Fundamentally, the basic <tt>java.io</tt> package consists of:</p>
 * <ul>
 * <li><b>{@code File}</b> - abstract representation of a file location. Can
 * also be used to determine whether a file exists, or whether it's a directory,
 * and so on.</li>
 * <li><b>{@code InputStream}</b> - an interface representing objects that can
 * <b>read</b> data as bytes (so useful for binary formats).</li>
 * <li><b>{@code OutputStream}</b> - an interface representing objects that can
 * <b>write</b> data as bytes (so useful for binary formats).</li>
 * <li><b>{@code Reader}</b> - an interface representing objects that can
 * read data as <b>unicode characters</b>.</li>
 * <li><b>{@code Writer}</b> - an interface representing objects that can
 * write data as <b>unicode characters</b>.</li>
 * </ul>
 * <p><b>Note</b> Don't worry about handling exceptions in these exercises. We'll
 * cover exceptions a little later.</p>
 * <p>If you need a bit more help understanding what the classes do, try
 * <a href="http://tutorials.jenkov.com/java-io/index.html">this Java tutorial</a>
 * that details all the available classes and how to use them.</p>
 * <p><b>For more experienced developers:</b> if you're already familiar with
 * the standard IO API, try completing these exercises using the NIO 2 filesystem
 * API (you will need Java 7 or above). The relevant classes and interfaces can
 * be found in the <tt>java.nio.file</tt> package. The official
 * <a href="https://docs.oracle.com/javase/tutorial/essential/io/fileio.html">Java
 * tutorial</a> will you give you a solid introduction to this powerful API. You'll
 * also find that Groovy adds extension methods to the <tt>Path</tt> interface.</p>
 */
class GroovyFiles {

    /**
     * <p>TODO #22: Calculate the size of the file at the given path.
     * You'll find just the method you need in the
     * <a href="http://docs.groovy-lang.org/docs/next/html/groovy-jdk/?java/io/File.html">Groovy
     * JDK for {@code File}</a>. You don't need to read the file to find out.</p>
     */
    long fileSize(String path) {
        return new File(path).size()
//        return -1
    }

    /**
     * <p>TODO #23: Calculate the number of characters in the text file at the
     * given location. You will need to read the file in order to find out this
     * information. In addition, you should ideally load it using the "UTF-8"
     * character encoding.</p>
     */
    long characterCount(String path) {
        def text = new File(path).getText("UTF-8")
        return text.size()
//        return -1
    }

    /**
     * <p>TODO #24: Return the first <tt>count</tt> characters of a text file as
     * a string. Remember that the text file is encoded as UTF-8.</p>
     */
    String firstChars(String path, int count) {
        def buffer = new char[count]
        def reader
        try {
            reader = new File(path).newReader("UTF-8")
            reader.read(buffer, 0, count)
            return buffer.toString()
        }
        finally {
            reader?.close()
        }
//        return ""
    }

    /**
     * <p>TODO #25: Write some binary (byte) data to a file. The data is
     * provided as the method's second argument.</p>
     */
    void writeBytes(String path, byte[] data) {
        def output
        try {
            output = new File(path).newOutputStream()
            output.write(data)
        }
        finally {
            output?.close()
        }
    }
}
