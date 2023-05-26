package objektwerks

import java.time.LocalDate

import scalafx.geometry.{Insets, Pos}
import scalafx.scene.control.{DatePicker, Label, TitledPane}
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
    hgrow = Priority.Always
    value <==> Model.observableDate
    onAction = { _ =>
      dayOfYearField.text = Model.observableDate.value.getDayOfYear().toString
    }

  val dayOfYearLabel = new Label:
    padding = Insets(6)
    alignment = Pos.CenterLeft
    text = "Day of Year:"

  val dayOfYearField = new Label:
    padding = Insets(6)
    alignment = Pos.CenterLeft
    text = LocalDate.now.getDayOfYear.toString

  val hbox = new HBox:
    spacing = 6
    padding = Insets(6)
    children = List(dateLabel, dateField, dayOfYearLabel, dayOfYearField)

  children = List(hbox)
  HBox.setHgrow(hbox, Priority.Always)