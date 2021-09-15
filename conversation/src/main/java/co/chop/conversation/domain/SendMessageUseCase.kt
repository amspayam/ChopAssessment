package co.chop.conversation.domain

import co.chop.conversation.domain.model.ConversationModel
import com.combyne.core.usecase.AsyncSuspendUseCase
import com.combyne.repository.ResultModel
import com.combyne.repository.map


class SendMessageUseCase(
    private val repository: ConversationRepository
) : AsyncSuspendUseCase<ConversationModel, ResultModel<Int>> {

    override suspend fun executeAsync(rq: ConversationModel): ResultModel<Int> {
        return repository.addConversation(conversation = rq).map {
            it
        }
    }
}