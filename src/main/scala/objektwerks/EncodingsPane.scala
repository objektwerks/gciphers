package objektwerks

import scalafx.Includes.*
import scalafx.geometry.Insets
import scalafx.scene.control.{TableColumn, TableView, TitledPane}
import scalafx.scene.input.MouseEvent
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

  def debug(event: MouseEvent): Unit = println(event)

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
        cellFactory = (cell, _) => cell.setOnMouseClicked( event => debug(event) )
      ,
      new TableColumn[Encodings, Int]:
        text = "Reverse\nOrdinal"
        cellValueFactory = _.value.reverseOrdinalProperty
        cellFactory = (cell, _) => cell.setOnMouseClicked( event => debug(event) )
      ,
      new TableColumn[Encodings, Int]:
        text = "Reduction"
        cellValueFactory = _.value.reductionProperty
        cellFactory = (cell, _) => cell.setOnMouseClicked( event => debug(event) )
      ,
      new TableColumn[Encodings, Int]:
        text = "Reverse\nReduction"
        cellValueFactory = _.value.reverseReductionProperty
        cellFactory = (cell, _) => cell.setOnMouseClicked( event => debug(event) )
      ,
      new TableColumn[Encodings, Int]:
        text = "Latin"
        cellValueFactory = _.value.latinProperty
        cellFactory = (cell, _) => cell.setOnMouseClicked( event => debug(event) )
      ,
      new TableColumn[Encodings, Int]:
        text = "Chaldean"
        cellValueFactory = _.value.chaldeanProperty
        cellFactory = (cell, _) => cell.setOnMouseClicked( event => debug(event) )
      ,
      new TableColumn[Encodings, Int]:
        text = "Septenary"
        cellValueFactory = _.value.septenaryProperty
        cellFactory = (cell, _) => cell.setOnMouseClicked( event => debug(event) )
      ,
      new TableColumn[Encodings, Int]:
        text = "Keypad"
        cellValueFactory = _.value.keypadProperty
        cellFactory = (cell, _) => cell.setOnMouseClicked( event => debug(event) )
      ,
      new TableColumn[Encodings, Int]:
        text = "Standard"
        cellValueFactory = _.value.standardProperty
        cellFactory = (cell, _) => cell.setOnMouseClicked( event => debug(event) )
      ,
      new TableColumn[Encodings, Int]:
        text = "Reverse\nStandard"
        cellValueFactory = _.value.reverseStandardProperty
        cellFactory = (cell, _) => cell.setOnMouseClicked( event => debug(event) )
      ,
      new TableColumn[Encodings, Int]:
        text = "Sumerian"
        cellValueFactory = _.value.sumerianProperty
        cellFactory = (cell, _) => cell.setOnMouseClicked( event => debug(event) )
      ,
      new TableColumn[Encodings, Int]:
        text = "Reverse\nSumerian"
        cellValueFactory = _.value.reverseSumerianProperty
        cellFactory = (cell, _) => cell.setOnMouseClicked( event => debug(event) )
      ,
      new TableColumn[Encodings, Int]:
        text = "Primes"
        cellValueFactory = _.value.primesProperty
        cellFactory = (cell, _) => cell.setOnMouseClicked( event => debug(event) )
      ,
      new TableColumn[Encodings, Int]:
        text = "Reverse\nPrimes"
        cellValueFactory = _.value.reversePrimesProperty
        cellFactory = (cell, _) => cell.setOnMouseClicked( event => debug(event) )
      ,
      new TableColumn[Encodings, Int]:
        text = "Fibonacci"
        cellValueFactory = _.value.fibonacciProperty
        cellFactory = (cell, _) => cell.setOnMouseClicked( event => debug(event) )
      ,
      new TableColumn[Encodings, Int]:
        text = "Squares"
        cellValueFactory = _.value.squaresProperty
        cellFactory = (cell, _) => cell.setOnMouseClicked( event => debug(event) )
      ,
      new TableColumn[Encodings, Int]:
        text = "Reverse\nSquares"
        cellValueFactory = _.value.reverseSquaresProperty
        cellFactory = (cell, _) => cell.setOnMouseClicked( event => debug(event) )
      ,
      new TableColumn[Encodings, Int]:
        text = "Trigonal"
        cellValueFactory = _.value.trigonalProperty
        cellFactory = (cell, _) => cell.setOnMouseClicked( event => debug(event) )
      ,
      new TableColumn[Encodings, Int]:
        text = "Reverse\nTrigonal"
        cellValueFactory = _.value.reverseTrigonalProperty
        cellFactory = (cell, _) => cell.setOnMouseClicked( event => debug(event) )
      ,
      new TableColumn[Encodings, Int]:
        text = "Single\nReduction"
        cellValueFactory = _.value.singleReductionProperty
        cellFactory = (cell, _) => cell.setOnMouseClicked( event => debug(event) )
      ,
      new TableColumn[Encodings, Int]:
        text = "Reverse\nSingle\nReduction"
        cellValueFactory = _.value.reverseSingleReductionProperty
        cellFactory = (cell, _) => cell.setOnMouseClicked( event => debug(event) )
      ,
      new TableColumn[Encodings, Int]:
        text = "Satanic"
        cellValueFactory = _.value.satanicProperty
        cellFactory = (cell, _) => cell.setOnMouseClicked( event => debug(event) )
      ,
      new TableColumn[Encodings, Int]:
        text = "Reverse\nSatanic"
        cellValueFactory = _.value.reverseSatanicProperty
        cellFactory = (cell, _) => cell.setOnMouseClicked( event => debug(event) )
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