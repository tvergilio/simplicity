package org.example

import grails.transaction.Transactional

/**
 * Dummy mail sender implementation that persists the details of the emails to
 * the database.
 */
@Transactional
class DummyMailSender implements MailSender {
    @Override
    void sendEmail(String to, String from, String subject, String body) {
        new Email(to: to, from: from, subject: subject, body: body).save(flush: true, failOnError: true)
    }
}
