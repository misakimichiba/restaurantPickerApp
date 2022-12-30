package ch.makery.address.view

import ch.makery.address.MainApp
import ch.makery.address.model.{IndianFood}
import scalafx.event.ActionEvent
import scalafx.scene.control.{Label, TableColumn, TableView}
import scalafx.Includes._
import scalafxml.core.macros.sfxml

@sfxml
class IndianFoodController (

                            private val indianFoodTable: TableView[IndianFood],

                            private val nameColumn: TableColumn[IndianFood, String],

                            private val nameLabel: Label,

                            private val descriptionLabel: Label

                          ){
  // initialize Table View display contents model
  indianFoodTable.items = MainApp.indianFoodData
  // initialize columns's cell values
  nameColumn.cellValueFactory = {
    _.value.nameOfFood
  }

  def handleGoBackButton(action: ActionEvent) = {
    MainApp.showFoodDictionaryPage()
  }

  private def showIndianFoodDetails(indianFood: Option[IndianFood]) = {
    indianFood match {
      case Some(indianFood: IndianFood) =>
        // Fill the labels with info from the restaurant object.
        nameLabel.text <== indianFood.nameOfFood
        descriptionLabel.text <== indianFood.description

      case None =>
        // Restaurant is null, remove all the text.
        nameLabel.text.unbind()
        descriptionLabel.text.unbind()
        nameLabel.text = ""
        descriptionLabel.text = ""
    }
  }

  showIndianFoodDetails(None);

  indianFoodTable.selectionModel().selectedItem.onChange(
    (_, _, newValue) => showIndianFoodDetails(Option(newValue))
  )
}
