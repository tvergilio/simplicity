package com.simplicityitself.training

import org.apache.commons.codec.digest.DigestUtils

/**
 * <p>You will inevitably need to use third-party libraries at some point, i.e.
 * classes and APIs that don't come as part of the JDK or Groovy. In these
 * exercises, you'll get some practice with a library called
 * <a href="https://commons.apache.org/proper/commons-codec/">Apache Commons
 * Codec</a>, which makes it easy to generate hashes (or digests) like MD5 and
 * SHA512. These generate a short, (almost) unique code for any data. However,
 * you can't recreate the data from the codes.</p>
 * <p>This third party library has been added to the project automatically
 * through the build file. You should see it amongst the project/module libraries
 * in your IDE. To use the classes in the library, you'll have to import them,
 * something that the IDE can help you with. For more details on packages and
 * importing, see the
 * <a href="http://www.groovy-lang.org/structure.html">Groovy documentation</a>.
 * The IDE makes sure that the JAR (Java ARchive) file for the library (it's
 * basically a zip file containing the compiled classes) is included on the
 * project's classpath. Wikipedia has a reasonable entry on
 * <a href="https://en.wikipedia.org/wiki/Classpath_(Java)">Java's classpath</a>.
 * </p>
 * <p><b>Note</b> Although you can manually add JARs to a project in your IDE,
 * it's usually much simpler to let your build tool handle this, whether that
 * be Maven, Gradle or Grails.</p>
 */
class GroovyCommonsCodec {

    /**
     * <p>TODO #33: Calculate the MD5 hash/digest of a string. Use the
     * <a href="https://commons.apache.org/proper/commons-codec/apidocs/?org/apache/commons/codec/digest/DigestUtils.html">DigestUtils</a>
     * class, which is provided by the commons-codec JAR. You'll specifically
     * want to use the <tt>md5Hex()</tt> method, as that's the one that generates
     * a string, as opposed to a byte array.</p>
     */
    String toMD5(String data) {
        return DigestUtils.md5Hex(data)
    }

    /**
     * <p>TODO #34: Calculate the MD5 hash/digest of a byte array. This is very
     * similar to the previous exercise.</p>
     */
    String toMD5(byte[] data) {
        return DigestUtils.md5Hex(data)
    }
}
