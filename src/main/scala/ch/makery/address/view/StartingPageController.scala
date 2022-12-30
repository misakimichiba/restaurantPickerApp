package ch.makery.address.view

import ch.makery.address.MainApp
import scalafxml.core.macros.sfxml
import scalafx.event.ActionEvent

@sfxml
class StartingPageController {
  def handleEditButton(action: ActionEvent) = {
    MainApp.showEditPage()
  }

  def handleShowViewButton(action: ActionEvent) = {
    MainApp.showViewPage()
  }

  def handleMiniGameButton(action: ActionEvent) = {
    MainApp.showMiniGamePage()
  }

  def handleCantChooseButton(action: ActionEvent) = {
    MainApp.showCantChoosePage()
  }

  def handleFoodDictionaryButton(action: ActionEvent) = {
    MainApp.showFoodDictionaryPage()
  }
}