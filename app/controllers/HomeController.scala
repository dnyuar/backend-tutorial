package controllers

import javax.inject._
import models.{CarModel, InputModel, TestModel}
import play.api.libs.json.Json
import play.api.mvc._
import services.TestService
import services.CarService


/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(
                                val controllerComponents: ControllerComponents,
                              val testService: TestService,
                                val carService: CarService
                              ) extends BaseController {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    val bodyAsJSON = request.body.asJson
    val bodyAsModel = bodyAsJSON.get.asOpt[TestModel].get
    println(bodyAsModel)
    val transformedModel = testService.modifyModel(bodyAsModel)
    Ok(Json.toJson(transformedModel))
  }

  def car() = Action { implicit request: Request[AnyContent] =>
    val bodyAsJson = request.body.asJson
    val bodyAsModel = bodyAsJson.get.asOpt[InputModel].get
    println(bodyAsModel)
    val findCarOfOwner = carService.descriptionModel(bodyAsModel)
    Ok(Json.toJson(findCarOfOwner))

  }
}
