import scala.concurrent.Future

trait EsepRepository {
  def getAll(): Future[Seq[Esep]]

  def getSolved(): Future[Seq[Esep]]

  def setAnswer()

  def getAnswer(): Vector[String]

}