package models

import play.api.libs.json.{Json, OWrites, Reads}

case class TestModel(
                    name: String,
                    age: Int
                    )

object TestModel{
  implicit val write: OWrites[TestModel] = Json.writes[TestModel]
  implicit val reads: Reads[TestModel] = Json.reads[TestModel]
}