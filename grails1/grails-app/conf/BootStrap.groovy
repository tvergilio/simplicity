class BootStrap {

    def init = { servletContext ->
        println getClass().getResource("initialData.json").getText("UTF-8")
    }
    def destroy = {
    }
}
