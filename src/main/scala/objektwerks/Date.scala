package objektwerks

import java.time.LocalDate

object Date:
  type Expression = String
  type Encoding = Int

  def dayOfYear(date: LocalDate): String = date.getDayOfYear.toString

  def remainingDaysInYear(date: LocalDate): String = ( date.lengthOfYear() - date.getDayOfYear ).toString

  def splitYear(date: LocalDate): (Expression, Encoding) = // (mm) + (dd) + (yy) + (yy)
    val month = date.getMonthValue()
    val day = date.getDayOfMonth()
    val (leftYear, rightYear) = date.getYear.toString.splitAt(2)
    val expression = s"($month) + ($day) + ($leftYear) + ($rightYear)"
    val encoding = month + day + leftYear.toInt + rightYear.toInt
    (expression, encoding)

  def splitEachYear(date: LocalDate): (Expression, Encoding) = // (mm) + (dd) + y + y + y + y
    val month = date.getMonthValue()
    val day = date.getDayOfMonth()
    val years = date.getYear.toString.toCharArray
    val expression = s"($month) + ($day) + ($years(0)) + ($years(1)) + ($years(2)) + ($years(3)))"
    val encoding = month + day + years.map(c => c.toInt).sum
    (expression, encoding)

  def splitEachMonthDayYear(date: LocalDate): (Expression, Encoding) = // m + m + d + d + y + y + y + y
    val months = date.getMonthValue.toString.toCharArray
    val days = date.getDayOfMonth.toString.toCharArray
    val years = date.getYear.toString.toCharArray
    val expression = s"""
                      ($months(0)) + ($months(1))
                      ($days(0)) + ($days(1))
                      ($years(0)) + ($years(1)) + ($years(2)) + ($years(3))
                      """.stripMargin
    val encoding = months.map(c => c.toInt).sum + days.map(c => c.toInt).sum + years.map(c => c.toInt).sum
    (expression, encoding)