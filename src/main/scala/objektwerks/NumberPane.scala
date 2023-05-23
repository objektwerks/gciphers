package objektwerks

import scalafx.geometry.{Insets, Pos}
import scalafx.scene.control.{Label, TitledPane}
import scalafx.scene.layout.{GridPane, HBox, Priority}

import Numbers.{isPrime, isStar, isTriangular, listFactors}

object TitledNumberPane:
  def apply(): TitledPane =
    new TitledPane:
      text = "Number Properties"
      content = NumberPane()

final class NumberPane extends HBox:
  spacing = 6
  padding = Insets(6)

  val label = new Label:
    alignment = Pos.CenterLeft
    text = "Number:"

  val number = new Label:
    alignment = Pos.CenterLeft
    text = "0"

  Model.observableEncoding.onChange { (_, _, newValue) =>
    if newValue <= 0 then number.text = "0"
    else
      val prime = if isPrime(newValue) then s"Yes - #${Model.primeRank(newValue)}" else "No"
      val star = if isStar(newValue) then "Yes" else "No"
      val triangular = if isTriangular(newValue) then "Yes" else "No"
      val factors = listFactors(newValue).mkString(", ")
      number.text = s"$newValue      Prime: $prime      Star: $star      Triangular: $triangular      Factors: $factors"
  }

  val grid = new GridPane:
    hgap = 6
    vgap = 6
    padding = Insets(top = 6, right = 6, bottom = 6, left = 6)
    add(label, columnIndex = 0, rowIndex = 0)
    add(number, columnIndex = 1, rowIndex = 0)

  children = List(grid)
  HBox.setHgrow(grid, Priority.Always)