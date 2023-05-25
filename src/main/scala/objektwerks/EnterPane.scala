package objektwerks

import scalafx.Includes.*
import scalafx.geometry.{Insets, Pos}
import scalafx.scene.control.{Button, Label, TextField, TitledPane}
import scalafx.scene.input.{KeyCode, KeyEvent}
import scalafx.scene.layout.{GridPane, HBox, Priority}

object TitledEnterPane:
  def apply(): TitledPane =
    new TitledPane:
      text = "Enter"
      content = EnterPane()

final class EnterPane extends HBox:
  spacing = 6
  padding = Insets(6)

  val textLabel = new Label:
    alignment = Pos.CenterLeft
    text = "Text:"

  val textField = new TextField:
    hgrow = Priority.Always
    onKeyReleased = (event: KeyEvent) => if event.code == KeyCode.Enter then Model.encode(text.value)

  val numberLabel = new Label:
    alignment = Pos.CenterLeft
    text = "Number:"

  val numberField = new TextField:
    hgrow = Priority.Always
    onKeyReleased = (event: KeyEvent) =>
      if event.code == KeyCode.Enter
      then Model.observableNumbers.value = text.value.toIntOption.getOrElse(0)

  val clearButton = new Button:
    text = "Clear"
    onAction = { _ =>
      textField.text = ""
      numberField.text = ""
      Model.clear()
    }

  val grid = new GridPane:
    hgap = 6
    vgap = 6
    padding = Insets(top = 6, right = 6, bottom = 6, left = 6)
    add(textLabel, columnIndex = 0, rowIndex = 0)
    add(textField, columnIndex = 1, rowIndex = 0)
    add(numberLabel, columnIndex = 2, rowIndex = 0)
    add(numberField, columnIndex = 3, rowIndex = 0)
    add(clearButton, columnIndex = 4, rowIndex = 0)

  children = List(grid)
  HBox.setHgrow(grid, Priority.Always)