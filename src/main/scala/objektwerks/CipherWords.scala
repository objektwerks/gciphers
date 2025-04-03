package objektwerks

final case class CipherWords(cipher: Cipher,
                             words: Set[String]) derives CanEqual