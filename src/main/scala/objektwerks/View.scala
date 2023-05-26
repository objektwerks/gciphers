package objektwerks

import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.layout.VBox

object View:
  val width = 800
  val height = 600

  val vbox = new VBox:
    prefWidth = View.width
    prefHeight = View.height
    padding = Insets(6)
    children = List( TitledNumbersPane(), TitledEncodingsPane(), TitledDatePane(), TitledEnterPane() )

  val scene = new Scene:
    root = vbox
    stylesheets = List("/style.css")