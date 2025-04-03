package objektwerks

import scalafx.beans.property.ObjectProperty

import Ciphers.*

object Encodings:
  def encode(text: String): Encodings =
    Encodings(
      text = text,
      ordinal = Ordinal( encipher(ordinalCipher, text) ),
      reverseOrdinal = ReverseOrdinal( encipher(reverseOrdinalCipher, text) ),
      reduction = Reduction( encipher(reductionCipher, text) ),
      reverseReduction = ReverseReduction( encipher(reverseReductionCipher, text) ),
      standard = Standard( encipher(standardCipher, text) ),
      reverseStandard = ReverseStandard( encipher(reverseStandardCipher, text) ),
      latin = Latin( encipher(latinCipher, text) ),
      sumerian = Sumerian( encipher(sumerianCipher, text) ),
      reverseSumerian = ReverseSumerian( encipher(reverseSumerianCipher, text) ),
      primes = Primes( encipher(primesCipher, text) ),
      reversePrimes = ReversePrimes( encipher(reversePrimesCipher, text) ),
      fibonacci = Fibonacci( encipher(fibonacciCipher, text) ),
      squares = Squares( encipher(squaresCipher, text) ),
      reverseSquares = ReverseSquares( encipher(reverseSquaresCipher, text) ),
      trigonal = Trigonal( encipher(trigonalCipher, text) ),
      reverseTrigonal = ReverseTrigonal( encipher(reverseTrigonalCipher, text) ),
      singleReduction = SingleReduction( encipher(singleReductionCipher, text) ),
      reverseSingleReduction = ReverseSingleReduction( encipher(reverseSingleReductionCipher, text) ),
      keypad = Keypad( encipher(keypadCipher, text) ),
      chaldean = Chaldean( encipher(chaldeanCipher, text) ),
      septenary = Septenary( encipher(septenaryCipher, text) ),
      satanic = Satanic( encipher(satanicCipher, text) ),
      reverseSatanic = ReverseSatanic( encipher(reverseSatanicCipher, text) )
    )

final case class Encodings(text: String,
                           ordinal: Ordinal,
                           reverseOrdinal: ReverseOrdinal,
                           reduction: Reduction,
                           reverseReduction: ReverseReduction,
                           standard: Standard,
                           reverseStandard: ReverseStandard,
                           latin: Latin,
                           sumerian: Sumerian,
                           reverseSumerian: ReverseSumerian,
                           primes: Primes,
                           reversePrimes: ReversePrimes,
                           fibonacci: Fibonacci,
                           squares: Squares,
                           reverseSquares: ReverseSquares,
                           trigonal: Trigonal,
                           reverseTrigonal: ReverseTrigonal,
                           singleReduction: SingleReduction,
                           reverseSingleReduction: ReverseSingleReduction,
                           keypad: Keypad,
                           chaldean: Chaldean,
                           septenary: Septenary,
                           satanic: Satanic,
                           reverseSatanic: ReverseSatanic) derives CanEqual:
  val textProperty = ObjectProperty(text)
  val ordinalProperty = ObjectProperty(ordinal.value)
  val reverseOrdinalProperty = ObjectProperty(reverseOrdinal.value)
  val reductionProperty = ObjectProperty(reduction.value)
  val reverseReductionProperty = ObjectProperty(reverseReduction.value)
  val standardProperty = ObjectProperty(standard.value)
  val reverseStandardProperty = ObjectProperty(reverseStandard.value)
  val latinProperty = ObjectProperty(latin.value)
  val sumerianProperty = ObjectProperty(sumerian.value)
  val reverseSumerianProperty = ObjectProperty(reverseSumerian.value)
  val primesProperty = ObjectProperty(primes.value)
  val reversePrimesProperty = ObjectProperty(reversePrimes.value)
  val fibonacciProperty = ObjectProperty(fibonacci.value)
  val squaresProperty = ObjectProperty(squares.value)
  val reverseSquaresProperty = ObjectProperty(reverseSquares.value)
  val trigonalProperty = ObjectProperty(trigonal.value)
  val reverseTrigonalProperty = ObjectProperty(reverseTrigonal.value)
  val singleReductionProperty = ObjectProperty(singleReduction.value)
  val reverseSingleReductionProperty = ObjectProperty(reverseSingleReduction.value)
  val keypadProperty = ObjectProperty(keypad.value)
  val chaldeanProperty = ObjectProperty(chaldean.value)
  val septenaryProperty = ObjectProperty(septenary.value)
  val satanicProperty = ObjectProperty(satanic.value)
  val reverseSatanicProperty = ObjectProperty(reverseSatanic.value)
  val encodings = this