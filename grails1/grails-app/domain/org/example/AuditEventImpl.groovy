package org.example

import uk.ac.leedsbeckett.AuditEvent

class AuditEventImpl implements AuditEvent {
    String origin
    String event
    Long recordId

    static constraints = {
        origin nullable: false, blank: false
        event nullable: false, blank: false
    }
}
