package objektwerks

import upickle.default.ReadWriter as JsonSupport

import scala.collection.mutable
import scalafx.beans.property.ObjectProperty

object Texts:
  given Ordering[Texts] = Ordering.by[Texts, Int](t => t.number)

final case class Texts(number: Int, values: mutable.Set[String]) derives CanEqual, JsonSupport:
  val numberProperty = ObjectProperty(number)
  val fileProperty = ObjectProperty(s"$number.json")
  def valuesToString(): ObjectProperty[String] = ObjectProperty( values.mkString(", ") )