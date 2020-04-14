package services

import models.{CarModel, InputModel}

class CarService {

  def descriptionModel(inputModel: InputModel):CarModel = inputModel.name match
  {
    case "Peter" => CarModel("Audi","Blue",10)


  }

}
