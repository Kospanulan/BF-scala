trait Validator[T] {
  def validate(t: T): Option[ApiError]
}

object CreateEsepValidator extends Validator[CreateEsep] {
  def validate(createEsep: CreateEsep): Option[ApiError] = {
    if (createEsep.esep.isEmpty) Some(ApiError.emptyEsepField)
    else None

    if (createEsep.solved) Some(ApiError.alreadySolved)
    else None
  }
}