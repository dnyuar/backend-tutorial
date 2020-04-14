package models

import play.api.libs.json.{Json, OWrites, Reads}

case class CarModel(
                   make: String,
                   colour: String,
                   age: Int
                   )

object CarModel{
  implicit val write: OWrites[CarModel] = Json.writes[CarModel]
}
