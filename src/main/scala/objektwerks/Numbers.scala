package objektwerks

import Math.*

import scala.annotation.tailrec
import scalafx.beans.property.ObjectProperty

object Number:
  import Numbers.*

  def apply(primes: List[(Rank, Prime)], number: Int): Number =
    Number(number,
           isPrime(number),
           findPrimeRank(primes, number),
           isStar(number),
           isTriangular(number),
           listFactors(number))

final case class Number(number: Int,
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

object Numbers:
  type Rank = Int
  type Prime = Int

  val defaultRankPrime = (0, 0)

  def isPrime(n: Int): Boolean =
    @tailrec
    def loop(current: Int): Boolean =
      if current > sqrt(abs(n.toDouble)) then true
      else n % current != 0 && loop(current + 1)

    if n == -1 || n == 0 || n == 1 then false
    else loop(2)

  def listPrimes(range: Range): List[(Rank, Prime)] =
    range
      .filter(isPrime)
      .toList
      .zipWithIndex
      .map( (prime, rank) => (rank + 1, prime) )

  def findPrimeRank(primes: List[(Rank, Prime)], targetPrime: Prime): Rank =
    val (rank, prime) = primes
      .filter{ (_, prime) => prime == targetPrime }
      .headOption
      .getOrElse( defaultRankPrime )
    rank

  def isStar(n: Int): Boolean =
    val star = ( 6 + Math.sqrt( (24 * n) + 12 ) ) / 6
    (star - star.toInt) == 0

  @tailrec
  def isTriangular(n: Int, counter: Int = 1, sum: Int = 0): Boolean =
    if n < 1 then false
    else if sum == n then true
    else if counter > n then false
    else isTriangular(n, counter + 1, sum + counter)

  def listFactors(n: Int): List[Int] =
    @tailrec
    def loop(remaining: Int, currentDivisor: Int, acc: List[Int]): List[Int] =
      if currentDivisor > sqrt(remaining.toDouble) then remaining :: acc
      else if remaining % currentDivisor == 0 then loop(remaining / currentDivisor, currentDivisor, currentDivisor :: acc)
      else loop(remaining, currentDivisor + 1, acc)

    if n < 1 then List.empty[Int] else loop(n, 2, List())