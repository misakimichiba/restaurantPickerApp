package ch.makery.address.model

import scalafx.beans.property.{StringProperty}
import ch.makery.address.model.Food

class IndianFood (foodNameS : String, descriptionS : String ) extends Food (){
  override val nameOfFood = new StringProperty(foodNameS)
  override val description = new StringProperty(descriptionS)
}
