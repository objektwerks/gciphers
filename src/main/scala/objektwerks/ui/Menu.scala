package objektwerks.ui

import scalafx.Includes._
import scalafx.application.Platform
import scalafx.event.ActionEvent
import scalafx.scene.control.{Alert, Menu => MenuRoot, MenuBar, MenuItem, SeparatorMenuItem, TextArea}
import scalafx.scene.control.Alert.AlertType
import scalafx.scene.layout.GridPane

final class Menu(context: Context) extends MenuBar:
  val textAreaAbout = new TextArea():
    editable = false
    wrapText = true
    text = "Todo: Text Area"

  val gridPaneAbout = new GridPane():
    prefHeight = 120
    prefWidth = 200
  gridPaneAbout.add(textAreaAbout, 0, 0)

  val menuItemAbout = new MenuItem:
    text = "About"
    onAction = (_: ActionEvent) =>
      new Alert(AlertType.Information):
        initOwner(App.stage)
        title = context.windowTitle
        headerText = "Todo: Header Text"
        dialogPane().content = gridPaneAbout
      .showAndWait()

  val menuItemExit = new MenuItem:
    text = "Exit"
    onAction = (_: ActionEvent) => Platform.exit()

  val menuRoot = new MenuRoot():
    text = "Menu"
    items = List(menuItemAbout, SeparatorMenuItem(), menuItemExit)

  menus = List(menuRoot)