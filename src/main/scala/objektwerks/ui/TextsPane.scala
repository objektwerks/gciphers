package objektwerks.ui

import scalafx.geometry.Insets
import scalafx.scene.control.{Label, TableColumn, TableView}
import scalafx.scene.layout.{Priority, VBox}

import objektwerks.Texts

final class TextsPane(context: Context, model: Model) extends VBox:
  spacing = 6
  padding = Insets(6)

  val title = new Label:
    padding = Insets(6)
    style = "-fx-font-weight: bold"
    text = context.labelTexts

  val tableView = new TableView[Texts]():
    columns ++= List(
      new TableColumn[Texts, Int]:
        text = context.columnNumber
        cellValueFactory = _.value.numberProperty
      ,
      new TableColumn[Texts, String]:
        text = context.columnTexts
        cellValueFactory = _.value.valuesToString() // on cell change, this method is called!
    )
    items = model.observableTexts

  children = List(title, tableView)
  VBox.setVgrow(this, Priority.Always)