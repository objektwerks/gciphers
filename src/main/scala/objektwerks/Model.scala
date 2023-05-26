package objektwerks

import java.time.LocalDate

import scalafx.beans.property.ObjectProperty
import scalafx.collections.ObservableBuffer

object Model:
  val observableNumbers = ObservableBuffer[Number]()
  val observableEncodings = ObservableBuffer[Encodings]()
  val observableDate = ObjectProperty[LocalDate](this, "date", LocalDate.now)
  val primes = Numbers.listPrimes(0 to 1000)

  def addNumber(number: Int): Boolean =
    val candidate = Number(primes, number)
    val isListed = observableNumbers.contains(candidate)
    if !isListed then observableNumbers += Number(primes, number)
    isListed

  def addEncoding(text: String): Unit = observableEncodings += Encodings.encode(text)

  def dayOfYear(): String = observableDate.value.getDayOfYear.toString

  def remainingDaysInYear(): String = ( observableDate.value.lengthOfYear() - observableDate.value.getDayOfYear ).toString

  def splitYear(): Int = // (5) + (25) + (20) + (23)
    val date = observableDate.value
    val month = date.getMonthValue()
    val day = date.getDayOfMonth()
    val year = date.getYear().toString
    val (leftYear, rightYear) = year.splitAt(2)
    month + day + leftYear.toInt + rightYear.toInt

  def foreachYear(): Int = // (5) + (25) + 2 + 0 + 2 + 3
    val date = observableDate.value
    val month = date.getMonthValue()
    val day = date.getDayOfMonth()
    val year = date.getYear().toString.toCharArray.map(c => c.toInt).sum
    month + day + year

  def clear(): Unit =
    observableNumbers.clear()
    observableEncodings.clear()