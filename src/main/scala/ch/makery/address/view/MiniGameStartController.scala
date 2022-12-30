package ch.makery.address.view

import ch.makery.address.MainApp
import scalafx.scene.control.Label
import scalafx.event.ActionEvent
import scalafxml.core.macros.sfxml

@sfxml
class MiniGameStartController(
                             private val numOfRoundsLabel : Label,
                             private val numOfWinsLabel : Label,
                             private val winOrLoseLabel : Label,
                             private val opponentLabel : Label
                             ) {

  var numOfRounds: Int = 0
  var numOfWins: Int = 0
  var opponent : String = ""
  val r = new scala.util.Random
  var i : Int = 0

  def handleScissors(action: ActionEvent): Unit = {
    i = r.nextInt(3)
    i match {
      case 0 => opponent = "Scissors"
      case 1 => opponent = "Paper"
      case 2 => opponent = "Stone"
    }
    opponent match {
      case "Paper" => winOrLoseLabel.text = "You Won!";
        numOfWins += 1
      case "Scissors" => winOrLoseLabel.text = "You Tie!"
      case "Stone" => winOrLoseLabel.text = "You Lost!"
    }
    numOfRounds += 1
    opponentLabel.text = opponent
    numOfWinsLabel.text = numOfWins.toString
    numOfRoundsLabel.text = numOfRounds.toString
  }

  def handleStone(action: ActionEvent): Unit = {
    i = r.nextInt(3)
    i match {
      case 0 => opponent = "Scissors"
      case 1 => opponent = "Paper"
      case 2 => opponent = "Stone"
    }
    opponent match {
      case "Scissors" => winOrLoseLabel.text = "You Won!";
        numOfWins += 1
      case "Stone" => winOrLoseLabel.text = "You Tie!"
      case "Paper" => winOrLoseLabel.text = "You Lost!"
    }
    numOfRounds += 1
    opponentLabel.text = opponent
    numOfWinsLabel.text = numOfWins.toString
    numOfRoundsLabel.text = numOfRounds.toString
  }

  def handlePaper(action: ActionEvent): Unit = {
    i = r.nextInt(3)
    i match {
      case 0 => opponent = "Scissors"
      case 1 => opponent = "Paper"
      case 2 => opponent = "Stone"
    }
    opponent match {
      case "Stone" => winOrLoseLabel.text = "You Won!";
        numOfWins += 1
      case "Paper" => winOrLoseLabel.text = "You Tie!"
      case "Scissors" => winOrLoseLabel.text = "You Lost!"
    }
    numOfRounds += 1
    opponentLabel.text = opponent
    numOfWinsLabel.text = numOfWins.toString
    numOfRoundsLabel.text = numOfRounds.toString
  }

  def handleGoBackToStartPageAgainButton(action: ActionEvent) = {
    MainApp.showStartingPage()
  }
}
