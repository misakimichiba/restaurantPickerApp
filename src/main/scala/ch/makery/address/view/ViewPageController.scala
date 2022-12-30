package ch.makery.address.view

import ch.makery.address.MainApp
import ch.makery.address.model.Restaurant
import scalafx.event.ActionEvent
import scalafx.scene.control.{TableColumn, TableView}
import scalafxml.core.macros.sfxml

@sfxml
class ViewPageController (

                           private val restaurantTable : TableView[Restaurant],

                           private val nameColumn : TableColumn[Restaurant, String],

                           private val typeOfFoodColumn : TableColumn[Restaurant, String],

                           private val locationColumn : TableColumn[Restaurant, String],

                           private val setLunchAvailabilityColumn : TableColumn[Restaurant, String]

                         ) {
  // initialize Table View display contents model
  restaurantTable.items = MainApp.restaurantData
  // initialize columns's cell values
  nameColumn.cellValueFactory = {
    _.value.name
  }
  typeOfFoodColumn.cellValueFactory = {
    _.value.typeOfFood
  }
  locationColumn.cellValueFactory = {
    _.value.location
  }
  setLunchAvailabilityColumn.cellValueFactory = {
    _.value.setLunchAvailability
  }

  def handleGoBackButton(action: ActionEvent) = {
    MainApp.showStartingPage()
  }
}