package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import scala.collection.mutable

class StoreTest extends AnyFunSuite with Matchers:
  test("store"):
    val store = Store()
    val texts = Texts(1, mutable.Set("a"))
    store.writeTexts(texts)
    store.readTexts(texts.fileProperty.value) shouldBe texts
    store.listTexts().length should be >= 1