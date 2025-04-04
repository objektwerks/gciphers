package objektwerks

import upickle.default.ReadWriter as JsonSupport

import scala.collection.mutable
import scalafx.beans.property.ObjectProperty

final case class Texts(number: Int, values: mutable.Set[String]) derives CanEqual, JsonSupport:
  val numberProperty = ObjectProperty(number)
  def valuesToString(): ObjectProperty[String] = ObjectProperty(values.mkString(", "))
  val fileProperty = ObjectProperty(s"$number.json")