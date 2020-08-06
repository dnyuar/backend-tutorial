package services

import models.{CarModel, InputModel, RequestModel, ResponseModel}
import org.scalatestplus.play.PlaySpec

class CarServiceSpec extends PlaySpec{

  val service = new CarService()

  ".car" should {

    "return the correct model" when {

      "the input is Peter" in {
        val validResponse = CarModel("Audi","Blue",10)

        service.descriptionModel(InputModel("Peter")) mustBe validResponse
      }
      "the input is Deng" in {
        val validResponse = CarModel("Mercedes","Silver",2)

        service.descriptionModel(InputModel("Deng")) mustBe validResponse
      }
      "the input is Jess" in {
         val validResponse = CarModel("BMW","Black",5)

        service.descriptionModel(InputModel("Jess")) mustBe validResponse
      }

      "the input is Steve" in {
        val validResponse = CarModel("Unknown","Unknown",0)

        service.descriptionModel(InputModel("Steve")) mustBe validResponse
      }
    }
  }
}
