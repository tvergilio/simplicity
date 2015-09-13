def recipient = 'Jill'
def author = 'Jack'

// Single quotes
def message = '''
Dear ${recipient},

Would you like to go up the hill
and fetch a pail of water?

${author}
'''

println "--------"
println message








// Double quotes
/*
message = """
Dear ${recipient},

Would you like to go up the hill
and fetch a pail of water?

${author}
"""

println "--------"
println message


// .stripIndent()

// Check what the EOL character is
def str = """
"""
println str.bytes
*/
