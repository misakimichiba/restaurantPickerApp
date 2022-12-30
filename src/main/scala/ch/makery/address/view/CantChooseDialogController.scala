package ch.makery.address.view

import ch.makery.address.MainApp
import scalafx.event.ActionEvent
import scalafx.scene.control.Label
import scalafx.stage.Stage
import scalafxml.core.macros.sfxml

import scala.util.Random

@sfxml
class CantChooseDialogController (
                                   private val  randomRestaurantNameLabel : Label
                                 ){
  var         randomRestaurant : String = ""
  var         dialogStage : Stage  = null
  var         okClicked            = false
  val         lines: Array[String] = MainApp.restaurantNamesData.toArray
  val random_index = Random.nextInt(lines.length)
  randomRestaurant = lines(random_index)
  randomRestaurantNameLabel.text = randomRestaurant

  def handleOK(action :ActionEvent){
      okClicked = true;
      dialogStage.close()
  }
}