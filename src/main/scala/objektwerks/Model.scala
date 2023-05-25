package objektwerks

import scalafx.beans.property.ObjectProperty
import scalafx.collections.ObservableBuffer

object Model:
  val observableNumbers = ObservableBuffer[Number]()
  val observableEncodings = ObservableBuffer[Encodings]()
  val primes = Numbers.listPrimes(0 to 1000)

  def addNumber(number: Int): Unit = observableNumbers += Number(primes, number)

  def addEncoding(text: String): Unit = observableEncodings += Encodings.encode(text)

  def clear(): Unit =
    observableNumbers.clear()
    observableEncodings.clear()