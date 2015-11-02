package org.example

class Email {
    String toEmail
    String fromEmail
    String subject
    String body

    static constraints = {
        toEmail blank: false, email: true
        fromEmail blank: false, email: true
        subject blank: false
        body blank: false, maxSize: 2000
    }

    static mapping = {
        table 'emails'
    }
}
