package objektwerks

import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.layout.BorderPane

object View:
  val width = 800
  val height = 400

  val borderPane = new BorderPane:
    prefWidth = View.width
    prefHeight = View.height
    padding = Insets(6)

  borderPane.top = NumberPane()
  borderPane.center = EncodingsPane()
  borderPane.bottom = TextNumberPane()

  val scene = new Scene:
    root = borderPane
    stylesheets = List("/style.css")