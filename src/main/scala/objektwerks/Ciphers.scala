package objektwerks

sealed trait Cipher derives CanEqual:
  val value: Int

final case class Ordinal(value: Int) extends Cipher
val ordinalCipher =
  Map( 'a' -> 1, 'b' -> 2, 'c' -> 3, 'd' -> 4, 'e' -> 5, 'f' -> 6, 'g' -> 7, 'h' -> 8, 'i' -> 9, 'j' -> 10, 'k' -> 1, 'l' -> 12, 'm' -> 13,
       'n' -> 14, 'o' -> 15, 'p' -> 16, 'q' -> 17, 'r' -> 18, 's' -> 19, 't' -> 20, 'u' -> 21, 'v' -> 22, 'w' -> 23, 'x' -> 24, 'y' -> 25, 'z' -> 26 )

final case class ReverseOrdinal(value: Int) extends Cipher
val reverseOrdinalCipher =
  Map( 'a' -> 26, 'b' -> 25, 'c' -> 24, 'd' -> 23, 'e' -> 22, 'f' -> 21, 'g' -> 20, 'h' -> 19, 'i' -> 18, 'j' -> 17, 'k' -> 16, 'l' -> 15, 'm' -> 14,
       'n' -> 13, 'o' -> 12, 'p' -> 11, 'q' -> 10, 'r' -> 9, 's' -> 8, 't' -> 7, 'u' -> 6, 'v' -> 5, 'w' -> 4, 'x' -> 3, 'y' -> 2, 'z' -> 1 )

final case class Reduction(value: Int) extends Cipher
val reductionCipher =
  Map( 'a' -> 1, 'b' -> 2, 'c' -> 3, 'd' -> 4, 'e' -> 5, 'f' -> 6, 'g' -> 7, 'h' -> 8, 'i' -> 9, 'j' -> 1, 'k' -> 2, 'l' -> 3, 'm' -> 4,
       'n' -> 5, 'o' -> 6, 'p' -> 7, 'q' -> 8, 'r' -> 9, 's' -> 1, 't' -> 2, 'u' -> 3, 'v' -> 4, 'w' -> 5, 'x' -> 6, 'y' -> 7, 'z' -> 8 )

final case class ReverseReduction(value: Int) extends Cipher
val reverseReductionCipher =
  Map( 'a' -> 8, 'b' -> 7, 'c' -> 6, 'd' -> 5, 'e' -> 4, 'f' -> 3, 'g' -> 2, 'h' -> 1, 'i' -> 9, 'j' -> 8, 'k' -> 7, 'l' -> 6, 'm' -> 5,
       'n' -> 4, 'o' -> 3, 'p' -> 2, 'q' -> 1, 'r' -> 9, 's' -> 8, 't' -> 7, 'u' -> 6, 'v' -> 5, 'w' -> 4, 'x' -> 3, 'y' -> 2, 'z' -> 1 )

final case class Standard(value: Int) extends Cipher
val standardCipher =
  Map( 'a' -> 1, 'b' -> 2, 'c' -> 3, 'd' -> 4, 'e' -> 5, 'f' -> 6, 'g' -> 7, 'h' -> 8, 'i' -> 9, 'j' -> 10, 'k' -> 20, 'l' -> 30, 'm' -> 40,
       'n' -> 50, 'o' -> 60, 'p' -> 70, 'q' -> 80, 'r' -> 90, 's' -> 100, 't' -> 200, 'u' -> 300, 'v' -> 400, 'w' -> 500, 'x' -> 600, 'y' -> 700, 'z' -> 800 )

final case class ReverseStandard(value: Int) extends Cipher
val reverseStandardCipher =
  Map( 'a' -> 800, 'b' -> 700, 'c' -> 600, 'd' -> 500, 'e' -> 400, 'f' -> 300, 'g' -> 200, 'h' -> 100, 'i' -> 90, 'j' -> 80, 'k' -> 70, 'l' -> 60, 'm' -> 50,
       'n' -> 40, 'o' -> 30, 'p' -> 20, 'q' -> 10, 'r' -> 9, 's' -> 8, 't' -> 7, 'u' -> 6, 'v' -> 5, 'w' -> 4, 'x' -> 3, 'y' -> 2, 'z' -> 1 )

