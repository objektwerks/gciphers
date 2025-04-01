package objektwerks

import java.time.LocalDate

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

final class DateTest extends AnyFunSuite with Matchers:
  val date = LocalDate.of(2023, 6, 3)

  test("day of year"):
    Date.dayOfYear(date) shouldBe "154"

  test("remaining days in year"):
    Date.remainingDaysInYear(date) shouldBe "211"

  test("date diff"):
    Date.dateDiff(date, LocalDate.of(2023, 6, 4)) shouldBe 1

  test("split year"):
    val (splitYearExpression, splitYearEncoding) = Date.splitYear(date)
    splitYearExpression shouldBe "6 + 3 + 20 + 23"
    splitYearEncoding shouldBe 52

  test("split each year"):
    val (splitEachYearExpression, splitEachYearEncoding) = Date.splitEachYear(date)
    splitEachYearExpression shouldBe "6 + 3 + 2 + 0 + 2 + 3"
    splitEachYearEncoding shouldBe 16

  test("split each month day year"):
    val (splitEachMonthDayYearExpression, splitEachMonthDayYearEncoding) = Date.splitEachMonthDayYear(date)
    splitEachMonthDayYearExpression shouldBe "6 + 3 + 2 + 0 + 2 + 3"
    splitEachMonthDayYearEncoding shouldBe 16

  test("split right year"):
    val (splitRightYearExpression, splitRightYearEncoding) = Date.splitRightYear(date)
    splitRightYearExpression shouldBe "6 + 3 + 23"
    splitRightYearEncoding shouldBe 32

  test("split each month day right year"):
    val (splitEachMonthDayRightYearExpression, splitEachMonthDayRightYearEncoding) = Date.splitEachMonthDayRightYear(date)
    splitEachMonthDayRightYearExpression shouldBe "6 + 3 + 2 + 3"
    splitEachMonthDayRightYearEncoding shouldBe 14