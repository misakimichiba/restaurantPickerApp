package ch.makery.address.view

import ch.makery.address.MainApp
import scalafxml.core.macros.sfxml
import scalafx.event.ActionEvent

@sfxml
class CreditsPageController {
  def handleGoToStartingPageButton(action: ActionEvent) = {
    MainApp.showStartingPage()
  }
}
