package controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}

@Singleton
class HealthCheckController @Inject()(cc: ControllerComponents)
  extends AbstractController(cc) {

  def h: Action[AnyContent] = Action(Ok)

}
