package objektwerks

import scalafx.geometry.{Insets, Pos}
import scalafx.scene.control.{Label, TableColumn, TableView, TitledPane}
import scalafx.scene.layout.{GridPane, HBox, Priority}

object TitledNumbersPane:
  def apply(): TitledPane =
    new TitledPane:
      text = "Numbers"
      content = NumbersPane()

final class NumbersPane extends HBox:
  spacing = 6
  padding = Insets(6)

  val yesOrNo = (bool: Boolean) => if bool then "Yes" else "No"

  val tableView = new TableView[Number]():
    columns ++= List(
      new TableColumn[Number, Int]:
        text = "Number"
        cellValueFactory = _.value.numberProperty
      ,
      new TableColumn[Number, Boolean]:
        text = "Prime"
        cellValueFactory = _.value.isPrimeProperty
        cellFactory = (cell, bool) => cell.text = yesOrNo(bool)
      ,
      new TableColumn[Number, Int]:
        text = "Rank"
        cellValueFactory = _.value.rankProperty
      ,
      new TableColumn[Number, Boolean]:
        text = "Star"
        cellValueFactory = _.value.isStarProperty
        cellFactory = (cell, bool) => cell.text = yesOrNo(bool)
      ,
      new TableColumn[Number, Boolean]:
        text = "Triangular"
        cellValueFactory = _.value.isTriangularProperty
        cellFactory = (cell, bool) => cell.text = yesOrNo(bool)
      ,
      new TableColumn[Number, String]:
        text = "Factors"
        cellValueFactory = _.value.factorsProperty
    )
    items = Model.observableNumbers

  val label = new Label:
    alignment = Pos.CenterLeft
    text = "Number:"

  val number = new Label:
    alignment = Pos.CenterLeft
    text = "0"

  val grid = new GridPane:
    hgap = 6
    vgap = 6
    padding = Insets(top = 6, right = 6, bottom = 6, left = 6)
    add(label, columnIndex = 0, rowIndex = 0)
    add(number, columnIndex = 1, rowIndex = 0)

  children = List(grid)
  HBox.setHgrow(grid, Priority.Always)