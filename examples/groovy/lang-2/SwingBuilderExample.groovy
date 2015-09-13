import groovy.swing.SwingBuilder
import javax.swing.*

def theMap = [color: "green", object: "pencil"]
def swing = new SwingBuilder()
def frame = swing.frame(
           title: 'A Groovy Swing', location: [240,240],
           defaultCloseOperation:JFrame.EXIT_ON_CLOSE) {
  panel {
    for (entry in theMap) {
       label(text: entry.key)
       textField(text: entry.value)
    }
    button(text: 'About', actionPerformed: {
       def pane = swing.optionPane(message: 'SwingBuilder')
       def dialog = pane.createDialog(null, 'About')
       dialog.show()
    })
    button(text:'Quit', actionPerformed:{ System.exit(0) })
  }
}
frame.pack()
frame.show()
