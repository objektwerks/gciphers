package objektwerks.ui

import scalafx.geometry.Insets
import scalafx.scene.control.{Label, TableColumn, TableView}
import scalafx.scene.layout.{Priority, VBox}

import objektwerks.Number

final class NumbersPane(context: Context, model: Model) extends VBox:
  spacing = 6
  padding = Insets(6)

  val title = new Label:
    padding = Insets(6)
    style = "-fx-font-weight: bold"
    text = context.labelNumbers

  val yesOrNo = (bool: Boolean) => if bool then "Yes" else "No"

  val tableView = new TableView[Number]():
    columns ++= List(
      new TableColumn[Number, Int]:
        text = context.columnNumber
        cellValueFactory = _.value.numberProperty
      ,
      new TableColumn[Number, Int]:
        text = context.columnPrimeRank
        cellValueFactory = _.value.primeRankProperty
      ,
      new TableColumn[Number, Int]:
        text = context.columnFibonacciRank
        cellValueFactory = _.value.fibbonaciRankProperty
      ,
      new TableColumn[Number, Boolean]:
        text = context.columnStar
        cellValueFactory = _.value.isStarProperty
        cellFactory = (cell, bool) => cell.text = yesOrNo(bool)
      ,
      new TableColumn[Number, Boolean]:
        text = context.columnTriangular
        cellValueFactory = _.value.isTriangularProperty
        cellFactory = (cell, bool) => cell.text = yesOrNo(bool)
      ,
      new TableColumn[Number, String]:
        text = context.columnFactors
        cellValueFactory = _.value.factorsProperty
    )
    items = model.observableNumbers

  children = List(title, tableView)
  VBox.setVgrow(this, Priority.Always)