import Calculator.{Calculate, singleLine}
import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors

object Printer {

  final case class Print(result: Int)

  def apply(): Behavior[Print] = Behaviors.receive { (context, message) =>
    context.log.info("Result is: {}" , message.result)
    Behaviors.same
  }
}
