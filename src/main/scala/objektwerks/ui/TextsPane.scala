package objektwerks.ui

import scalafx.geometry.Insets
import scalafx.scene.control.Label
import scalafx.scene.layout.VBox

final class TextsPane(context: Context, model: Model) extends VBox:
  spacing = 6
  padding = Insets(6)

  val title = new Label:
    padding = Insets(6)
    style = "-fx-font-weight: bold"
    text = context.labelTexts