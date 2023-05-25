package objektwerks

import scalafx.geometry.Insets
import scalafx.scene.control.{TableColumn, TableView, TitledPane}
import scalafx.scene.layout.{Priority, VBox}

object TitledNumbersPane:
  def apply(): TitledPane =
    new TitledPane:
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

  children = List(tableView)
  VBox.setVgrow(tableView, Priority.Always)