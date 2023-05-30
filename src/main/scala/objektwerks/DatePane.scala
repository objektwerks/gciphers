package objektwerks

import scalafx.geometry.{Insets, Pos}
import scalafx.scene.control.{Button, DatePicker, Label, TitledPane}
import scalafx.scene.layout.{HBox, Priority}

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
    prefWidth = 110
    value <==> Model.observableDate
    onAction = { _ =>
      dayOfYearField.text = Date.dayOfYear(Model.observableDate.value)
      remainingDaysInYearField.text = Date.remainingDaysInYear(Model.observableDate.value)
    }

  val dayOfYearLabel = new Label:
    padding = Insets(6)
    alignment = Pos.CenterLeft
    text = "Day of Year:"

  val dayOfYearField = new Label:
    padding = Insets(6)
    alignment = Pos.CenterLeft
    text = Date.dayOfYear(Model.observableDate.value)

  val remainingDaysInYearLabel = new Label:
    padding = Insets(6)
    alignment = Pos.CenterLeft
    text = "Remaining Days in Year:"

  val remainingDaysInYearField = new Label:
    padding = Insets(6)
    alignment = Pos.CenterLeft
    text = Date.remainingDaysInYear(Model.observableDate.value)

  val encodingsButton = new Button:
    padding = Insets(6)
    prefWidth = 75
    text = "Encodings..."
    onAction = { _ => DateDialog(Model.observableDate.value).showAndWait() }

  val hbox = new HBox:
    spacing = 6
    padding = Insets(6)
    children = List(dateLabel, dateField, dayOfYearLabel, dayOfYearField, remainingDaysInYearLabel, remainingDaysInYearField, encodingsButton)

  children = List(hbox)
  HBox.setHgrow(hbox, Priority.Always)