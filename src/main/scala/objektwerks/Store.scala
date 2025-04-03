package objektwerks

import com.typesafe.scalalogging.LazyLogging

import os.Path

import ox.*

import upickle.default.{read => readJson, write => writeJson}

final class Store