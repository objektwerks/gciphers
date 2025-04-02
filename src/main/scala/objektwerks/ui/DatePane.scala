package objektwerks.ui

import scalafx.beans.property.ObjectProperty
import scalafx.geometry.{Insets, Pos}
import scalafx.scene.Node
import scalafx.scene.control.{DatePicker, Label, Tab, TabPane}
import scalafx.scene.layout.{Priority, VBox}

import objektwerks.Date

final class DatePane(context: Context, model: Model) extends VBox:
  spacing = 6
  padding = Insets(6)
  minHeight = 155

  // Date tab begin.

  val dateLabel = new Label:
    alignment = Pos.CenterLeft
    text = context.labelDate

  val datePicker = new DatePicker:
    prefWidth = 110
    value <==> model.observableDate
    onAction = { _ =>
      dayOfYearText.text = Date.dayOfYear(model.observableDate.value)
      remainingDaysInYearText.text = Date.remainingDaysInYear(model.observableDate.value)
    }

  val dayOfYearLabel = new Label:
    alignment = Pos.CenterLeft
    text = context.labelDayOfYear

  val dayOfYearText = new Label:
    alignment = Pos.Center
    text = Date.dayOfYear(model.observableDate.value)

  val remainingDaysInYearLabel = new Label:
    alignment = Pos.CenterLeft
    text = context.labelRemainingDaysInYear

  val remainingDaysInYearText = new Label:
    alignment = Pos.Center
    text = Date.remainingDaysInYear(model.observableDate.value)

  val dateControls = List[(Label, Node)](
    dateLabel -> datePicker,
    dayOfYearLabel -> dayOfYearText,
    remainingDaysInYearLabel -> remainingDaysInYearText
  )

  val dateControlsGrid = ControlGrid(dateControls)

  val dateTab = new Tab:
    style = "-fx-font-weight: bold"
    text = context.tabDate
    closable = false
    content = dateControlsGrid

  // Date tab end.

  // Encodings tab begin.

  val splitYearLabel = new Label:
    alignment = Pos.CenterLeft

  val splitYearText = new Label:
    alignment = Pos.Center

  val splitEachYearLabel = new Label:
    alignment = Pos.CenterLeft

  val splitEachYearText = new Label:
    alignment = Pos.Center

  val splitEachMonthDayYearLabel = new Label:
    alignment = Pos.CenterLeft

  val splitEachMonthDayYearText = new Label:
    alignment = Pos.Center

  val splitRightYearLabel = new Label:
    alignment = Pos.CenterLeft

  val splitRightYearText = new Label:
    alignment = Pos.Center

  val splitEachMonthDayRightYearLabel = new Label:
    alignment = Pos.CenterLeft

  val splitEachMonthDayRightYearText = new Label:
    alignment = Pos.Center

  val encodingsControls = List[(Label, Node)](
    splitYearLabel -> splitYearText,
    splitEachYearLabel -> splitEachYearText,
    splitEachMonthDayYearLabel -> splitEachMonthDayYearText,
    splitRightYearLabel -> splitRightYearText,
    splitEachMonthDayRightYearLabel -> splitEachMonthDayRightYearText
  )

  val encodingsControlsGrid = ControlGrid(encodingsControls)

  val encodingsTab = new Tab:
    style = "-fx-font-weight: bold"
    text = context.tabDateEncodings
    closable = false
    content = encodingsControlsGrid

  def setEncodings: Unit =
    val (splitYearExpression, splitYearEncoding) = Date.splitYear(model.observableDate.value)
    splitYearLabel.text = s"$splitYearExpression:"
    splitYearText.text = splitYearEncoding.toString

    val (splitEachYearExpression, splitEachYearEncoding) = Date.splitEachYear(model.observableDate.value)
    splitEachYearLabel.text = s"$splitEachYearExpression:"
    splitEachYearText.text = splitEachYearEncoding.toString

    val (splitEachMonthDayYearExpression, splitEachMonthDayYearEncoding) = Date.splitEachMonthDayYear(model.observableDate.value)
    splitEachMonthDayYearLabel.text = s"$splitEachMonthDayYearExpression:"
    splitEachMonthDayYearText.text = splitEachMonthDayYearEncoding.toString

    val (splitRightYearExpression, splitRightYearEncoding) = Date.splitRightYear(model.observableDate.value)
    splitRightYearLabel.text = s"$splitRightYearExpression:"
    splitRightYearText.text = splitRightYearEncoding.toString

    val (splitEachMonthDayRightYearExpression, splitEachMonthDayRightYearEncoding) = Date.splitEachMonthDayRightYear(model.observableDate.value)
    splitEachMonthDayRightYearLabel.text = s"$splitEachMonthDayRightYearExpression:"
    splitEachMonthDayRightYearText.text = splitEachMonthDayRightYearEncoding.toString

  model.observableDate.onChange { (_, _, _) =>
    setEncodings
  }
  setEncodings

  // Encodings tab end.

  // Date Diff tab begin.

  val fromDate = ObjectProperty(model.observableDate.value)
  val toDate = ObjectProperty(model.observableDate.value)

  fromDate.onChange { (_, _, _) =>
    dateDiffText.text = Date.dateDiff( fromDate.value, toDate.value ).toString
  }

  toDate.onChange { (_, _, _) =>
    dateDiffText.text = Date.dateDiff( fromDate.value, toDate.value ).toString
  }

  val fromDateLabel = new Label:
    alignment = Pos.CenterLeft
    text = context.labelFromDate

  val fromDatePicker = new DatePicker:
    prefWidth = 110
    value = model.observableDate.value
    onAction = { _ =>
      fromDate.value = value.value
    }

  val toDateLabel = new Label:
    alignment = Pos.CenterLeft
    text = context.labelToDate

  val toDatePicker = new DatePicker:
    prefWidth = 110
    value = model.observableDate.value
    onAction = { _ =>
      toDate.value = value.value
    }

  val dateDiffLabel = new Label:
    alignment = Pos.CenterLeft
    text = context.labelDateDiff

  val dateDiffText = new Label:
    alignment = Pos.Center
    text = "0"

  val dateDiffControls = List[(Label, Node)](
    fromDateLabel -> fromDatePicker,
    toDateLabel -> toDatePicker,
    dateDiffLabel -> dateDiffText
  )

  val dateDiffControlsGrid = ControlGrid(dateDiffControls)

  val dateDiffTab = new Tab:
    style = "-fx-font-weight: bold"
    text = context.tabDateDif
    closable = false
    content = dateDiffControlsGrid

  // Date Diff tab end.

  val tabPane = new TabPane:
    tabs = List(dateTab, encodingsTab, dateDiffTab)
  
  children = List(tabPane)
  VBox.setVgrow(this, Priority.Always)