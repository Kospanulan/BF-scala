import scala.io.StdIn.readLine
import scala.util.control.Breaks._

object Calculator extends App{

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

  def isAllDigits(x: String) = x forall Character.isDigit

  def getResult(esep_elems: List[String]): Unit ={
    breakable {
      for (elem <- esep_elems) {
        if (elem == "=") {
          print(s"result is $result")
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
  }

  def singleLine() {
    print("Write the math assignment as \"x + y + z ={Enter}\":\n")
    var esep: String = readLine()
    val esep_elems: List[String] = esep.split(" ").toList
    getResult(esep_elems)
  }

  def multiLine() {
    print("Write the math assignment as \"{Num}{Enter} {Operation}{Enter} {Num}{Enter} {=}{Enter}\":\n")
    var esep_elems: List[String] = List()
    var input = ""
    while(input != "="){
      input = readLine("Num: ")
      while(!isAllDigits(input)) {
        input = readLine("There is must be number!\nNum: ")
      }
      esep_elems = esep_elems :+ input

      input = readLine("Op: ")
      while(!op.contains(input)) {
        input = readLine("There is must be an operation[+, -, *, /, =]!\nOp: ")
      }
      esep_elems = esep_elems :+ input
    }

    getResult(esep_elems)
  }


  val op = List("+", "-", "*", "/", "=")
  var result = 0
  var cur_op = ""

  val choice: Int = readLine("Menu:\n1. Single line\n2. Multiline input\nYour choice as number: ").toInt

  choice match {
    case 1 => singleLine()
    case 2 => multiLine()
  }
}