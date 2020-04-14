package services

import models.TestModel

class TestService {

  def modifyModel(testModel: TestModel): TestModel = {
    TestModel(
      testModel.name * 2,
      testModel.age
    )
  }

}