final case class Latin(value: Int) extends Cipher
val latinCipher =
  Map( 'a' -> 1, 'b' -> 2, 'c' -> 3, 'd' -> 4, 'e' -> 5, 'f' -> 6, 'g' -> 7, 'h' -> 8, 'i' -> 9, 'j' -> 600, 'k' -> 10, 'l' -> 20, 'm' -> 30,
       'n' -> 40, 'o' -> 50, 'p' -> 60, 'q' -> 70, 'r' -> 80, 's' -> 90, 't' -> 100, 'u' -> 200, 'v' -> 700, 'w' -> 900, 'x' -> 300, 'y' -> 400, 'z' -> 500 )

final case class Sumerian(value: Int) extends Cipher
val sumerianCipher =
  Map( 'a' -> 6, 'b' -> 12, 'c' -> 18, 'd' -> 24, 'e' -> 30, 'f' -> 36, 'g' -> 42, 'h' -> 48, 'i' -> 54, 'j' -> 60, 'k' -> 66, 'l' -> 72, 'm' -> 78,
       'n' -> 84, 'o' -> 90, 'p' -> 96, 'q' -> 102, 'r' -> 108, 's' -> 114, 't' -> 120, 'u' -> 126, 'v' -> 132, 'w' -> 138, 'x' -> 144, 'y' -> 150, 'z' -> 156 )

final case class ReverseSumerian(value: Int) extends Cipher
val reverseSumerianCipher =
  Map( 'a' -> 156, 'b' -> 150, 'c' -> 144, 'd' -> 138, 'e' -> 132, 'f' -> 126, 'g' -> 120, 'h' -> 114, 'i' -> 108, 'j' -> 102, 'k' -> 96, 'l' -> 90, 'm' -> 84,
       'n' -> 78, 'o' -> 72, 'p' -> 66, 'q' -> 60, 'r' -> 54, 's' -> 48, 't' -> 42, 'u' -> 36, 'v' -> 30, 'w' -> 24, 'x' -> 18, 'y' -> 12, 'z' -> 6 )

final case class Primes(value: Int) extends Cipher
val primesCipher =
  Map( 'a' -> 2, 'b' -> 3, 'c' -> 5, 'd' -> 7, 'e' -> 11, 'f' -> 13, 'g' -> 17, 'h' -> 19, 'i' -> 23, 'j' -> 29, 'k' -> 31, 'l' -> 37, 'm' -> 41,
       'n' -> 43, 'o' -> 47, 'p' -> 53, 'q' -> 59, 'r' -> 61, 's' -> 67, 't' -> 71, 'u' -> 73, 'v' -> 79, 'w' -> 83, 'x' -> 89, 'y' -> 97, 'z' -> 101 )

final case class ReversePrimes(value: Int) extends Cipher
val reversePrimesCipher =
  Map( 'a' -> 101, 'b' -> 97, 'c' -> 89, 'd' -> 83, 'e' -> 79, 'f' -> 73, 'g' -> 71, 'h' -> 67, 'i' -> 61, 'j' -> 59, 'k' -> 53, 'l' -> 47, 'm' -> 43,
       'n' -> 41, 'o' -> 37, 'p' -> 31, 'q' -> 29, 'r' -> 23, 's' -> 19, 't' -> 17, 'u' -> 13, 'v' -> 11, 'w' -> 7, 'x' -> 5, 'y' -> 3, 'z' -> 2 )

final case class Fibonacci(value: Int) extends Cipher
val fibonacciCipher =
  Map( 'a' -> 1, 'b' -> 1, 'c' -> 2, 'd' -> 3, 'e' -> 5, 'f' -> 8, 'g' -> 13, 'h' -> 21, 'i' -> 34, 'j' -> 55, 'k' -> 89, 'l' -> 144, 'm' -> 233,
       'n' -> 233, 'o' -> 144, 'p' -> 89, 'q' -> 55, 'r' -> 34, 's' -> 21, 't' -> 13, 'u' -> 8, 'v' -> 5, 'w' -> 3, 'x' -> 2, 'y' -> 1, 'z' -> 1 )

