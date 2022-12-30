package ch.makery.address.view

import ch.makery.address.model.Restaurant
import scalafx.scene.control.{Alert, TextField}
import scalafxml.core.macros.sfxml
import scalafx.stage.Stage
import scalafx.event.ActionEvent
import java.lang.Double.parseDouble

@sfxml
class RestaurantEditDialogController (

                                   private val  nameField : TextField,
                                   private val   averagePricePerPersonField : TextField,
                                   private val     typeOfFoodField : TextField,
                                   private val locationField : TextField,
                                   private val       setLunchAvailableField : TextField

                                 ){
  var         dialogStage : Stage  = null
  private var _restaurant     : Restaurant = null
  var         okClicked            = false

  def restaurant = _restaurant
  def restaurant_=(x : Restaurant) {
    _restaurant = x

    nameField.text = _restaurant.name.value
    averagePricePerPersonField.text  = _restaurant.averagePricePerPerson.value.toString
    typeOfFoodField.text    = _restaurant.typeOfFood.value
    locationField.text= _restaurant.location.value
    setLunchAvailableField.text      = _restaurant.setLunchAvailability.value
  }

  def handleOK(action :ActionEvent){

    if (isInputValid()) {
      _restaurant.name <== nameField.text
      _restaurant.averagePricePerPerson.value  = averagePricePerPersonField.getText().toDouble
      _restaurant.typeOfFood    <== typeOfFoodField.text
      _restaurant.location      <== locationField.text
      _restaurant.setLunchAvailability <== setLunchAvailableField.text

      okClicked = true;
      dialogStage.close()
    }
  }

  def handleCancel(action :ActionEvent) {
    dialogStage.close();
  }
  def nullChecking (x : String) = x == null || x.length == 0

  def isInputValid() : Boolean = {
    var errorMessage = ""

    if (nullChecking(nameField.text.value))
      errorMessage += "No valid name!\n"
    if (nullChecking(averagePricePerPersonField.text.value))
      errorMessage += "No average price per person!\n"
    else {
      try {
        parseDouble(averagePricePerPersonField.getText());
      } catch {
        case e : NumberFormatException =>
          errorMessage += "No valid average price per person (must be a number and have two decimals eg: 10.00)!\n"
      }
    }
    if (nullChecking(typeOfFoodField.text.value))
      errorMessage += "No type of food!\n"
    if (nullChecking(locationField.text.value))
      errorMessage += "No valid location!\n"
    if (nullChecking(setLunchAvailableField.text.value))
      errorMessage += "No value for set lunch availability!\n"
    else {
      if (setLunchAvailableField.text.value != "No" && setLunchAvailableField.text.value != "Yes") {
        errorMessage += "Please put Yes or No for set lunch availability\n";
      }
    }

    if (errorMessage.length() == 0) {
      return true;
    } else {
      // Show the error message.
      val alert = new Alert(Alert.AlertType.Error){
        initOwner(dialogStage)
        title = "Invalid Fields"
        headerText = "Please correct invalid fields"
        contentText = errorMessage
      }.showAndWait()

      return false;
    }
  }
}
