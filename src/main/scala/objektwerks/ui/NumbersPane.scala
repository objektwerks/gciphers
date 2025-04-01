package objektwerks.ui

import scalafx.geometry.Insets
import scalafx.scene.control.{TableColumn, TableView, TitledPane}
import scalafx.scene.layout.{Priority, VBox}

import objektwerks.Number

object TitledNumbersPane:
  def apply(): TitledPane =
    new TitledPane:
      collapsible = false
      text = "Numbers"
      content = NumbersPane()

final class NumbersPane extends VBox:
  spacing = 6
  padding = Insets(6)

  val yesOrNo = (bool: Boolean) => if bool then "Yes" else "No"

  val tableView = new TableView[Number]():
    columns ++= List(
      new TableColumn[Number, Int]:
        text = "Number"
        cellValueFactory = _.value.numberProperty
      ,
      new TableColumn[Number, Int]:
        text = "Prime\nRank"
        cellValueFactory = _.value.primeRankProperty
      ,
      new TableColumn[Number, Int]:
        text = "Fibonacci\nRank"
        cellValueFactory = _.value.fibbonaciRankProperty
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

  children = List(tableView)
  VBox.setVgrow(tableView, Priority.Always)