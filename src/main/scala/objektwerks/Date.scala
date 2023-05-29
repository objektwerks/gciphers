package objektwerks

import java.time.LocalDate

object Date:
  type Expression = String
  type Encoding = Int

  val plus = "+"
  val multiply = "*"

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
    val years = date.getYear.toString.toCharArray.map(c => c.toString)
    val expression = s"($month) + ($day) + (${years(0)}) + (${years(1)}) + (${years(2)}) + (${years(3)})"
    val encoding = month + day + years.map(s => s.toInt).sum
    (expression, encoding)

  def splitEachMonthDayYear(date: LocalDate): (Expression, Encoding) = // m + m + d + d + y + y + y + y
    val months = date.getMonthValue.toString.toCharArray.map(c => c.toString)
    val days = date.getDayOfMonth.toString.toCharArray.map(c => c.toString)
    val years = date.getYear.toString.toCharArray.map(c => c.toString)
    val expression = s"${format(months, plus)} + ${format(days, plus)} + (${years(0)}) + (${years(1)}) + (${years(2)}) + (${years(3)})"
    val encoding = months.map(s => s.toInt).sum + days.map(s => s.toInt).sum + years.map(s => s.toInt).sum
    (expression, encoding)

  def format(strings: Array[String], symbol: String): String =
    if strings.length == 2 then s"(${strings(0)}) $symbol (${strings(1)})"
    else if strings.length == 1 then s"(${strings(0)})"
    else "(0)"