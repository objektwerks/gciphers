package objektwerks.ui

import java.time.LocalDate

import scala.collection.mutable
import scalafx.beans.property.ObjectProperty
import scalafx.collections.ObservableBuffer

import objektwerks.{Encodings, Number, Numbers, Store, Texts}

final class Model(store: Store):
  val observableEncodings = ObservableBuffer[Encodings]()
  val observableNumbers = ObservableBuffer[Number]()
  val observableTexts = ObservableBuffer[Texts]()
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

  def addTexts(number: Int, value: String): Unit =
    observableTexts.find(texts => texts.number == number) match
      case Some(texts) =>
        println(s"before: $texts")
        texts.values.add(value)
        println(s"after: $texts")
        store.writeTexts(texts)
        val index = observableTexts.indexOf(texts)
        println(s"observable texts index: $index")
        if index > -1 then observableTexts.update(index, texts)
      case None =>
        val texts = Texts(number, mutable.Set(value))
        store.writeTexts(texts)
        observableTexts.prepend(texts)

  def clear(): Unit =
    observableNumbers.clear()
    observableEncodings.clear()