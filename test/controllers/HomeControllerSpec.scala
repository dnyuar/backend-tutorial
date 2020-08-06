package controllers

import akka.stream.Materializer
import models.{CarModel, InputModel, RequestModel}
import org.scalamock.scalatest.MockFactory
import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.libs.json.Json
import play.api.mvc.{AnyContentAsJson, AnyContentAsText}
import play.api.test._
import play.api.test.Helpers._
import services.{CarService, TestService}

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 *
 * For more information, see https://www.playframework.com/documentation/latest/ScalaTestingWithScalaTest
 */
class HomeControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting with MockFactory {

  val mockService: CarService = mock[CarService]


val controller = new HomeController(stubControllerComponents(),mockService)

  ".index" should {

    "return a response" when  {

      "a valid response is provided" which {

        mockService.descriptionModel _ expects InputModel("Peter") returning CarModel ("Audi","Blue",10)

         val validJson = Json.obj("name" -> "Peter")
        val request:  FakeRequest[AnyContentAsJson] = FakeRequest().withJsonBody(validJson)

        val response = controller.car()(request)

        "has a 200 status" in {
          status(response) mustBe OK
        }


      "has the correct json body" in {
        contentAsJson(response) mustBe Json.obj(
          "make" -> "Audi",
          "colour" -> "Blue",
          "age" -> 10
        )
      }

      }

    }

    "the provided body is not json" which {
      val request: FakeRequest[AnyContentAsText] = FakeRequest().withTextBody("not json")

      "returns a bad request" in {
        val response = controller.car()(request)
        status(response) mustBe BAD_REQUEST
      }

      "returns the correct error" in{
        val response = controller.car()(request)
        contentAsString(response) mustBe "Body not Json"
      }

    }

    "invalid Json is provided" which {
      val request: FakeRequest[AnyContentAsJson] = FakeRequest().withJsonBody(Json.obj("not a field" -> "some value"))

      "returns a bad request" in {
        val response = controller.car()(request)
        status(response) mustBe BAD_REQUEST
      }

      "returns correct error" in {
        val response = controller.car()(request)
        contentAsString(response) mustBe "Could not parse Json"
      }
    }
  }
}
