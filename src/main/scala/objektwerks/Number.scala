package objektwerks

import scalafx.beans.property.ObjectProperty

import Numbers.*

object Number:
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