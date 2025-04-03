package objektwerks

final case class NumberCipherWords(number: Int,
                                   cipher: String,
                                   words: List[String]) derives CanEqual
