import akka.actor.typed.ActorSystem
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.{Directives, Route}

import scala.concurrent.Future


import scala.concurrent.ExecutionContext

trait Router {
  def route:Route
}

class MyRouter(esepRepository: EsepRepository)(implicit system: ActorSystem[_], ex:ExecutionContext) extends Router with  Directives {
  import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
  import io.circe.generic.auto._

  override def route = concat(
    path("calculate"){
      pathEndOrSingleSlash {
        get {
          complete(esepRepository.getAnswer())
        }
      }
    }
  )
}
