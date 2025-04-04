package objektwerks.ui

import java.time.LocalDate

import scalafx.beans.property.ObjectProperty
import scalafx.collections.{ObservableBuffer, ObservableMap}

import objektwerks.{Encodings, Number, Numbers, Texts}

final class Model():
  val observableEncodings = ObservableBuffer[Encodings]()
  val observableNumbers = ObservableBuffer[Number]()
  val observableTexts = ObservableMap[Int, Texts]()
  val observableDate = ObjectProperty[LocalDate](this, "date", LocalDate.now)
  
  val primes = Numbers.listPrimes(0 to 1000)
  val fibonaccis = Numbers.listFibonaccis(0 to 15)

  def addEncoding(text: String): Unit =
    observableEncodings.prepend( Encodings.encode(text) )

  def addNumber(number: Int): Boolean =
    val candidate = Number(number, primes, fibonaccis)
    val isCandidateObservable = observableNumbers.contains(candidate)
    if !isCandidateObservable then
      observableNumbers.prepend( Number(number, primes, fibonaccis) )
    isCandidateObservable

  def addTexts(number: Int, text: String): Unit = ???
  
  def clear(): Unit =
    observableNumbers.clear()
    observableEncodings.clear()