package ch.makery.address.view

import ch.makery.address.MainApp
import ch.makery.address.model.{MalayFood}
import scalafx.event.ActionEvent
import scalafx.scene.control.{Label, TableColumn, TableView}
import scalafx.Includes._
import scalafxml.core.macros.sfxml

@sfxml
class MalayFoodController (

                                  private val malayFoodTable: TableView[MalayFood],

                                  private val nameColumn: TableColumn[MalayFood, String],

                                  private val nameLabel: Label,

                                  private val descriptionLabel: Label

                                ){
  // initialize Table View display contents model
  malayFoodTable.items = MainApp.malayFoodData
  // initialize columns's cell values
  nameColumn.cellValueFactory = {
    _.value.nameOfFood
  }

  def handleGoBackButton(action: ActionEvent) = {
    MainApp.showFoodDictionaryPage()
  }

  private def showMalayFoodDetails(malayFood: Option[MalayFood]) = {
    malayFood match {
      case Some(malayFood: MalayFood) =>
        // Fill the labels with info from the restaurant object.
        nameLabel.text <== malayFood.nameOfFood
        descriptionLabel.text <== malayFood.description

      case None =>
        // Restaurant is null, remove all the text.
        nameLabel.text.unbind()
        descriptionLabel.text.unbind()
        nameLabel.text = ""
        descriptionLabel.text = ""
    }
  }

  showMalayFoodDetails(None);

  malayFoodTable.selectionModel().selectedItem.onChange(
    (_, _, newValue) => showMalayFoodDetails(Option(newValue))
  )
}