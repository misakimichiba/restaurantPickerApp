package ch.makery.address.view

import ch.makery.address.MainApp
import scalafx.event.ActionEvent
import scalafxml.core.macros.sfxml

@sfxml
class FoodDictionaryPageController {
  def handleGoBackButton(action: ActionEvent) = {
    MainApp.showStartingPage()
  }

  def handleChineseFoodButton(action: ActionEvent) = {
    MainApp.showChineseFoodPage()
  }

  def handleMalayFoodButton(action: ActionEvent) = {
    MainApp.showMalayFoodPage()
  }

  def handleIndianFoodButton(action: ActionEvent) = {
    MainApp.showIndianFoodPage()
  }
}
