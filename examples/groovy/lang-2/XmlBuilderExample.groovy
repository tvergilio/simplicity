def xml = new groovy.xml.MarkupBuilder()
xml.sports {
    baseball {
        cardinals(town: 'St. Louis')
        cubs(town: 'Chicago')
    }
    football {
        rams(town: 'St. Louis')
        bears(town: 'Chicago')
    }
}

def writer = new StringWriter()
xml = new groovy.xml.MarkupBuilder(writer)
xml.sports {
    baseball {
        cardinals(town: 'St. Louis')
        cubs(town: 'Chicago')
    }
    football {
        rams(town: 'St. Louis')
        bears(town: 'Chicago')
    }
}

println()
println "--------"
println writer.toString()