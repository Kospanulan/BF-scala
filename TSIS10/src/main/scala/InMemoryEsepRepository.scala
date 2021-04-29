import akka.actor.TypedActor.context
import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.scaladsl.adapter.ClassicActorContextOps

import scala.concurrent.{ExecutionContext, Future}

class InMemoryEsepRepository(initialTodos:Seq[Esep] = Seq.empty)(implicit ec:ExecutionContext) extends EsepRepository {

  private var esepter: Vector[Esep] = initialTodos.toVector

  private var solved = Vector[Esep]()

  var calc = Calculator

  override def getAll(): Future[Seq[Esep]] = Future.successful(esepter)

  override def getSolved(): Future[Seq[Esep]] = Future.successful(solved)

  override def setAnswer() = {
    for (problem <- esepter.filterNot(_.solved)){
      problem.answer = calc.singleLine(problem.esep)
      problem.solved = true
      solved = solved:+problem
      calc.result = 0
      calc.cur_op = ""
    }

  }

  override def getAnswer(): Vector[String] = {
    var res = Vector[String]()
    for (s <- solved){
      val line = s.esep + " " + s.answer
      res = res:+line
    }
    res
  }
   def setAnswer(problem: String): Int = {
     var res = calc.singleLine(problem)
     calc.result = 0
     calc.cur_op = ""
     res
  }

  override def create(createEsep: CreateEsep): Future[Esep] =
    Future.successful {
      val problem = Esep(
        esep = createEsep.esep,
        answer = setAnswer(createEsep.esep),
        solved = true
      )
      esepter = esepter :+ problem
      problem
    }

}
