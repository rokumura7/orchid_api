package controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}

@Singleton
class HealthCheckController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {
  def h: Action[AnyContent] = Action(Ok)
}
