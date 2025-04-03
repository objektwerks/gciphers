package objektwerks

final case class CipherWords(cipher: Cipher,
                             words: List[String]) derives CanEqual