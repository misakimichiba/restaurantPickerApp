package ch.makery.address.view
import ch.makery.address.model.Restaurant
import ch.makery.address.MainApp
import scalafx.scene.control.{Alert, TableView, TableColumn, Label}
import scalafxml.core.macros.sfxml
import scalafx.Includes._
import scalafx.event.ActionEvent
import scalafx.scene.control.Alert.AlertType

@sfxml
class EditPageController(

                                private val restaurantTable : TableView[Restaurant],

                                private val nameColumn : TableColumn[Restaurant, String],

                                private val nameLabel : Label,

                                private val averagePricePerPersonLabel : Label,

                                private val typeOfFoodLabel : Label,

                                private val locationLabel : Label,

                                private val setLunchAvailabilityLabel :  Label

                              ) {
  // initialize Table View display contents model
  restaurantTable.items = MainApp.restaurantData
  // initialize columns's cell values
  nameColumn.cellValueFactory = {_.value.name}

  def handleStartingPageButton(action: ActionEvent) = {
    MainApp.showStartingPage()
  }

  private def showRestaurantDetails(restaurant: Option[Restaurant]) = {
    restaurant match {
      case Some(restaurant) =>
        // Fill the labels with info from the restaurant object.
        nameLabel.text <== restaurant.name
        averagePricePerPersonLabel.text = restaurant.averagePricePerPerson.value.toString
        typeOfFoodLabel.text <== restaurant.typeOfFood
        locationLabel.text <== restaurant.location
        setLunchAvailabilityLabel.text <== restaurant.setLunchAvailability

      case None =>
        // Restaurant is null, remove all the text.
        nameLabel.text.unbind()
        typeOfFoodLabel.text.unbind()
        locationLabel.text.unbind()
        setLunchAvailabilityLabel.text.unbind()
        nameLabel.text = ""
        averagePricePerPersonLabel.text = ""
        typeOfFoodLabel.text = ""
        locationLabel.text = ""
        setLunchAvailabilityLabel.text = ""
    }
  }

  showRestaurantDetails(None);

  restaurantTable.selectionModel().selectedItem.onChange(
    (_, _, newValue) => showRestaurantDetails(Option(newValue))
  )

  def handleNewRestaurant(action: ActionEvent) = {
    val restaurant = new Restaurant("")
    val okClicked = MainApp.showRestaurantEditDialog(restaurant);
    if (okClicked) {
      MainApp.restaurantData += restaurant
      MainApp.restaurantNamesData += restaurant.name.value
      MainApp.locationsData += restaurant.location.value
      MainApp.typeOfFoodsData += restaurant.typeOfFood.value
      restaurant.save()
    }
  }

  def handleEditRestaurant(action: ActionEvent) = {
    val selectedRestaurant = restaurantTable.selectionModel().selectedItem.value
    if (selectedRestaurant != null) {
      val okClicked = MainApp.showRestaurantEditDialog(selectedRestaurant)

      if (okClicked) {
        showRestaurantDetails(Some(selectedRestaurant))
        selectedRestaurant.save()
      }
    } else {
      // Nothing selected.
      val alert = new Alert(Alert.AlertType.Warning) {
        initOwner(MainApp.stage)
        title = "No Selection"
        headerText = "No Restaurant Selected"
        contentText = "Please select a restaurant in the table."
      }.showAndWait()
    }
  }


  def handleDeleteRestaurant(action: ActionEvent) = {
    val selectedIndex = restaurantTable.selectionModel().selectedIndex.value
    if (selectedIndex >= 0) {
      //restaurantTable.items().remove(selectedIndex);
      MainApp.restaurantData.remove(selectedIndex).delete()
      MainApp.restaurantNamesData.remove(selectedIndex)
      MainApp.typeOfFoodsData.remove(selectedIndex)
      MainApp.locationsData.remove(selectedIndex)
    } else {
      // Nothing selected.
      val alert = new Alert(AlertType.Warning) {
        initOwner(MainApp.stage)
        title = "No Selection"
        headerText = "No Restaurant Selected"
        contentText = "Please select a restaurant in the table."
      }.showAndWait()
    }
  }

}
