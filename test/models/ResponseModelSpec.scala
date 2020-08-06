package models

import org.scalatestplus.play.PlaySpec
import play.api.libs.json.{JsObject, Json}


class ResponseModelSpec extends PlaySpec {

  val validJson: JsObject = Json.obj(
    "make" -> "Audi",
    "colour" -> "Blue",
    "age" -> 10,
  )
  val validModel = CarModel("Audi","Blue",10)


  "Response model" should {

    "correctly write to JSON" in {
      Json.toJson(validModel) mustBe validJson
    }
  }

}
