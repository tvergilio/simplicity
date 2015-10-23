package org.example

/**
 * Represents objects that can send emails.
 */
interface MailSender {
    void sendEmail(String to, String from, String subject, String body)
}
