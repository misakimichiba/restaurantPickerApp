package ch.makery.address.view

import ch.makery.address.MainApp
import scalafxml.core.macros.sfxml
import scalafx.event.ActionEvent

@sfxml
class RootLayoutController {
  def handleHelpButton(action: ActionEvent) = {
    MainApp.showHelpPage()
  }

  def handleCreditsButton(action: ActionEvent) = {
    MainApp.showCreditsPage()
  }

  def handleExitButton(action: ActionEvent) = {
    MainApp.exit()
  }
}
