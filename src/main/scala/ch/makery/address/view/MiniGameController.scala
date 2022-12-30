package ch.makery.address.view

import ch.makery.address.MainApp
import scalafx.event.ActionEvent
import scalafxml.core.macros.sfxml

@sfxml
class MiniGameController {
  def handleGoBackToStartButton(action: ActionEvent) = {
    MainApp.showStartingPage()
  }

  def handleGoMiniGameStartButton(action: ActionEvent) = {
    MainApp.showMiniGameStartPage()
  }
}
