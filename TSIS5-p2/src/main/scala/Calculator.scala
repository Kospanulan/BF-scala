import akka.actor.typed.{ActorRef, Behavior}
import akka.actor.typed.scaladsl.Behaviors

import scala.io.StdIn.readLine
import scala.util.control.Breaks._

object Calculator {

  def compute(a: Int, b: Int, op: String): Int = {
    if (op == "-") {
      return a - b
    }
    else if (op == "*") {
      return a * b
    }
    else if (op == "/") {
      return a / b
    }
    a + b
  }

  def getResult(esep_elems: List[String]): Int ={
    breakable {
      for (elem <- esep_elems) {
        if (elem == "=") {
//          print(s"result is $result")
          break
        }
        breakable {
          if (op.contains(elem)) {
            cur_op = elem
            break
          }
          result = compute(result, elem.toInt, cur_op)
        }
      }
    }
    result
  }

  def singleLine(esep: String) : Int = {
    val esep_elems: List[String] = esep.split(" ").toList
    getResult(esep_elems)
  }

  final case class Calculate(problem: String)

  val op = List("+", "-", "*", "/", "=")
  var result = 0
  var cur_op = ""

  def apply(): Behavior[Calculate] = Behaviors.setup { context =>
    val printer = context.spawn(Printer(), "printer")

    Behaviors.receiveMessage { message =>
      context.log.info("Our problem is: {}", message.problem)
      printer ! Printer.Print(singleLine(message.problem))
      Behaviors.same
    }
  }
}
