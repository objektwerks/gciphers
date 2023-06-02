package objektwerks

import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.layout.{HBox, VBox}

object View:
  val width = 800
  val height = 600

  val rightVBox = new VBox:
    prefWidth = 525
    children = List( TitledNumbersPane(), TitledEncodingsPane(), TitledEnterPane() )

  val leftHBox = new HBox:
    prefWidth = View.width
    prefHeight = View.height
    padding = Insets(6)
    children = List( TitledDatePane(), rightVBox )

  val scene = new Scene:
    root = leftHBox
    stylesheets = List("/style.css")