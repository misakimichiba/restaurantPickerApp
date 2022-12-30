package ch.makery.address.model

import scalafx.beans.property.{StringProperty}

abstract class Food(){
  val nameOfFood = new StringProperty()
  val description = new StringProperty()
}

