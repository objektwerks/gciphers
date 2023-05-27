package objektwerks

import java.time.LocalDate

import scalafx.scene.control.Dialog

final class ChemicalDialog(date: LocalDate) extends Dialog[LocalDate]:
  initOwner(App.stage)
  title = "Date"
  headerText = "Date Numbers"

  println(date)