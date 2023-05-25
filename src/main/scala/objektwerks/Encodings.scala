package objektwerks

import scalafx.beans.property.ObjectProperty

import Ciphers.*
import Numbers.*

object Encoding:
  def apply(primes: List[(Rank, Prime)], number: Int): Encoding =
    Encoding(number,
             isPrime(number),
             findPrimeRank(primes, number),
             isStar(number),
             isTriangular(number),
             listFactors(number))

final case class Encoding(number: Int,
                          isPrime: Boolean,
                          primeRank: Int,
                          isStar: Boolean,
                          isTriangular: Boolean,
                          factors: List[Int]):
  val numberProperty = ObjectProperty[Int](this, "number", number)
  val isPrimeProperty = ObjectProperty[Boolean](this, "isprime", isPrime)
  val rankProperty = ObjectProperty[Int](this, "primerank", primeRank)
  val isStarProperty = ObjectProperty[Boolean](this, "isstar", isPrime)
  val isTriangularProperty = ObjectProperty[Boolean](this, "istriangular", isPrime)
  val factorsProperty = ObjectProperty[String](this, "fators", factors.mkString(", "))


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
                           reverseSatanic: ReverseSatanic):
  val textProperty = ObjectProperty[String](this, "text", text)
  val ordinalProperty = ObjectProperty[Int](this, "ordinal", ordinal.value)
  val reverseOrdinalProperty = ObjectProperty[Int](this, "reverseOrdinal", reverseOrdinal.value)
  val reductionProperty = ObjectProperty[Int](this, "reduction", reduction.value)
  val reverseReductionProperty = ObjectProperty[Int](this, "reverseReduction", reverseReduction.value)
  val standardProperty = ObjectProperty[Int](this, "standard", standard.value)
  val reverseStandardProperty = ObjectProperty[Int](this, "reverseStandard", reverseStandard.value)
  val latinProperty = ObjectProperty[Int](this, "latin", latin.value)
  val sumerianProperty = ObjectProperty[Int](this, "sumerian", sumerian.value)
  val reverseSumerianProperty = ObjectProperty[Int](this, "reverseSumerian", reverseSumerian.value)
  val primesProperty = ObjectProperty[Int](this, "primes", primes.value)
  val reversePrimesProperty = ObjectProperty[Int](this, "reversePrimes", reversePrimes.value)
  val fibonacciProperty = ObjectProperty[Int](this, "fibonacci", fibonacci.value)
  val squaresProperty = ObjectProperty[Int](this, "squares", squares.value)
  val reverseSquaresProperty = ObjectProperty[Int](this, "reverseSquares", reverseSquares.value)
  val trigonalProperty = ObjectProperty[Int](this, "trigonal", trigonal.value)
  val reverseTrigonalProperty = ObjectProperty[Int](this, "reverseTrigonal", reverseTrigonal.value)
  val singleReductionProperty = ObjectProperty[Int](this, "singleReduction", singleReduction.value)
  val reverseSingleReductionProperty = ObjectProperty[Int](this, "reverseSingleReduction", reverseSingleReduction.value)
  val keypadProperty = ObjectProperty[Int](this, "keypad", keypad.value)
  val chaldeanProperty = ObjectProperty[Int](this, "chaldean", chaldean.value)
  val septenaryProperty = ObjectProperty[Int](this, "septenary", septenary.value)
  val satanicProperty = ObjectProperty[Int](this, "satanic", satanic.value)
  val reverseSatanicProperty = ObjectProperty[Int](this, "reverseSatanic", reverseSatanic.value)
  val encodings = this

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