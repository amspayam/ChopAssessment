package co.chop.conversation.domain

import co.chop.conversation.domain.model.ConversationModel
import com.combyne.core.usecase.AsyncSuspendUseCase
import com.combyne.repository.ResultModel
import com.combyne.repository.map


class SendMessageUseCase(
    private val repository: ConversationRepository
) : AsyncSuspendUseCase<ConversationModel, ResultModel<Boolean>> {

    override suspend fun executeAsync(rq: ConversationModel): ResultModel<Boolean> {
        return repository.addConversation(conversation = rq).map {
            it
        }
    }
}