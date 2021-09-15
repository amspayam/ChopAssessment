package co.chop.conversation.domain

import co.chop.assessment.base.usecase.AsyncSuspendUseCase
import co.chop.assessment.repository.ResultModel
import co.chop.assessment.repository.map
import co.chop.conversation.domain.model.ConversationModel


class SendMessageUseCase(
    private val repository: ConversationRepository
) : AsyncSuspendUseCase<ConversationModel, ResultModel<Int>> {

    override suspend fun executeAsync(rq: ConversationModel): ResultModel<Int> {
        return repository.addConversation(conversation = rq).map {
            it
        }
    }
}