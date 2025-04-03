package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class StoreTest extends AnyFunSuite with Matchers:
  test("store"):
    val store = Store()
    val cipherTexts = CipherTexts(Ordinal(1), Set("a"))
    store.writeCipherTexts(cipherTexts)
    store.readCipherTexts(cipherTexts.fileProperty.value) shouldBe cipherTexts
    store.listCipherTexts().length should be >= 1