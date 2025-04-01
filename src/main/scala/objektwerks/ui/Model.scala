package objektwerks.ui

import java.time.LocalDate

import scalafx.beans.property.ObjectProperty
import scalafx.collections.ObservableBuffer

import objektwerks.{Encodings, Number, Numbers}

object Model:
  val observableEncodings = ObservableBuffer[Encodings]()
  val observableNumbers = ObservableBuffer[Number]()
  val observableDate = ObjectProperty[LocalDate](this, "date", LocalDate.now)
  
  val primes = Numbers.listPrimes(0 to 1000)
  val fibonaccis = Numbers.listFibonaccis(0 to 15)

  def addNumber(number: Int): Boolean =
    val candidate = Number(primes, fibonaccis, number)
    val isCandidateObservable = observableNumbers.contains(candidate)
    if !isCandidateObservable then observableNumbers.prepend( Number(primes, fibonaccis, number) )
    isCandidateObservable

  def addEncoding(text: String): Unit = observableEncodings.prepend( Encodings.encode(text) )
  
  def clear(): Unit =
    observableNumbers.clear()
    observableEncodings.clear()