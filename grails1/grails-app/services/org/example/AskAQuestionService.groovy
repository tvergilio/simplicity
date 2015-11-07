package org.example

import grails.transaction.Transactional

@Transactional
class AskAQuestionService {
	String DEFAULT_SEND_TO = 'tvergilio@gmail.com'
    def mailService

    def askAQuestion(String sendTo, String sentFrom, String emailSubject, String emailBody) {
        mailService.sendMail {
            to sendTo
            from sentFrom
            subject emailSubject
            body emailBody
        }
    }
}
