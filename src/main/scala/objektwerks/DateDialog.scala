package objektwerks

import java.time.LocalDate

import scalafx.geometry.{Insets, Orientation, Pos}
import scalafx.Includes.*
import scalafx.scene.control.{ButtonType, DatePicker, Dialog, Label, Separator}
import scalafx.scene.layout.{GridPane, VBox}

final class DateDialog(date: LocalDate) extends Dialog[Unit]:
  initOwner(App.stage)
  title = "Date"
  headerText = "Encodings"

  val (splitYearExpression, splitYearEncoding) = Date.splitYear(date)
  val splitYearLabel = new Label:
    padding = Insets(6)
    alignment = Pos.CenterLeft
    text = splitYearExpression

  val splitYearText = new Label:
    padding = Insets(6)
    alignment = Pos.CENTER
    text = splitYearEncoding.toString

  val (splitEachYearExpression, splitEachYearEncoding) = Date.splitEachYear(date)
  val splitEachYearLabel = new Label:
    padding = Insets(6)
    alignment = Pos.CenterLeft
    text = splitEachYearExpression

  val splitEachYearText = new Label:
    padding = Insets(6)
    alignment = Pos.CENTER
    text = splitEachYearEncoding.toString

  val (splitEachMonthDayYearExpression, splitEachMonthDayYearEncoding) = Date.splitEachMonthDayYear(date)
  val splitEachMonthDayYearLabel = new Label:
    padding = Insets(6)
    alignment = Pos.CenterLeft
    text = splitEachMonthDayYearExpression

  val splitEachMonthDayYearText = new Label:
    padding = Insets(6)
    alignment = Pos.CENTER
    text = splitEachMonthDayYearEncoding.toString

  val encodingsGrid = new GridPane:
    hgap = 6
    vgap = 6
    padding = Insets(top = 6, right = 6, bottom = 6, left = 6)
    add(splitYearLabel, columnIndex = 0, rowIndex = 0)
    add(splitYearText, columnIndex = 1, rowIndex = 0)
    add(splitEachYearLabel, columnIndex = 0, rowIndex = 1)
    add(splitEachYearText, columnIndex = 1, rowIndex = 1)
    add(splitEachMonthDayYearLabel, columnIndex = 0, rowIndex = 2)
    add(splitEachMonthDayYearText, columnIndex = 1, rowIndex = 2)

  val separator = new Separator:
    orientation = Orientation.HORIZONTAL

  val dateDiffLabel = new Label:
    alignment = Pos.CenterLeft
    text = "Diff:"

  val dateDiffText = new Label:
    alignment = Pos.Center
    text = "0"

  val fromDateLabel = new Label:
    alignment = Pos.CenterLeft
    text = "Date:"

  val fromDateField = new DatePicker:
    prefWidth = 110
    value <==> Model.observableDate
    onAction = { _ =>
    }

  val toDateLabel = new Label:
    alignment = Pos.CenterLeft
    text = "Date:"

  val toDateField = new DatePicker:
    prefWidth = 110
    value <==> Model.observableDate
    onAction = { _ =>
    }

  val dateDiffGrid = new GridPane:
    hgap = 6
    vgap = 6
    padding = Insets(top = 6, right = 6, bottom = 6, left = 6)
    add(dateDiffLabel, columnIndex = 0, rowIndex = 0)
    add(dateDiffText, columnIndex = 1, rowIndex = 0)
    add(fromDateLabel, columnIndex = 0, rowIndex = 1)
    add(fromDateField, columnIndex = 1, rowIndex = 1)
    add(toDateLabel, columnIndex = 0, rowIndex = 2)
    add(toDateField, columnIndex = 1, rowIndex = 2)

  dialogPane().buttonTypes = List(ButtonType.Close)
  dialogPane().content = new VBox:
    prefWidth = 275
    prefHeight = 100
    spacing = 6
    children = List(encodingsGrid, separator, dateDiffGrid)