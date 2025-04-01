package objektwerks.ui

import scalafx.scene.Scene
import scalafx.scene.layout.VBox

final class View(context: Context, model: Model):
  val vbox = new VBox:
    prefWidth = context.windowWidth
    prefHeight = context.windowHeight
    children = List(DatePane(model), NumbersPane(model), EncodingsPane(model), EnterPane(model))

  val scene = new Scene:
    root = vbox
    stylesheets = List("/style.css")