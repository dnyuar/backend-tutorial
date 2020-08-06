package models

import play.api.libs.json.{Json, OWrites}

case class ResponseModel (
                         make:String,
                         colour:String,
                         age:Int
                         )

object ResponseModel  {
  implicit val write: OWrites[ResponseModel] = Json.writes[ResponseModel]
}