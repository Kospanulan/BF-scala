import akka.http.scaladsl.model.{StatusCode, StatusCodes}

final case class ApiError private(statusCode: StatusCode, message: String)

object ApiError {
  private def apply(statusCode: StatusCode, message: String): ApiError = new ApiError(statusCode, message)

  val generic: ApiError = new ApiError(StatusCodes.InternalServerError, "Unknown error.")
  val emptyEsepField: ApiError = new ApiError(StatusCodes.BadRequest, message = "Empty esep field.")
  val alreadySolved: ApiError = new ApiError(StatusCodes.BadRequest, message = "Problem mark as solved, but it isn't.")

}