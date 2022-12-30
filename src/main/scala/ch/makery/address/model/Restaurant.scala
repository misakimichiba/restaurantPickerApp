package ch.makery.address.model

import scalafx.beans.property.{DoubleProperty, StringProperty}
import ch.makery.address.util.Database
import scalikejdbc._

import scala.util.{Failure, Success, Try}

class Restaurant(val nameS: String) extends Database {
  def this() = this(null)

  var name = new StringProperty(nameS)
  var averagePricePerPerson = DoubleProperty(10.00)
  var typeOfFood = new StringProperty("food type")
  var location = new StringProperty("some city")
  var setLunchAvailability = new StringProperty("No")


  def save(): Try[Int] = {
    if (!(isExist)) {
      Try(DB autoCommit { implicit session =>
        sql"""
          insert into restaurant (name, averagePricePerPerson,
            typeOfFood, location, setLunchAvailability) values
            (${name.value}, ${averagePricePerPerson.value}, ${typeOfFood.value},
              ${location.value},${setLunchAvailability.value})
        """.update.apply()
      })
    } else {
      Try(DB autoCommit { implicit session =>
        sql"""
        update restaurant
        set
        name  = ${name.value} ,
        averagePricePerPerson   = ${averagePricePerPerson.value},
        typeOfFood     = ${typeOfFood.value},
        location = ${location.value},
        setLunchAvailability       = ${setLunchAvailability.value}
         where name = ${name.value}
        """.update.apply()
      })
    }

  }

  def delete(): Try[Int] = {
    if (isExist) {
      Try(DB autoCommit { implicit session =>
        sql"""
        delete from restaurant where
          name = ${name.value}
        """.update.apply()
      })
    } else
      throw new Exception("Restaurant does not exist in Database")
  }

  def isExist: Boolean = {
    DB readOnly { implicit session =>
      sql"""
        select * from restaurant where
        name = ${name.value}
      """.map(rs => rs.string("name")).single.apply()
    } match {
      case Some(x) => true
      case None => false
    }

  }
}

object Restaurant extends Database {
  def apply(
             nameS: String,
             averagePricePerPersonD: Double,
             typeOfFoodS: String,
             locationS: String,
             setLunchAvailabilityS: String
           ): Restaurant = {

    new Restaurant(nameS) {
      averagePricePerPerson.value = averagePricePerPersonD
      typeOfFood.value = typeOfFoodS
      location.value = locationS
      setLunchAvailability.value = setLunchAvailabilityS
    }

  }

  def initializeTable() = {
    DB autoCommit { implicit session =>
      sql"""
      create table restaurant (
        id int not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
        name varchar(200),
        averagePricePerPerson double,
        typeOfFood varchar(200),
        location varchar(200),
        setLunchAvailability varchar(5)
      )
      """.execute.apply()
    }
  }

  def getAllRestaurants: List[Restaurant] = {
    DB readOnly { implicit session =>
      sql"select * from restaurant".map(rs => Restaurant(rs.string("name"),
        rs.double("averagePricePerPerson"), rs.string("typeOfFood"),
        rs.string("location"), rs.string("setLunchAvailability"))).list.apply()
    }
  }

  def getAllRestaurantNames: List[String] = {
    DB readOnly { implicit session =>
      sql"select name from restaurant".map(rs => rs.string("name")).list.apply()
    }
  }

  def getAllAveragePricePerPersons: List[Double] = {
    DB readOnly { implicit session =>
      sql"select averagePricePerPerson from restaurant".map(rs => rs.double("averagePricePerPerson")).list.apply()
    }
  }

  def getAllTypeOfFoods : List[String] = {
    DB readOnly { implicit session =>
      sql"select typeOfFood from restaurant".map(rs => rs.string("typeOfFood")).list.apply()
    }
  }

  def getAllLocations: List[String] = {
    DB readOnly { implicit session =>
      sql"select location from restaurant".map(rs => rs.string("location")).list.apply()
    }
  }
}
