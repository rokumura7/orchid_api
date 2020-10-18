package controllers

import aws.OrchidS3
import javax.inject.{Inject, Singleton}
import play.api.libs.Files
import play.api.libs.Files.TemporaryFile.temporaryFileToFile
import play.api.mvc.{AbstractController, Action, ControllerComponents, MultipartFormData}

@Singleton
class KeywordController @Inject()(cc: ControllerComponents)
  extends AbstractController(cc) {

  def upload(): Action[MultipartFormData[Files.TemporaryFile]] = Action(parse.multipartFormData) { req =>
    req.body.file("file").map { tmp =>
      val file = temporaryFileToFile(tmp.ref)
      OrchidS3.put("test", file)
      Ok
    }.getOrElse {
      BadRequest
    }
  }

}
