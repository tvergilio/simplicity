package org.example

class HealthController {

    def status() {
        render(text: "ok", contentType: "text/plain", encoding: "UTF-8")
    }
}
