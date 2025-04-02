package objektwerks.ui

import scalafx.Includes.*
import scalafx.geometry.Insets
import scalafx.scene.control.{Label, TableColumn, TableView}
import scalafx.scene.layout.{Priority, VBox}
import scala.util.Try

import objektwerks.Encodings

final class EncodingsPane(context: Context, model: Model) extends VBox:
  spacing = 6
  padding = Insets(6)

  val title = new Label:
    padding = Insets(6)
    style = "-fx-font-weight: bold"
    text = context.labelEncodings

  val tableView = new TableView[Encodings]():
    columns ++= List(
      new TableColumn[Encodings, String]:
        text = context.columnText
        prefWidth = 200
        cellValueFactory = _.value.textProperty
      ,
      new TableColumn[Encodings, Int]:
        text = context.columnOrdinal
        cellValueFactory = _.value.ordinalProperty
      ,
      new TableColumn[Encodings, Int]:
        text = context.columnReverseOrdinal
        cellValueFactory = _.value.reverseOrdinalProperty
      ,
      new TableColumn[Encodings, Int]:
        text = context.columnReduction
        cellValueFactory = _.value.reductionProperty
      ,
      new TableColumn[Encodings, Int]:
        text = context.columnReverseReduction
        cellValueFactory = _.value.reverseReductionProperty
      ,
      new TableColumn[Encodings, Int]:
        text = context.columnLatin
        cellValueFactory = _.value.latinProperty
      ,
      new TableColumn[Encodings, Int]:
        text = context.columnChaldean
        cellValueFactory = _.value.chaldeanProperty
      ,
      new TableColumn[Encodings, Int]:
        text = context.columnSeptenary
        cellValueFactory = _.value.septenaryProperty
      ,
      new TableColumn[Encodings, Int]:
        text = context.columnKeypad
        cellValueFactory = _.value.keypadProperty
      ,
      new TableColumn[Encodings, Int]:
        text = context.columnStandard
        cellValueFactory = _.value.standardProperty
      ,
      new TableColumn[Encodings, Int]:
        text = context.columnReverseStandard
        cellValueFactory = _.value.reverseStandardProperty
      ,
      new TableColumn[Encodings, Int]:
        text = context.columnSumerian
        cellValueFactory = _.value.sumerianProperty
      ,
      new TableColumn[Encodings, Int]:
        text = context.columnReverseSumerian
        cellValueFactory = _.value.reverseSumerianProperty
      ,
      new TableColumn[Encodings, Int]:
        text = context.columnPrimes
        cellValueFactory = _.value.primesProperty
      ,
      new TableColumn[Encodings, Int]:
        text = context.columnReversePrimes
        cellValueFactory = _.value.reversePrimesProperty
      ,
      new TableColumn[Encodings, Int]:
        text = context.columnFibonacci
        cellValueFactory = _.value.fibonacciProperty
      ,
      new TableColumn[Encodings, Int]:
        text = context.columnSquares
        cellValueFactory = _.value.squaresProperty
      ,
      new TableColumn[Encodings, Int]:
        text = context.columnReverseSquares
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
    items = model.observableEncodings

  val tableViewSelectionModel = tableView.selectionModel.apply()
  tableViewSelectionModel.setCellSelectionEnabled(true)
  val selectedCells = tableViewSelectionModel.getSelectedCells()
  selectedCells.onChange {
    if selectedCells.nonEmpty then 
      val tablePosition = selectedCells.get(0)
      val cellRow = tablePosition.getRow()
      Try{
        model.addNumber( tablePosition.getTableColumn().getCellData(cellRow).asInstanceOf[Int] )
      }
  }

  children = List(title, tableView)
  VBox.setVgrow(this, Priority.Always)