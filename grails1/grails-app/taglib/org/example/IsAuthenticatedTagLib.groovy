package org.example

class IsAuthenticatedTagLib {
    static namespace = "app"
    static defaultEncodeAs = "raw" //I don't want to escape HTML
    def isAuthenticated = { attrs, body ->
        if (session.user) {
            out << body()
        }
    }
    def isNotAuthenticated = { attrs, body ->
        if (!session.user) {
            out << body()
        }
    }
}
