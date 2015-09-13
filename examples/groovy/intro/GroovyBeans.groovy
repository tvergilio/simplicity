class BaseballTeam {
    def cityName
    def teamName
    
    // Read-only property!
    def getDisplayName() {
        cityName + " " + teamName
    }
}

def myTeam = new BaseballTeam()
myTeam.teamName = "Cardinals"
myTeam.cityName = "St. Louis"





/*
println "Team name (method): " + myTeam.getDisplayName()
println "City name: " + myTeam.cityName
*/
/*
myTeam = new BaseballTeam(cityName: "New York", teamName: "Yankees")

// This is not allowed!
myTeam.displayName = "The famous New York Yankees!"

// If scope is added to property...
myTeam.setTeamName("Cardinals")
*/
