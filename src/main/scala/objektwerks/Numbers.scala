package objektwerks

import Math.*

import scala.annotation.tailrec

object Numbers:
  def isPrime(n: Int): Boolean =
    @tailrec
    def loop(current: Int): Boolean =
      if current > sqrt(abs(n.toDouble)) then true
      else n % current != 0 && loop(current + 1)

    if n == -1 || n == 0 || n == 1 then false
    else loop(2)

  def listPrimes(range: Range): List[(Int, Int)] =
    range.filter(isPrime).toList.zipWithIndex.map( (prime, rank) => (rank + 1, prime) )

  def findPrimeRank(primes: List[(Int, Int)], target: Int): Int =
    primes.filter{ (_, prime) => prime == target }.headOption.getOrElse( (0, 0) )._1

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