final case class Squares(value: Int) extends Cipher
val squaresCipher =
  Map( 'a' -> 1, 'b' -> 4, 'c' -> 9, 'd' -> 16, 'e' -> 25, 'f' -> 36, 'g' -> 49, 'h' -> 64, 'i' -> 81, 'j' -> 100, 'k' -> 121, 'l' -> 144, 'm' -> 169,
       'n' -> 196, 'o' -> 225, 'p' -> 256, 'q' -> 289, 'r' -> 324, 's' -> 361, 't' -> 400, 'u' -> 441, 'v' -> 484, 'w' -> 529, 'x' -> 576, 'y' -> 625, 'z' -> 676 )

final case class ReverseSquares(value: Int) extends Cipher
val reverseSquaresCipher =
  Map( 'a' -> 676, 'b' -> 625, 'c' -> 576, 'd' -> 529, 'e' -> 484, 'f' -> 441, 'g' -> 400, 'h' -> 361, 'i' -> 324, 'j' -> 289, 'k' -> 256, 'l' -> 225, 'm' -> 196,
       'n' -> 169, 'o' -> 144, 'p' -> 121, 'q' -> 100, 'r' -> 81, 's' -> 64, 't' -> 49, 'u' -> 36, 'v' -> 25, 'w' -> 16, 'x' -> 9, 'y' -> 4, 'z' -> 1 )

final case class Trigonal(value: Int) extends Cipher
val trigonalCipher =
  Map( 'a' -> 1, 'b' -> 3, 'c' -> 6, 'd' -> 10, 'e' -> 15, 'f' -> 21, 'g' -> 28, 'h' -> 36, 'i' -> 45, 'j' -> 55, 'k' -> 66, 'l' -> 78, 'm' -> 91,
       'n' -> 105, 'o' -> 120, 'p' -> 136, 'q' -> 153, 'r' -> 171, 's' -> 190, 't' -> 210, 'u' -> 231, 'v' -> 253, 'w' -> 276, 'x' -> 300, 'y' -> 325, 'z' -> 351 )

final case class ReverseTrigonal(value: Int) extends Cipher
val reverseTrigonalCipher =
  Map( 'a' -> 351, 'b' -> 325, 'c' -> 300, 'd' -> 276, 'e' -> 253, 'f' -> 231, 'g' -> 210, 'h' -> 190, 'i' -> 171, 'j' -> 153, 'k' -> 136, 'l' -> 120, 'm' -> 105,
       'n' -> 91, 'o' -> 78, 'p' -> 66, 'q' -> 55, 'r' -> 45, 's' -> 36, 't' -> 28, 'u' -> 21, 'v' -> 15, 'w' -> 10, 'x' -> 6, 'y' -> 3, 'z' -> 1 )

final case class SingleReduction(value: Int) extends Cipher
val singleReductionCipher =
  Map( 'a' -> 1, 'b' -> 2, 'c' -> 3, 'd' -> 4, 'e' -> 5, 'f' -> 6, 'g' -> 7, 'h' -> 8, 'i' -> 9, 'j' -> 1, 'k' -> 2, 'l' -> 3, 'm' -> 4,
       'n' -> 5, 'o' -> 6, 'p' -> 7, 'q' -> 8, 'r' -> 9, 's' -> 10, 't' -> 2, 'u' -> 3, 'v' -> 4, 'w' -> 5, 'x' -> 6, 'y' -> 7, 'z' -> 8 )

final case class ReverseSingleReduction(value: Int) extends Cipher
val reverseSingleReductionCipher =
  Map( 'a' -> 8, 'b' -> 7, 'c' -> 6, 'd' -> 5, 'e' -> 4, 'f' -> 3, 'g' -> 2, 'h' -> 10, 'i' -> 9, 'j' -> 8, 'k' -> 7, 'l' -> 6, 'm' -> 5,
       'n' -> 4, 'o' -> 3, 'p' -> 2, 'q' -> 1, 'r' -> 9, 's' -> 8, 't' -> 7, 'u' -> 6, 'v' -> 5, 'w' -> 4, 'x' -> 3, 'y' -> 2, 'z' -> 1 )

