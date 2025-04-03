package objektwerks

import upickle.default.ReadWriter as JsonSupport

import scalafx.beans.property.ObjectProperty

final case class CipherTexts(cipher: Cipher,
                             texts: Set[String]) derives CanEqual, JsonSupport:
  val cipherProperty = ObjectProperty(cipher)
  val textsProperty = ObjectProperty(texts)