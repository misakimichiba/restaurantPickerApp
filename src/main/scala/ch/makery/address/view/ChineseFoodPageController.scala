package ch.makery.address.view

import ch.makery.address.MainApp
import ch.makery.address.model.{ChineseFood}
import scalafx.event.ActionEvent
import scalafx.scene.control.{Label, TableColumn, TableView}
import scalafx.Includes._
import scalafxml.core.macros.sfxml

@sfxml
class ChineseFoodPageController (

                                  private val chineseFoodTable: TableView[ChineseFood],

                                  private val nameColumn: TableColumn[ChineseFood, String],

                                  private val nameLabel: Label,

                                  private val descriptionLabel: Label

                                ){
  // initialize Table View display contents model
  chineseFoodTable.items = MainApp.chineseFoodData
  // initialize columns's cell values
  nameColumn.cellValueFactory = {
    _.value.nameOfFood
  }

  def handleGoBackButton(action: ActionEvent) = {
    MainApp.showFoodDictionaryPage()
  }

  private def showChineseFoodDetails(chineseFood: Option[ChineseFood]) = {
    chineseFood match {
      case Some(chineseFood: ChineseFood) =>
        // Fill the labels with info from the restaurant object.
        nameLabel.text <== chineseFood.nameOfFood
        descriptionLabel.text <== chineseFood.description

      case None =>
        // Restaurant is null, remove all the text.
        nameLabel.text.unbind()
        descriptionLabel.text.unbind()
        nameLabel.text = ""
        descriptionLabel.text = ""
    }
  }

  showChineseFoodDetails(None);

  chineseFoodTable.selectionModel().selectedItem.onChange(
    (_, _, newValue) => showChineseFoodDetails(Option(newValue))
  )
}
