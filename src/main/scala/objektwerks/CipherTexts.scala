package objektwerks

final case class CipherTexts(cipher: Cipher,
                             texts: Set[String]) derives CanEqual