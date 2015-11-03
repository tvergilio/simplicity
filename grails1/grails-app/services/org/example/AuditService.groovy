package org.example

import grails.transaction.Transactional

@Transactional
class AuditService {

    AuditEvent recordEvent(String origin, String event, Integer recordId) {
        new AuditEvent([origin: origin, event: event, recordId: recordId]).save(flush: true)
    }
}
