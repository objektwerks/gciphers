package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import Numbers.*

final class NumbersTest extends AnyFunSuite with Matchers:
  test("is prime"):
    isPrime(11) shouldBe true
    isPrime(15) shouldBe false
    isPrime(0) shouldBe false
    isPrime(1) shouldBe false
    isPrime(-1) shouldBe false

  test("list primes"):
    listPrimes(0 to 1000).length shouldBe 168

  test("find prime rank"):
    findPrimeRank( listPrimes(0 to 1000), 101 ) shouldBe 26
    findPrimeRank( listPrimes(0 to 100), 101 ) shouldBe 0

  test("fibbonaci"):
    fibonacci(9) shouldBe 34

  test("list fibonaccis"):
    listFibonaccis(0 to 6) shouldBe List((1,0), (2,1), (3,1), (4,2), (5,3), (6,5), (7,8))

  test("find fibonacci rank"):
    findFibonacciRank( listFibonaccis(0 to 6), 5 ) shouldBe 6
    findFibonacciRank( listFibonaccis(0 to 6), 10 ) shouldBe 0

  test("is star"):
    isStar(37) shouldBe true
    isStar(10) shouldBe false

  test("is triangualar"):
    isTriangular(1) shouldBe true
    isTriangular(10) shouldBe true
    isTriangular(0) shouldBe false
    isTriangular(9) shouldBe false

  test("listFactors"):
    listFactors(11) shouldBe List(11)
    listFactors(15) shouldBe List(5, 3)
    listFactors(21) shouldBe List(7, 3)
    listFactors(0) shouldBe List()