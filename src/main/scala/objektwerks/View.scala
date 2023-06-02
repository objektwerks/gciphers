package objektwerks

import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.layout.{HBox, VBox}

object View:
  val width = 800
  val height = 600

  val vbox = new VBox:
    children = List( TitledNumbersPane(), TitledEncodingsPane(), TitledEnterPane() )

  val hbox = new HBox:
    prefWidth = View.width
    prefHeight = View.height
    padding = Insets(6)
    children = List( TitledDatePane(), vbox )

  val scene = new Scene:
    root = hbox
    stylesheets = List("/style.css")