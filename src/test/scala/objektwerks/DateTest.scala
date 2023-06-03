package objektwerks

import java.time.LocalDate

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class DateTest extends AnyFunSuite with Matchers:
  val date = LocalDate.of(2023, 6, 3)

  test("split year") {
    val (splitYearExpression, splitYearEncoding) = Date.splitYear(date)
    splitYearExpression shouldBe "(6) + (3) + (20) + (23)"
    splitYearEncoding shouldBe 52
  }

  test("split each year") {
    val (splitEachYearExpression, splitEachYearEncoding) = Date.splitEachYear(date)
    splitEachYearExpression shouldBe "(6) + (3) + 2 + 0 + 2 + 3"
    splitEachYearEncoding shouldBe 16
  }