package models

import play.api.libs.json.{Json, Reads}

case class InputModel (
                      name: String
                      )

object InputModel{
  implicit val read: Reads[InputModel] = Json.reads[InputModel]

}