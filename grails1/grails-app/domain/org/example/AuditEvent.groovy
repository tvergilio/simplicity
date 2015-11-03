package org.example

class AuditEvent {
    String origin
    String event
    Integer recordId
    static final String CREATED = 'CREATED'
    static final String UPDATED = 'UPDATED'
    static final String DELETED = 'DELETED'

    static constraints = {
        origin nullable: false, blank: false
        event nullable: false, blank: false
    }
}
