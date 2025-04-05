package objektwerks

import com.typesafe.scalalogging.LazyLogging

import ox.*

import scalafx.application.Platform

import upickle.default.{read => readJson, write => writeJson}

final class Store extends LazyLogging:
  val storePath = os.home / ".gciphers" / "store"

  private def assertNotInFxThread: Unit =
    assert( !Platform.isFxApplicationThread, "Store operation called on Fx thread!" )

  os.makeDir.all(storePath)
  logger.info("Initialized store.")

  def listTexts(): List[Texts] =
    supervised:
      assertNotInFxThread
      logger.info(s"List cipher texts.")
      os.list(storePath)
        .filter { path => path.baseName.nonEmpty }
        .map { path => readTexts(s"${path.baseName}.json") }
        .toList

  def readTexts(file: String): Texts =
    supervised:
      assertNotInFxThread
      val textsAsJson = os.read(storePath / file)
      logger.info(s"Read ciper texts: $file")
      readJson[Texts](textsAsJson)

  def writeTexts(texts: Texts): Unit =
    supervised:
      assertNotInFxThread
      val cipherTextsAsJson = writeJson(texts)
      os.write.over(storePath / texts.fileProperty.value, cipherTextsAsJson)
      logger.info(s"Write cipher texts: $texts")