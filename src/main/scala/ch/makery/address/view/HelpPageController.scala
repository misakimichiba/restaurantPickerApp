package ch.makery.address.view

import ch.makery.address.MainApp
import scalafxml.core.macros.sfxml
import scalafx.event.ActionEvent

@sfxml
class HelpPageController {
  def handleReturnToStartingPageButton(action: ActionEvent) = {
    MainApp.showStartingPage()
  }
}