package objektwerks

import com.typesafe.scalalogging.LazyLogging

import scalafx.application.JFXApp3
import scalafx.collections.ObservableBuffer
import scalafx.scene.image.Image

object App extends JFXApp3 with LazyLogging:
  logger.info("Starting app ...")

  override def start(): Unit =
    stage = new JFXApp3.PrimaryStage:
      scene = View.scene
      title = "Ciphers"
      minWidth = View.width
      minHeight = View.height
      icons.add( new Image( Image.getClass.getResourceAsStream("/cipher.png") ) )
    stage.show()