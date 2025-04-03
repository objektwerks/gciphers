package objektwerks

import scalafx.beans.property.ObjectProperty

import Numbers.*

object Number:
  def apply(number: Int,
            primes: List[(Rank, Prime)],
            fibonaccis: List[(Rank, Fibonacci)]
            ): Number =
    Number(number,
           findPrimeRank(primes, number),
           findFibonacciRank(fibonaccis, number),
           isStar(number),
           isTriangular(number),
           listFactors(number))

final case class Number(number: Int,
                        primeRank: Int,
                        fibonacciRank: Int,
                        isStar: Boolean,
                        isTriangular: Boolean,
                        factors: List[Int]) derives CanEqual:
  val numberProperty = ObjectProperty[Int](this, "number", number)
  val primeRankProperty = ObjectProperty[Int](this, "primerank", primeRank)
  val fibbonaciRankProperty = ObjectProperty[Int](this, "fibonaccirank", fibonacciRank)
  val isStarProperty = ObjectProperty[Boolean](this, "isstar", isStar)
  val isTriangularProperty = ObjectProperty[Boolean](this, "istriangular", isTriangular)
  val factorsProperty = ObjectProperty[String](this, "fators", factors.mkString(", "))