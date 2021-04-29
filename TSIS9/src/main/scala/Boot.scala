import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import org.slf4j.{Logger, LoggerFactory}

import scala.concurrent.ExecutionContext
import scala.io.StdIn.readLine


object Boot extends App {

  implicit val log: Logger = LoggerFactory.getLogger(getClass)

  val rootBehavior = Behaviors.setup[Nothing] { context =>

    implicit val ec = context.executionContext
    implicit val sys = context.system

    println("Write the math assignment as \"x + y + z ={Enter}\":\n")
    var esep1: String = readLine()

    val mockTodos:Seq[Esep] = Seq(
      Esep(esep1)
    )

    val esepter = new InMemoryEsepRepository(mockTodos)
    esepter.setAnswer()
    val router = new MyRouter(esepter)

    MyServer.startHttpServer(router.route)
    Behaviors.empty
  }
  val system = ActorSystem[Nothing](rootBehavior, "HelloAkkaHttpServer")
}
