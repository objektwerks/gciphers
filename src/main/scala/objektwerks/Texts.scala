package objektwerks

import upickle.default.ReadWriter as JsonSupport

import scalafx.beans.property.ObjectProperty

final case class Texts(number: Int, texts: Set[String]) derives CanEqual, JsonSupport:
  val numberListedProperty = ObjectProperty(number)
  val textsProperty = ObjectProperty(texts)
  val fileProperty = ObjectProperty(s"$number.json")