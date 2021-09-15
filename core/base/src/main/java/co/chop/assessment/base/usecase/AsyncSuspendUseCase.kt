package co.chop.assessment.base.usecase

interface AsyncSuspendUseCase<RQ, RS> {
   suspend fun executeAsync(rq: RQ): RS
}