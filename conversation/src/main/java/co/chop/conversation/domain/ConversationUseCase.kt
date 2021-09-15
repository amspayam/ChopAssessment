package co.chop.conversation.domain

import co.chop.assessment.base.usecase.AsyncSuspendUseCase
import co.chop.assessment.repository.ResultModel
import co.chop.assessment.repository.map
import co.chop.conversation.domain.model.ConversationModel


class ConversationUseCase(
    private val repository: ConversationRepository
) : AsyncSuspendUseCase<Int, ResultModel<List<ConversationModel>>> {

    override suspend fun executeAsync(rq: Int): ResultModel<List<ConversationModel>> {
        return repository.getConversation(idUser = rq).map {
            it?.map { response ->
                ConversationModel(
                    userId = response.userId,
                    message = response.message,
                    type = response.type
                )
            } ?: listOf()
        }
    }
}