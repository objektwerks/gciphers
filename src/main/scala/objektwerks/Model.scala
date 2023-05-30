package objektwerks

import java.time.LocalDate

import scalafx.beans.property.ObjectProperty
import scalafx.collections.ObservableBuffer

object Model:
  val observableNumbers = ObservableBuffer[Number]()
  val observableEncodings = ObservableBuffer[Encodings]()
  val observableDate = ObjectProperty[LocalDate](this, "date", LocalDate.now)
  val primes = Numbers.listPrimes(0 to 1000)
  val fibonaccis = Numbers.listFibonaccis(0 to 15)

  def addNumber(number: Int): Boolean =
    val candidate = Number(primes, number)
    val isListed = observableNumbers.contains(candidate)
    if !isListed then observableNumbers += Number(primes, number)
    isListed

  def addEncoding(text: String): Unit = observableEncodings += Encodings.encode(text)
  
  def clear(): Unit =
    observableNumbers.clear()
    observableEncodings.clear()