final case class Keypad(value: Int) extends Cipher
val keypadCipher =
  Map( 'a' -> 2, 'b' -> 2, 'c' -> 2, 'd' -> 3, 'e' -> 3, 'f' -> 3, 'g' -> 4, 'h' -> 4, 'i' -> 4, 'j' -> 5, 'k' -> 5, 'l' -> 5, 'm' -> 6,
       'n' -> 6, 'o' -> 6, 'p' -> 7, 'q' -> 7, 'r' -> 7, 's' -> 7, 't' -> 8, 'u' -> 8, 'v' -> 8, 'w' -> 9, 'x' -> 9, 'y' -> 9, 'z' -> 9 )

final case class Chaldean(value: Int) extends Cipher
val chaldeanCipher =
  Map( 'a' -> 1, 'b' -> 2, 'c' -> 2, 'd' -> 4, 'e' -> 5, 'f' -> 8, 'g' -> 3, 'h' -> 5, 'i' -> 1, 'j' -> 1, 'k' -> 2, 'l' -> 3, 'm' -> 4,
       'n' -> 5, 'o' -> 7, 'p' -> 8, 'q' -> 1, 'r' -> 2, 's' -> 3, 't' -> 4, 'u' -> 6, 'v' -> 6, 'w' -> 6, 'x' -> 5, 'y' -> 1, 'z' -> 7 )

final case class Septenary(value: Int) extends Cipher
val septenaryCipher =
  Map( 'a' -> 1, 'b' -> 2, 'c' -> 3, 'd' -> 4, 'e' -> 5, 'f' -> 6, 'g' -> 7, 'h' -> 6, 'i' -> 5, 'j' -> 4, 'k' -> 3, 'l' -> 2, 'm' -> 1,
       'n' -> 1, 'o' -> 2, 'p' -> 3, 'q' -> 4, 'r' -> 5, 's' -> 6, 't' -> 7, 'u' -> 6, 'v' -> 5, 'w' -> 4, 'x' -> 3, 'y' -> 2, 'z' -> 1 )

final case class Satanic(value: Int) extends Cipher
val satanicCipher =
  Map( 'a' -> 36, 'b' -> 37, 'c' -> 38, 'd' -> 39, 'e' -> 40, 'f' -> 41, 'g' -> 42, 'h' -> 43, 'i' -> 44, 'j' -> 45, 'k' -> 46, 'l' -> 47, 'm' -> 48,
       'n' -> 49, 'o' -> 50, 'p' -> 51, 'q' -> 52, 'r' -> 53, 's' -> 54, 't' -> 55, 'u' -> 56, 'v' -> 57, 'w' -> 58, 'x' -> 59, 'y' -> 60, 'z' -> 61 )

final case class ReverseSatanic(value: Int) extends Cipher
val reverseSatanicCipher =
  Map( 'a' -> 61, 'b' -> 60, 'c' -> 59, 'd' -> 58, 'e' -> 57, 'f' -> 56, 'g' -> 55, 'h' -> 54, 'i' -> 53, 'j' -> 52, 'k' -> 51, 'l' -> 50, 'm' -> 49,
       'n' -> 48, 'o' -> 47, 'p' -> 46, 'q' -> 45, 'r' -> 44, 's' -> 43, 't' -> 42, 'u' -> 41, 'v' -> 40, 'w' -> 39, 'x' -> 38, 'y' -> 37, 'z' -> 36 )

object Ciphers:
  def encipher(cipher: Map[Char, Int], text: String): Int =
    text
      .toCharArray
      .view
      .filter(char => char.isLetter)
      .map(letter => cipher.getOrElse(letter, 0))
      .sum

  def encipherToMap(cipher: Map[Char, Int], text: String): List[(Char, Int)] =
    text
      .toCharArray
      .view
      .filter(char => char.isLetter)
      .map(letter => letter -> cipher.getOrElse(letter, 0))
      .toList