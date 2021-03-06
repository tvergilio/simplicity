class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(view: "/index")
        "404"(view: "/notFoundError")
        "500"(view: '/error')
        "/healthStatus"(controller: 'health', action: 'status')
        "/login" (controller: "auth") {
            action = [GET:"showLogin",POST:"login"]
        }
    }
}
