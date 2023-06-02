package objektwerks

import java.time.LocalDate

import scalafx.beans.property.ObjectProperty
import scalafx.geometry.{Insets, Orientation, Pos}
import scalafx.Includes.*
import scalafx.scene.control.{DatePicker, Label, Separator, TitledPane}
import scalafx.scene.layout.{GridPane, Priority, VBox}

object TitledDatePane:
  def apply(): TitledPane =
    new TitledPane:
      text = "Date"
      content = DatePane()

final class DatePane extends VBox:
  spacing = 6
  padding = Insets(6)
  prefWidth = 275

  // Date section begin.

  val dateLabel = new Label:
    alignment = Pos.CenterLeft
    text = "Date:"

  val dateField = new DatePicker:
    alignment = Pos.Center
    prefWidth = 110
    value <==> Model.observableDate
    onAction = { _ =>
      dayOfYearField.text = Date.dayOfYear(Model.observableDate.value)
      remainingDaysInYearField.text = Date.remainingDaysInYear(Model.observableDate.value)
    }

  val dayOfYearLabel = new Label:
    alignment = Pos.CenterLeft
    text = "Day of Year:"

  val dayOfYearField = new Label:
    alignment = Pos.Center
    text = Date.dayOfYear(Model.observableDate.value)

  val remainingDaysInYearLabel = new Label:
    alignment = Pos.CenterLeft
    text = "Remaining Days in Year:"

  val remainingDaysInYearField = new Label:
    alignment = Pos.Center
    text = Date.remainingDaysInYear(Model.observableDate.value)

  val dateGrid = new GridPane:
    hgap = 6
    vgap = 6
    add(dateLabel, columnIndex = 0, rowIndex = 0)
    add(dateField, columnIndex = 1, rowIndex = 0)
    add(dayOfYearLabel, columnIndex = 0, rowIndex = 1)
    add(dayOfYearField, columnIndex = 1, rowIndex = 1)
    add(remainingDaysInYearLabel, columnIndex = 0, rowIndex = 2)
    add(remainingDaysInYearField, columnIndex = 1, rowIndex = 2)

  // Date section end.

  // Encodings section begin.

  val encodingsSeparator = new Separator:
    orientation = Orientation.Horizontal

  val (splitYearExpression, splitYearEncoding) = Date.splitYear(Model.observableDate.value)
  val splitYearLabel = new Label:
    alignment = Pos.CenterLeft
    text = s"$splitYearExpression:"

  val splitYearText = new Label:
    alignment = Pos.Center
    text = splitYearEncoding.toString

  val (splitEachYearExpression, splitEachYearEncoding) = Date.splitEachYear(Model.observableDate.value)
  val splitEachYearLabel = new Label:
    alignment = Pos.CenterLeft
    text = s"$splitEachYearExpression:"

  val splitEachYearText = new Label:
    alignment = Pos.Center
    text = splitEachYearEncoding.toString

  val (splitEachMonthDayYearExpression, splitEachMonthDayYearEncoding) = Date.splitEachMonthDayYear(Model.observableDate.value)
  val splitEachMonthDayYearLabel = new Label:
    alignment = Pos.CenterLeft
    text = s"$splitEachMonthDayYearExpression:"

  val splitEachMonthDayYearText = new Label:
    alignment = Pos.Center
    text = splitEachMonthDayYearEncoding.toString

  val encodingsGrid = new GridPane:
    hgap = 6
    vgap = 6
    add(splitYearLabel, columnIndex = 0, rowIndex = 0)
    add(splitYearText, columnIndex = 1, rowIndex = 0)
    add(splitEachYearLabel, columnIndex = 0, rowIndex = 1)
    add(splitEachYearText, columnIndex = 1, rowIndex = 1)
    add(splitEachMonthDayYearLabel, columnIndex = 0, rowIndex = 2)
    add(splitEachMonthDayYearText, columnIndex = 1, rowIndex = 2)

  // Encodings section end.

  // Date Diff section begin.

  val dateDiffSeparator = new Separator:
    orientation = Orientation.HORIZONTAL

  val fromDate = ObjectProperty[LocalDate](this, "fromdate", Model.observableDate.value)
  val toDate = ObjectProperty[LocalDate](this, "todate", Model.observableDate.value)

  fromDate.onChange { (_, _, _) =>
    dateDiffText.text = Date.dateDiff( fromDate.value, toDate.value ).toString
  }

  toDate.onChange { (_, _, _) =>
    dateDiffText.text = Date.dateDiff( fromDate.value, toDate.value ).toString
  }

  val dateDiffLabel = new Label:
    alignment = Pos.CenterLeft
    text = "Diff:"

  val dateDiffText = new Label:
    alignment = Pos.Center
    text = "0"

  val fromDateLabel = new Label:
    alignment = Pos.CenterLeft
    text = "From Date:"

  val fromDateField = new DatePicker:
    alignment = Pos.Center
    prefWidth = 110
    value = Model.observableDate.value
    onAction = { _ =>
      fromDate.value = value.value
    }

  val toDateLabel = new Label:
    alignment = Pos.CenterLeft
    text = "To Date:"

  val toDateField = new DatePicker:
    alignment = Pos.Center
    prefWidth = 110
    value = Model.observableDate.value
    onAction = { _ =>
      toDate.value = value.value
    }

  val dateDiffGrid = new GridPane:
    hgap = 6
    vgap = 6
    add(dateDiffLabel, columnIndex = 0, rowIndex = 0)
    add(dateDiffText, columnIndex = 1, rowIndex = 0)
    add(fromDateLabel, columnIndex = 0, rowIndex = 1)
    add(fromDateField, columnIndex = 1, rowIndex = 1)
    add(toDateLabel, columnIndex = 0, rowIndex = 2)
    add(toDateField, columnIndex = 1, rowIndex = 2)

  // Date Diff section end.

  children = List(dateGrid, encodingsSeparator, encodingsGrid, dateDiffSeparator, dateDiffGrid)
  VBox.setVgrow(this, Priority.Always)