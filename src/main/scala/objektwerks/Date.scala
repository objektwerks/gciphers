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

  def splitEachYear(date: LocalDate): Int = // (mm) + (dd) + y + y + y + y
    val month = date.getMonthValue()
    val day = date.getDayOfMonth()
    val year = date.getYear.toString.toCharArray.map(c => c.toInt).sum
    month + day + year

  def splitEachMonthDayYear(date: LocalDate): Int = // m + m + d + d + y + y + y + y
    val month = date.getMonthValue.toString.toCharArray.map(c => c.toInt).sum
    val day = date.getDayOfMonth.toString.toCharArray.map(c => c.toInt).sum
    val year = date.getYear.toString.toCharArray.map(c => c.toInt).sum
    month + day + year