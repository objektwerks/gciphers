package objektwerks

import java.time.LocalDate

object Date:
  def dayOfYear(date: LocalDate): String = date.getDayOfYear.toString

  def remainingDaysInYear(date: LocalDate): String = ( date.lengthOfYear() - date.getDayOfYear ).toString

  def splitYear(date: LocalDate): Int = // (5) + (25) + (20) + (23)
    val month = date.getMonthValue()
    val day = date.getDayOfMonth()
    val year = date.getYear().toString
    val (leftYear, rightYear) = year.splitAt(2)
    month + day + leftYear.toInt + rightYear.toInt

  def foreachYear(date: LocalDate): Int = // (5) + (25) + 2 + 0 + 2 + 3
    val month = date.getMonthValue()
    val day = date.getDayOfMonth()
    val year = date.getYear().toString.toCharArray.map(c => c.toInt).sum
    month + day + year