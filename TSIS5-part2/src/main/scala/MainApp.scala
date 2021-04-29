import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.scaladsl.LoggerOps
import akka.actor.typed.{ActorRef, ActorSystem, Behavior}
import org.slf4j.LoggerFactory

import scala.io.StdIn.readLine

object MainApp extends App{
  implicit val logger = LoggerFactory.getLogger(getClass)

  val system: ActorSystem[Calculator.Calculate] =
    ActorSystem(Calculator(), "Calculator")


  println("Write the math assignment as \"x + y + z ={Enter}\":\n")
  var esep: String = readLine()

  system ! Calculator.Calculate(esep)
}
