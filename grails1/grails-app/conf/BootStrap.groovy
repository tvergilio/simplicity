import org.example.Email

class BootStrap {

    def init = { servletContext ->
        println getClass().getResource("initialData.json").getText("UTF-8")
        new Email(to: "peter@ledbrook.net", from: "ian@nowhere.net", subject: "Hi", body: "My body").save(flush: true)
    }
    def destroy = {
    }
}
