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

  def dayOfYear(): String = Date.dayOfYear(observableDate.value)

  def remainingDaysInYear(): String = Date.remainingDaysInYear(observableDate.value)

  def splitYear(): Int = Date.splitYear(observableDate.value)

  def splitEachYear(): Int = Date.splitEachYear(observableDate.value)
  
  def clear(): Unit =
    observableNumbers.clear()
    observableEncodings.clear()