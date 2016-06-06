package filters

import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.mvc.Results._
import play.api.mvc.{Filter, RequestHeader, Result}

import scala.concurrent.Future
import scala.util.Random

class MyFilter extends Filter {
  override def apply(f: RequestHeader => Future[Result])(rh: RequestHeader): Future[Result] = {
    f(rh).map { result =>
      if (Random.nextBoolean()) {
        Ok("You're lucky!")
      } else {
        result
      }
    }
  }
}
