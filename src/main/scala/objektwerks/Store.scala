package objektwerks

import com.typesafe.scalalogging.LazyLogging

import ox.*

import scalafx.application.Platform

import upickle.default.{read => readJson, write => writeJson}

final class Store extends LazyLogging:
  val ciphersStorePath = os.home / ".ciphers" / "store"

  private def assertNotInFxThread: Unit = assert( !Platform.isFxApplicationThread, "Store operation called on Fx thread!" )

  os.makeDir.all( ciphersStorePath )
  logger.info("Initialized store.")

  def listCipherTexts: List[CipherTexts] =
    supervised:
      assertNotInFxThread
      logger.info(s"List cipher texts.")
      os.list(ciphersStorePath)
        .filter { path => path.baseName.nonEmpty }
        .map { path => readCipherTexts(s"${path.baseName}.json") }
        .toList

  def readCipherTexts(file: String): CipherTexts =
    supervised:
      assertNotInFxThread
      val cipherTextsAsJson = os.read(ciphersStorePath / file)
      logger.info(s"Read ciper texts: $file")
      readJson[CipherTexts](cipherTextsAsJson)

  def writeCipherTexts(cipherTexts: CipherTexts): Unit =
    supervised:
      assertNotInFxThread
      val cipherTextsAsJson = writeJson(cipherTexts)
      os.write.over(ciphersStorePath / cipherTexts.fileProperty.value, cipherTextsAsJson)
      logger.info(s"Write cipher texts: ${cipherTexts.cipher.getClass.getSimpleName}")