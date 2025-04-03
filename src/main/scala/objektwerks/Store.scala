package objektwerks

import com.typesafe.scalalogging.LazyLogging

import os.Path

import ox.*

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
        .map { path => readRecipe(s"${path.baseName}.json") }
        .toList