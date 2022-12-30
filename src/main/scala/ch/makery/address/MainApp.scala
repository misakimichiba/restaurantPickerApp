package ch.makery.address

import ch.makery.address.model.{ChineseFood, IndianFood, MalayFood, Restaurant}
import ch.makery.address.util.Database
import ch.makery.address.view.{CantChooseDialogController, RestaurantEditDialogController}
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.Includes._
import scalafxml.core.{FXMLLoader, FXMLView, NoDependencyResolver}
import javafx.{scene => jfxs}
import scalafx.collections.ObservableBuffer
import scalafx.scene.image.Image
import scalafx.stage.{Modality, Stage}

object MainApp extends JFXApp { //initialize database
  Database.setupDB()

  // the data as an observable list of restaurants
  val restaurantData = new ObservableBuffer[Restaurant]()

  //assign all restaurants into restaurantData array
  restaurantData ++= Restaurant.getAllRestaurants

  // the data as an observable list of restaurant names
  val restaurantNamesData = new ObservableBuffer[String]()

  //assign all restaurant names into an array
  restaurantNamesData ++= Restaurant.getAllRestaurantNames

  // the data as an observable list of typeOfFoods
  val averagePricePerPersonData = new ObservableBuffer[Double]()

  //assign all person into an array
  averagePricePerPersonData ++= Restaurant.getAllAveragePricePerPersons

  // the data as an observable list of typeOfFoods
  val typeOfFoodsData = new ObservableBuffer[String]()

  //assign all person into an array
  typeOfFoodsData ++= Restaurant.getAllTypeOfFoods

  // the data as an observable list of typeOfFoods
  val locationsData = new ObservableBuffer[String]()

  //assign all person into an array
  locationsData ++= Restaurant.getAllLocations

  // the data as an observable list of chinese food
  val chineseFoodData = new ObservableBuffer[ChineseFood]()

  chineseFoodData += new ChineseFood("Dim Sum", "Dim Sum is a large range of small Chinese dishes")
  chineseFoodData += new ChineseFood("Wonton Noodles", "Wonton Noodles is a noodle dish with wontons")
  chineseFoodData += new ChineseFood("Chicken Rice", "Chicken rice is a dish of poached chicken and seasoned rice")

  // the data as an observable list of malay food
  val malayFoodData = new ObservableBuffer[MalayFood]()

  malayFoodData += new MalayFood("Nasi Lemak", "Nasi lemak consists of fragrant rice cooked in coconut milk and pandan leaf")
  malayFoodData += new MalayFood("Mi Goreng", "Mi Goreng is an Indonesian style of stir-fried noodle dish")
  malayFoodData += new MalayFood("Satay", "Satay is a dish of seasoned, skewered and grilled meat, served with a sauce")

  // the data as an observable list of indian food
  val indianFoodData = new ObservableBuffer[IndianFood]()

  indianFoodData += new IndianFood("Roti Canai", "Roti canai is a flatbread dish served with dal or other types of curry")
  indianFoodData += new IndianFood("Thosai", "Thosai is a thin pancake made from a fermented batter")
  indianFoodData += new IndianFood("Appam", "Appam is a pancake made with fermented rice batter and coconut milk")

  // transform path of RootLayout.fxml to URI for resource location.
  val rootResource = getClass.getResource("view/RootLayout.fxml")
  // initialize the loader object.
  val loader = new FXMLLoader(rootResource, NoDependencyResolver)
  // Load root layout from fxml file.
  loader.load();
  // retrieve the root component BorderPane from the FXML
  val roots = loader.getRoot[jfxs.layout.BorderPane]
  // initialize stage
  stage = new PrimaryStage {
    title = "Cincai Lah - A Restaurant Picker App"
    scene = new Scene {
      root = roots
    }
    icons += new Image(getClass.getResourceAsStream("/images/restaurant.png"))
  }
  // actions for display starting page / main menu
  def showStartingPage() = {
    val resource = getClass.getResource("view/StartingPage.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }
  // actions for display help page
  def showHelpPage() = {
    val resource = getClass.getResource("view/HelpPage.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }
  // actions for display credits page
  def showCreditsPage() = {
    val resource = getClass.getResource("view/CreditsPage.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }
  // actions for display view page
  def showViewPage() = {
    val resource = getClass.getResource("view/ViewPage.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }
  // actions for display edit page
  def showEditPage() = {
    val resource = getClass.getResource("view/EditPage.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }
  // actions for display mini game page
  def showMiniGamePage() = {
    val resource = getClass.getResource("view/MiniGame.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }
  // actions for display mini game start page
  def showMiniGameStartPage() = {
    val resource = getClass.getResource("view/MiniGameStart.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }
  // actions for display cant choose page
  def showCantChoosePage() = {
    val resource = getClass.getResource("view/CantChoosePage.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }
  // actions for display food dictionary page
  def showFoodDictionaryPage() = {
    val resource = getClass.getResource("view/FoodDictionaryPage.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }
  // actions for display chinese food page
  def showChineseFoodPage() = {
    val resource = getClass.getResource("view/ChineseFoodPage.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }
  // actions for display malay food page
  def showMalayFoodPage() = {
    val resource = getClass.getResource("view/MalayFood.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }
  // actions for display indian food page
  def showIndianFoodPage() = {
    val resource = getClass.getResource("view/IndianFood.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }
  // actions for exit program
  def exit() = {
    stopApp()
    stage.close()
  }
  // actions for display cant choose dialog page
  def showCantChooseDialog() {
    val resource = getClass.getResourceAsStream("view/CantChooseDialog.fxml")
    val loader = new FXMLLoader(null, NoDependencyResolver)
    loader.load(resource);
    val roots2 = loader.getRoot[jfxs.Parent]
    val control = loader.getController[CantChooseDialogController#Controller]

    val dialog = new Stage() {
      initModality(Modality.APPLICATION_MODAL)
      initOwner(stage)
      scene = new Scene {
        root = roots2
      }
    }
    control.dialogStage = dialog
    dialog.showAndWait()
    control.okClicked
  }
  // actions for display edit restaurant dialog page
  def showRestaurantEditDialog(restaurant: Restaurant): Boolean = {
    val resource = getClass.getResourceAsStream("view/RestaurantEditDialog.fxml")
    val loader = new FXMLLoader(null, NoDependencyResolver)
    loader.load(resource);
    val roots2 = loader.getRoot[jfxs.Parent]
    val control = loader.getController[RestaurantEditDialogController#Controller]

    val dialog = new Stage() {
      initModality(Modality.APPLICATION_MODAL)
      initOwner(stage)
      scene = new Scene {
        root = roots2
      }
    }
    control.dialogStage = dialog
    control.restaurant = restaurant
    dialog.showAndWait()
    control.okClicked
  }


  // call to display starting page when program start
  showStartingPage()

}
