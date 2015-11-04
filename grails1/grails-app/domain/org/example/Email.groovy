package org.example

class Email {
    String to
    String from
    String subject
    String body

    static constraints = {
        to blank: false, email: true
        from blank: false, email: true
        subject blank: false
        body blank: false, maxSize: 2000
    }

    static mapping = {
        table 'emails'
        from column: "`from_email`"
        to column: "`to_email`"
    }
}
