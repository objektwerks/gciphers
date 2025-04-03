package objektwerks

import upickle.default.ReadWriter as JsonSupport

import scalafx.beans.property.ObjectProperty

final case class CipherTexts(cipher: Cipher,
                             texts: Set[String]) derives CanEqual, JsonSupport:
  val nameProperty = ObjectProperty(cipher.getClass.getSimpleName)
  val cipherProperty = ObjectProperty(cipher)
  val textsProperty = ObjectProperty(texts)
  val fileProperty = ObjectProperty(s"${cipher.value}.json")