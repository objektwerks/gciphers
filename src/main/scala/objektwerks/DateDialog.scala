package objektwerks

import java.time.LocalDate

import scalafx.geometry.{Insets, Pos}
import scalafx.Includes.*
import scalafx.scene.control.{ButtonType, Dialog, Label}
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

  val grid = new GridPane:
    hgap = 6
    vgap = 6
    padding = Insets(top = 6, right = 6, bottom = 6, left = 6)
    add(splitYearLabel, columnIndex = 0, rowIndex = 0)
    add(splitYearText, columnIndex = 1, rowIndex = 0)
    add(splitEachYearLabel, columnIndex = 0, rowIndex = 1)
    add(splitEachYearText, columnIndex = 1, rowIndex = 1)
    add(splitEachMonthDayYearLabel, columnIndex = 0, rowIndex = 2)
    add(splitEachMonthDayYearText, columnIndex = 1, rowIndex = 2)

  dialogPane().buttonTypes = List(ButtonType.Close)
  dialogPane().content = new VBox:
    prefWidth = 300
    prefHeight = 100
    spacing = 6
    children = List(grid)