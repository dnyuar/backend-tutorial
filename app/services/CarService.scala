package services

import models.{CarModel, InputModel, ResponseModel}

class CarService {

  def descriptionModel(inputModel: InputModel): CarModel = inputModel.name match {
    case "Peter" => CarModel("Audi", "Blue", 10)
    case "Deng" => CarModel("Mercedes", "Silver",2)
    case "Jess" => CarModel("BMW", "Black", 5)
    case _ => CarModel("Unknown","Unknown",0)


  }

}
