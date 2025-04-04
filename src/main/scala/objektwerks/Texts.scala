package objektwerks

import upickle.default.ReadWriter as JsonSupport

import scalafx.beans.property.ObjectProperty

final case class Texts(number: Int, values: Set[String]) derives CanEqual, JsonSupport:
  val numberProperty = ObjectProperty(number)
  val valuesProperty = ObjectProperty(values.mkString(", "))
  val fileProperty = ObjectProperty(s"$number.json")