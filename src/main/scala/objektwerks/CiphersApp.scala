package objektwerks

import scalafx.application.JFXApp3
import scalafx.collections.ObservableBuffer
import scalafx.geometry.{Insets, Pos}
import scalafx.scene.Scene
import scalafx.scene.control.Label
import scalafx.scene.image.Image
import scalafx.scene.layout.{BorderPane, GridPane, HBox, Priority}

import Numbers.*

object CiphersApp extends JFXApp3:
  override def start(): Unit =
    stage = new JFXApp3.PrimaryStage:
      scene = View.scene
      title = "Ciphers"
      minWidth = View.width
      minHeight = View.height
      icons.add( new Image( Image.getClass.getResourceAsStream("/cipher.png") ) )
    stage.show()

object View:
  val width = 800
  val height = 400

  val borderPane = new BorderPane:
    prefWidth = View.width
    prefHeight = View.height
    padding = Insets(6)

  borderPane.top = NumberPane()
  borderPane.center = EncodingsPane()
  borderPane.bottom = TextNumberPane()

  val scene = new Scene:
    root = borderPane
    stylesheets = List("/style.css")

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