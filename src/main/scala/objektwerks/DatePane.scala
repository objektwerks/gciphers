package objektwerks

import scalafx.geometry.{Insets, Pos}
import scalafx.scene.control.{DatePicker, Label, TitledPane}
import scalafx.scene.layout.{GridPane, HBox, Priority}

object TitledDatePane:
  def apply(): TitledPane =
    new TitledPane:
      text = "Date"
      content = DatePane()

final class DatePane extends HBox:
  spacing = 6
  padding = Insets(6)

  val dateLabel = new Label:
    alignment = Pos.CenterLeft
    text = "Date:"

  val dateField = new DatePicker:
    hgrow = Priority.Always
    value <== Model.observableDate

  val grid = new GridPane:
    hgap = 6
    vgap = 6
    padding = Insets(top = 6, right = 6, bottom = 6, left = 6)
    add(dateLabel, columnIndex = 0, rowIndex = 0)
    add(dateField, columnIndex = 1, rowIndex = 0)

  children = List(grid)
  HBox.setHgrow(grid, Priority.Always)