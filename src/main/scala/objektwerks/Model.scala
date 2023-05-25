package objektwerks

import scalafx.beans.property.ObjectProperty
import scalafx.collections.ObservableBuffer

import Numbers.{findPrimeRank, listPrimes}

object Model:
  val observableNumbers = ObservableBuffer[Number]()
  val observableEncodings = ObservableBuffer[Encodings]()
  val primes = listPrimes(0 to 1000)

  def primeRank(prime: Int): Int = findPrimeRank(primes, prime)

  def encode(text: String): Unit = observableEncodings += Encodings.encode(text)

  def clear(): Unit =
    observableNumbers.clear()
    observableEncodings.clear()