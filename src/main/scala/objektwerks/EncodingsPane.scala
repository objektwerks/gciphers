package objektwerks

import scalafx.Includes.*
import scalafx.geometry.Insets
import scalafx.scene.control.{TableColumn, TableView, TitledPane}
import scalafx.scene.layout.{Priority, VBox}

object TitledEncodingsPane:
  def apply(): TitledPane =
    new TitledPane:
      collapsible = false
      text = "Encodings"
      content = EncodingsPane()

final class EncodingsPane extends VBox:
  spacing = 6
  padding = Insets(6)

  val tableView = new TableView[Encodings]():
    columns ++= List(
      new TableColumn[Encodings, String]:
        text = "Text"
        prefWidth = 200
        cellValueFactory = _.value.textProperty
      ,
      new TableColumn[Encodings, Int]:
        text = "Ordinal"
        cellValueFactory = _.value.ordinalProperty
        cellFactory = (cell, _) => cell.setOnMouseClicked( event => println(event) )
      ,
      new TableColumn[Encodings, Int]:
        text = "Reverse\nOrdinal"
        cellValueFactory = _.value.reverseOrdinalProperty
      ,
      new TableColumn[Encodings, Int]:
        text = "Reduction"
        cellValueFactory = _.value.reductionProperty
      ,
      new TableColumn[Encodings, Int]:
        text = "Reverse\nReduction"
        cellValueFactory = _.value.reverseReductionProperty
      ,
      new TableColumn[Encodings, Int]:
        text = "Latin"
        cellValueFactory = _.value.latinProperty
      ,
      new TableColumn[Encodings, Int]:
        text = "Chaldean"
        cellValueFactory = _.value.chaldeanProperty
      ,
      new TableColumn[Encodings, Int]:
        text = "Septenary"
        cellValueFactory = _.value.septenaryProperty
      ,
      new TableColumn[Encodings, Int]:
        text = "Keypad"
        cellValueFactory = _.value.keypadProperty
      ,
      new TableColumn[Encodings, Int]:
        text = "Standard"
        cellValueFactory = _.value.standardProperty
      ,
      new TableColumn[Encodings, Int]:
        text = "Reverse\nStandard"
        cellValueFactory = _.value.reverseStandardProperty
      ,
      new TableColumn[Encodings, Int]:
        text = "Sumerian"
        cellValueFactory = _.value.sumerianProperty
      ,
      new TableColumn[Encodings, Int]:
        text = "Reverse\nSumerian"
        cellValueFactory = _.value.reverseSumerianProperty
      ,
      new TableColumn[Encodings, Int]:
        text = "Primes"
        cellValueFactory = _.value.primesProperty
      ,
      new TableColumn[Encodings, Int]:
        text = "Reverse\nPrimes"
        cellValueFactory = _.value.reversePrimesProperty
      ,
      new TableColumn[Encodings, Int]:
        text = "Fibonacci"
        cellValueFactory = _.value.fibonacciProperty
      ,
      new TableColumn[Encodings, Int]:
        text = "Squares"
        cellValueFactory = _.value.squaresProperty
      ,
      new TableColumn[Encodings, Int]:
        text = "Reverse\nSquares"
        cellValueFactory = _.value.reverseSquaresProperty
      ,
      new TableColumn[Encodings, Int]:
        text = "Trigonal"
        cellValueFactory = _.value.trigonalProperty
      ,
      new TableColumn[Encodings, Int]:
        text = "Reverse\nTrigonal"
        cellValueFactory = _.value.reverseTrigonalProperty
      ,
      new TableColumn[Encodings, Int]:
        text = "Single\nReduction"
        cellValueFactory = _.value.singleReductionProperty
      ,
      new TableColumn[Encodings, Int]:
        text = "Reverse\nSingle\nReduction"
        cellValueFactory = _.value.reverseSingleReductionProperty
      ,
      new TableColumn[Encodings, Int]:
        text = "Satanic"
        cellValueFactory = _.value.satanicProperty
      ,
      new TableColumn[Encodings, Int]:
        text = "Reverse\nSatanic"
        cellValueFactory = _.value.reverseSatanicProperty
    )
    items = Model.observableEncodings

  val tableViewSelectionModel = tableView.selectionModel.apply()
  tableViewSelectionModel.setCellSelectionEnabled(true)
  val selectedCells = tableViewSelectionModel.getSelectedCells()
  selectedCells.onChange {
    if selectedCells.nonEmpty then 
      val tablePosition = selectedCells.get(0)
      val cellRow = tablePosition.getRow()
      Model.addNumber( tablePosition.getTableColumn().getCellData(cellRow).asInstanceOf[Int] )
  }

  children = List(tableView)
  VBox.setVgrow(tableView, Priority.Always)