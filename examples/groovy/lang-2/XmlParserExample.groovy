def xml = """
<languages>
  <language name="Groovy">
    <feature coolness="low">SQL</feature>
    <feature coolness="high">Template</feature>
  </language>
  <language name="Perl"/>
  <language name="Java">
    <feature coolness="low">Run everywhere</feature>
  </language>
</languages>"""

def root = new XmlParser().parseText(xml)

println root.language.feature[1].text()
println root.language*.@name

root.language.feature.findAll { it['@coolness'] == "low" }.each {
    println it.text()
}
