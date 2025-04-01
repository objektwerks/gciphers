package objektwerks.ui

import scalafx.scene.Scene
import scalafx.scene.layout.VBox

final class View(context: Context, model: Model):
  val rootBox = new VBox:
    prefWidth = context.windowWidth
    prefHeight = context.windowHeight
    children = List( DatePane(model), NumbersPane(model), TitledEncodingsPane(), TitledEnterPane() )

  val scene = new Scene:
    root = rootBox
    stylesheets = List("/style.css")