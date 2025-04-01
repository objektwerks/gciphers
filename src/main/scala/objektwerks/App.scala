package objektwerks

import com.typesafe.scalalogging.LazyLogging

import java.awt.{Taskbar, Toolkit}
import java.awt.Taskbar.Feature

import scalafx.application.JFXApp3
import scalafx.scene.image.Image

object App extends JFXApp3 with LazyLogging:
  logger.info("Starting app ...")

  override def start(): Unit =
    stage = new JFXApp3.PrimaryStage:
      scene = View.scene
      title = "Ciphers"
      minWidth = View.width
      minHeight = View.height
      icons += Image( Image.getClass.getResourceAsStream("/cipher.png") )

    if Taskbar.isTaskbarSupported() then
      val taskbar = Taskbar.getTaskbar()
      if taskbar.isSupported(Feature.ICON_IMAGE) then
        val defaultToolkit = Toolkit.getDefaultToolkit()
        val appIcon = defaultToolkit.getImage(getClass().getResource("/cipher.png"))
        taskbar.setIconImage(appIcon)
    
    stage.show()