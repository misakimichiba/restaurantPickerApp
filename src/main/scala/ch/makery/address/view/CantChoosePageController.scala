package ch.makery.address.view

import ch.makery.address.MainApp
import scalafx.event.ActionEvent
import scalafxml.core.macros.sfxml

@sfxml
class CantChoosePageController {
  def handleReturnBackButton(action: ActionEvent) = {
    MainApp.showStartingPage()
  }

  def handleRandomClicked(action: ActionEvent) = {
    val okClicked = MainApp.showCantChooseDialog();
  }
}
