package models

import play.api.libs.json.{Json, Reads}

case class RequestModel(
                       name:String
                       )
object RequestModel {
  implicit val reads: Reads[RequestModel] = Json.reads[RequestModel]
}
